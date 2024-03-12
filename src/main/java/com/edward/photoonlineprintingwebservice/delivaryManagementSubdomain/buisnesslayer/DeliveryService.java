package com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.buisnesslayer;

import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.presentationlayer.DeliveryRequestModel;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.presentationlayer.DeliveryResponseModel;

import java.util.List;

public interface DeliveryService {

    List<DeliveryResponseModel> getAllDelivery();

    DeliveryResponseModel getDeliveryByDeliveryId(String deliveryId);

    DeliveryResponseModel addDelivery(DeliveryRequestModel deliveryRequestModel);

    DeliveryResponseModel updateDelivery(DeliveryRequestModel deliveryRequestModel, String deliveryId);

    void removeDelivery(String deliveryId);


}
