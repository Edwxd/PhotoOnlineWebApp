package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datamapperlayer;

import com.edward.photoonlineprintingwebservice.common.CustomerIdentifier;
import com.edward.photoonlineprintingwebservice.common.DeliveryIdentifier;
import com.edward.photoonlineprintingwebservice.common.PhotoIdentifier;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer.Purchase;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer.PurchaseIdentifier;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer.TotalCost;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.presentationlayer.PurchaseRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseRequestMapper {


    @Mapping(target = "id", ignore = true)


    Purchase requestModelToEntity(PurchaseRequestModel purchaseRequestModel, PurchaseIdentifier purchaseIdentifier,
                                  CustomerIdentifier customerIdentifier, PhotoIdentifier photoIdentifier,
                                  DeliveryIdentifier deliveryIdentifier, TotalCost totalCost);
}
