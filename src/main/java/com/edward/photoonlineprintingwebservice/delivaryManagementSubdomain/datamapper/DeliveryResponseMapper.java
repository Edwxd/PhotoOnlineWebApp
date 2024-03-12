package com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.datamapper;

import com.edward.photoonlineprintingwebservice.common.DeliveryIdentifier;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.datalayer.ArrivalInformation;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.datalayer.Delivery;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.presentationlayer.DeliveryController;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.presentationlayer.DeliveryRequestModel;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.presentationlayer.DeliveryResponseModel;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer.Photo;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer.PhotoController;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer.PhotoResponseModel;
import org.mapstruct.*;
import org.springframework.hateoas.Link;

import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface DeliveryResponseMapper {

    @Mapping(expression = "java(delivery.getDeliveryIdentifier().getDeliveryId())", target = "deliveryId")
    @Mapping(expression = "java(delivery.getArrivalInformation().getDate())", target = "date")
    @Mapping(expression = "java(delivery.getArrivalInformation().getTime())", target = "time")
    DeliveryResponseModel entityToResponseModel(Delivery delivery);

    List<DeliveryResponseModel> entityListToResponseModelList(List<Delivery> delivery);


    @AfterMapping
    default void addLinks(@MappingTarget DeliveryResponseModel deliveryModel, Delivery delivery){

        Link selfLink = linkTo(methodOn(DeliveryController.class)
                .getDeliveryByDeliveryId(deliveryModel.getDeliveryId()))
                .withSelfRel();

        deliveryModel.add(selfLink);

        Link allDeliveriesLink = linkTo(methodOn(DeliveryController.class).getAllDeliveries()).withRel("All Deliveries");

        deliveryModel.add(allDeliveriesLink);


    }


}
