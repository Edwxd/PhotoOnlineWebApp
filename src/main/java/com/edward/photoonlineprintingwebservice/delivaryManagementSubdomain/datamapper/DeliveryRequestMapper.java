package com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.datamapper;

import com.edward.photoonlineprintingwebservice.common.DeliveryIdentifier;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.datalayer.ArrivalInformation;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.datalayer.Delivery;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.presentationlayer.DeliveryRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DeliveryRequestMapper {

    @Mappings({

            @Mapping(target = "id", ignore = true)
    })

    Delivery requestModelToEntity(DeliveryRequestModel deliveryRequestModel, DeliveryIdentifier deliveryIdentifier,
                                  ArrivalInformation arrivalInformation);
}
