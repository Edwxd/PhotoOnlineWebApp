package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.buinsesslayer;

import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.presentationlayer.PurchaseRequestModel;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.presentationlayer.PurchaseResponseModel;

import java.util.List;

public interface PurchaseService {

    List<PurchaseResponseModel> getAllPurchasesForCustomers(String customerId);

    PurchaseResponseModel getCustomerPurchaseByPurchaseId(String customerId, String purchaseId);

    PurchaseResponseModel addPurchaseToCustomers(PurchaseRequestModel purchaseRequestModel, String customerId);

    PurchaseResponseModel updateCustomerPurchase(PurchaseRequestModel purchaseRequestModel, String customerId, String purchaseId);

    void removePurchaseFromCustomers(String customerId, String purchaseId);

}
