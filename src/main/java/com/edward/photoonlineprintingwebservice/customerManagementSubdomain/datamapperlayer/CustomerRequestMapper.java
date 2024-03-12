package com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datamapperlayer;

import com.edward.photoonlineprintingwebservice.common.CustomerIdentifier;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer.Address;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer.Customer;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.presentationlayer.CustomerRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    Customer requestModelToEntity(CustomerRequestModel customerRequestModel, CustomerIdentifier customerIdentifier,
                                  Address address);
}
