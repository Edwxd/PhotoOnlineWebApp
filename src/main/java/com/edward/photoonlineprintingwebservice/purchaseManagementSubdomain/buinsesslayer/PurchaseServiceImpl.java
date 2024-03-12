package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.buinsesslayer;

import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer.Customer;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer.CustomerRepository;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.datalayer.Delivery;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.datalayer.DeliveryRepository;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer.Photo;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer.PhotoRepository;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer.*;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datamapperlayer.PurchaseRequestMapper;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datamapperlayer.PurchaseResponseMapper;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.presentationlayer.PurchaseRequestModel;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.presentationlayer.PurchaseResponseModel;
import com.edward.photoonlineprintingwebservice.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;
    private final PhotoRepository photoRepository;
    private final DeliveryRepository deliveryRepository;
    private final PurchaseRequestMapper purchaseRequestMapper;
    private final PurchaseResponseMapper purchaseResponseMapper;


    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, CustomerRepository customerRepository,
                               PhotoRepository photoRepository, DeliveryRepository deliveryRepository,
                               PurchaseRequestMapper purchaseRequestMapper, PurchaseResponseMapper purchaseResponseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
        this.photoRepository = photoRepository;
        this.deliveryRepository = deliveryRepository;
        this.purchaseRequestMapper = purchaseRequestMapper;
        this.purchaseResponseMapper = purchaseResponseMapper;
    }

    @Override
    public List<PurchaseResponseModel> getAllPurchasesForCustomers(String customerId) {
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if(customer == null) {
            throw new NotFoundException("Customer Id provided is invalid: " + customerId);
        }

        List<PurchaseResponseModel> purchaseResponseModelList = new ArrayList<>();
        List<Purchase> purchaseList = purchaseRepository.findPurchaseByCustomerIdentifier_CustomerId(customerId);

        purchaseList.forEach(purchase -> {

            Photo photo = photoRepository.findByPhotoIdentifier_PhotoId(purchase.getPhotoIdentifier().getPhotoId());
            if(photo == null) {
                throw new NotFoundException("Photo Id provided is invalid: " + purchase.getPhotoIdentifier().getPhotoId());
            }

            Delivery delivery = deliveryRepository.findByDeliveryIdentifier_DeliveryId(purchase.getDeliveryIdentifier().getDeliveryId());
            if(delivery == null) {
                throw new NotFoundException("Photo Id provided is invalid: " + purchase.getDeliveryIdentifier().getDeliveryId());
            }

            purchaseResponseModelList.add(purchaseResponseMapper.entityToResponseModel(purchase, customer, photo, delivery));

        });

        return purchaseResponseModelList;
    }

    @Override
    public PurchaseResponseModel getCustomerPurchaseByPurchaseId(String customerId, String purchaseId) {
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if(customer == null) {
            throw new NotFoundException("Customer Id provided is invalid: " + customerId);
        }

        Purchase purchase = purchaseRepository.findPurchaseByCustomerIdentifier_CustomerIdAndPurchaseIdentifier_PurchaseId(customerId,purchaseId);
        if(purchase == null) {
            throw new NotFoundException("Photo Id provided is invalid: " + purchaseId);
        }

        Photo photo = photoRepository.findByPhotoIdentifier_PhotoId(purchase.getPhotoIdentifier().getPhotoId());
        if(photo == null) {
            throw new NotFoundException("Photo Id provided is invalid: " + purchase.getPhotoIdentifier().getPhotoId());
        }

        Delivery delivery = deliveryRepository.findByDeliveryIdentifier_DeliveryId(purchase.getDeliveryIdentifier().getDeliveryId());
        if(delivery == null) {
            throw new NotFoundException("Photo Id provided is invalid: " + purchase.getDeliveryIdentifier().getDeliveryId());
        }

        return purchaseResponseMapper.entityToResponseModel(purchase, customer, photo, delivery);
    }

    @Override
    public PurchaseResponseModel addPurchaseToCustomers(PurchaseRequestModel purchaseRequestModel, String customerId) {
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if(customer == null) {
            throw new NotFoundException("Customer Id provided is invalid: " + customerId);
        }

        Photo photo = photoRepository.findByPhotoIdentifier_PhotoId(purchaseRequestModel.getPhotoId());
        if(photo == null) {
            throw new NotFoundException("Photo Id provided is invalid: " + purchaseRequestModel.getPhotoId());
        }

        Delivery delivery = deliveryRepository.findByDeliveryIdentifier_DeliveryId(purchaseRequestModel.getDeliveryId());
        if(delivery == null) {
            throw new NotFoundException("Photo Id provided is invalid: " + purchaseRequestModel.getDeliveryId() );
        }


        Purchase purchase = purchaseRequestMapper.requestModelToEntity(purchaseRequestModel, new PurchaseIdentifier(),
                customer.getCustomerIdentifier(), photo.getPhotoIdentifier(), delivery.getDeliveryIdentifier(),
                new TotalCost(purchaseRequestModel.getSub_Total(), purchaseRequestModel.getTotal()));

        Purchase savedPurchase = purchaseRepository.save(purchase);


        return purchaseResponseMapper.entityToResponseModel(savedPurchase, customer, photo, delivery);
    }

    @Override
    public PurchaseResponseModel updateCustomerPurchase(PurchaseRequestModel purchaseRequestModel, String customerId, String purchaseId) {
        Purchase existingPurchase = purchaseRepository.findPurchaseByCustomerIdentifier_CustomerIdAndPurchaseIdentifier_PurchaseId(customerId, purchaseId);

        if(existingPurchase == null){

            throw new NotFoundException("PurchaseId provided is unknown: " + purchaseId);
        }

        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if(existingCustomer == null){

            throw new NotFoundException("CustomerId provided is unknown: " + customerId);
        }

        Photo existingPhoto = photoRepository.findByPhotoIdentifier_PhotoId(purchaseRequestModel.getPhotoId());
        if(existingPhoto == null){

            throw new NotFoundException("PhotoId provided is unknown: " + purchaseRequestModel.getPhotoId());
        }

        Delivery existingDelivery = deliveryRepository.findByDeliveryIdentifier_DeliveryId(purchaseRequestModel.getDeliveryId());

        if (existingDelivery == null){

            throw new NotFoundException("DeliveryId provided is unknown: " + purchaseRequestModel.getDeliveryId());
        }

        Purchase purchase = purchaseRequestMapper.requestModelToEntity(purchaseRequestModel, existingPurchase.getPurchaseIdentifier(),
                existingCustomer.getCustomerIdentifier(), existingPhoto.getPhotoIdentifier(), existingDelivery.getDeliveryIdentifier(),
                new TotalCost(purchaseRequestModel.getSub_Total(), purchaseRequestModel.getTotal()));

        purchase.setId(existingPurchase.getId());
        return purchaseResponseMapper.entityToResponseModel(purchaseRepository.save(purchase), existingCustomer, existingPhoto, existingDelivery);
    }

    @Override
    public void removePurchaseFromCustomers(String customerId, String purchaseId) {

        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);
        if (customer == null) {

            throw new NotFoundException("Customer not found with id " + customerId);
        }

        Purchase purchase = purchaseRepository.findPurchaseByCustomerIdentifier_CustomerIdAndPurchaseIdentifier_PurchaseId(customerId, purchaseId);
        if(purchase == null) {

            throw new NotFoundException("Purchase not found with id " + purchaseId);
        }

        Photo photo = photoRepository.findByPhotoIdentifier_PhotoId(purchase.getPhotoIdentifier().getPhotoId());
        if (photo == null){

            throw new NotFoundException("Photo not found with id " + purchase.getPhotoIdentifier().getPhotoId());
        }

        Delivery delivery = deliveryRepository.findByDeliveryIdentifier_DeliveryId(purchase.getDeliveryIdentifier().getDeliveryId());
        if (delivery == null){

            throw new NotFoundException("Delivery not found with id " + purchase.getDeliveryIdentifier().getDeliveryId());
        }

        purchase.setStatus(Status.Canceled);
        purchaseRepository.save(purchase);
    }
}
