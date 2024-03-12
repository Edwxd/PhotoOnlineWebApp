package com.edward.photoonlineprintingwebservice.photoManagementSubdomain.buisnesslayer;


import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer.PhotoRequestModel;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer.PhotoResponseModel;

import java.util.List;
import java.util.UUID;

public interface PhotoService {

    List<PhotoResponseModel> getAllPhotos();

    PhotoResponseModel getPhotoByPhotoId(String photoId);

    PhotoResponseModel addPhoto(PhotoRequestModel photoRequestModel);

    PhotoResponseModel updatePhoto(PhotoRequestModel photoRequestModel, String photoId);

    void deletePhoto(String photoId);
}
