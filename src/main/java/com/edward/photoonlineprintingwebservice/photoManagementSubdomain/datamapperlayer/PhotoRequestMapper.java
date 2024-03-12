package com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datamapperlayer;

import com.edward.photoonlineprintingwebservice.common.PhotoIdentifier;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer.Photo;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer.PhotoRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PhotoRequestMapper {

  @Mappings({
          @Mapping(target = "id", ignore = true),
          //@Mapping(target = "photoIdentifier"),
  })
    Photo requestPhotoToEntity(PhotoRequestModel photoRequestModel, PhotoIdentifier photoIdentifier);

}
