package com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datamapperlayer;

import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer.Photo;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer.PhotoController;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer.PhotoResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface PhotoResponseMapper {

    @Mapping(expression = "java(photo.getPhotoIdentifier().getPhotoId())", target = "photoId")
    PhotoResponseModel entityToResponseModel(Photo photo);

    List<PhotoResponseModel> enityListToResponseModelList(List<Photo> photos);


    @AfterMapping
    default void addLinks(@MappingTarget PhotoResponseModel photoModel, Photo photo){

        Link selfLink = linkTo(methodOn(PhotoController.class).getPhotoByPhotoId(photoModel.getPhotoId()))
                .withSelfRel();

        photoModel.add(selfLink);

        Link allPhotosLink = linkTo(methodOn(PhotoController.class).getAllPhotos()).withRel("All Photos");

        photoModel.add(allPhotosLink);
    }
}
