package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datamapperlayer;

import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer.Customer;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.presentationlayer.CustomerController;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.datalayer.Delivery;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.presentationlayer.DeliveryController;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer.Photo;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer.PhotoController;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer.Purchase;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.presentationlayer.CustomerPurchaseController;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.presentationlayer.PurchaseResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface PurchaseResponseMapper {

    @Mapping(expression = "java(purchase.getPurchaseIdentifier().getPurchaseId())", target = "purchaseId")

    @Mapping(expression = "java(customer.getFirstName())", target = "firstName")
    @Mapping(expression = "java(customer.getLastName())", target = "lastName")
    @Mapping(expression = "java(customer.getCustomerIdentifier().getCustomerId())", target = "customerId")
    @Mapping(expression = "java(customer.getAddress().getStreetAddress())", target = "streetAddress")
    @Mapping(expression = "java(customer.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(customer.getAddress().getState())", target = "state")
    @Mapping(expression = "java(customer.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(customer.getAddress().getPostalCode())", target = "postalCode")

    @Mapping(expression = "java(photo.getPhotoIdentifier().getPhotoId())", target = "photoId")
    @Mapping(expression = "java(photo.getDimensions())", target = "dimensions")
    @Mapping(expression = "java(photo.getColor())", target = "color")
    @Mapping(expression = "java(photo.getFraming())", target = "framing")
    @Mapping(expression = "java(photo.getGift_wrap())", target = "gift_wrap")

    @Mapping(expression = "java(delivery.getDeliveryIdentifier().getDeliveryId())", target = "deliveryId")
    @Mapping(expression = "java(delivery.getArrivalInformation().getDate())", target = "date")
    @Mapping(expression = "java(delivery.getArrivalInformation().getTime())", target = "time")
    @Mapping(expression = "java(delivery.getDelivery_Instructions())", target = "delivery_Instructions")
    @Mapping(expression = "java(delivery.getCompany())", target = "company")

    @Mapping(expression = "java(purchase.getTotalCost().getSub_Total())", target = "sub_Total")
    @Mapping(expression = "java(purchase.getTotalCost().getTotal())", target = "total")
    PurchaseResponseModel entityToResponseModel(Purchase purchase, Customer customer, Photo photo, Delivery delivery);


    @AfterMapping
    default void addLinks(@MappingTarget PurchaseResponseModel purchaseResponseModel) {

//       Purchase link
        Link purchaseLink =
                linkTo(methodOn(CustomerPurchaseController.class)
                        .getPurchaseForCustomerByPurchaseId(purchaseResponseModel.getCustomerId(), purchaseResponseModel.getPurchaseId())).withSelfRel();
        purchaseResponseModel.add(purchaseLink);

        Link allPurchasesLink =
                linkTo(methodOn(CustomerPurchaseController.class)
                        .getAllPurchasesForCustomer(purchaseResponseModel.getCustomerId()))
                        .withRel("All Purchases").withRel("Customer purchases:");
        purchaseResponseModel.add(allPurchasesLink);

//        Customer link
        Link customerLink =
                linkTo(methodOn(CustomerController.class).getCustomerByCustomerId(purchaseResponseModel
                        .getCustomerId())).withSelfRel().withRel("Customer:");
        purchaseResponseModel.add(customerLink);


//        Deliveries link
        Link deliveriesLink =
                linkTo(methodOn(DeliveryController.class).getDeliveryByDeliveryId(purchaseResponseModel
                        .getDeliveryId())).withSelfRel().withRel("Delivery:");
        purchaseResponseModel.add(deliveriesLink);


        Link photosLink = linkTo(methodOn(PhotoController.class).getPhotoByPhotoId(purchaseResponseModel.getPhotoId()))
                .withSelfRel().withRel("Photo:");
        purchaseResponseModel.add(photosLink);

    }
}
