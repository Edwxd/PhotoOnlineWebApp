package com.edward.photoonlineprintingwebservice.photoManagementSubdomain.buisnesslayer;

import com.edward.photoonlineprintingwebservice.common.PhotoIdentifier;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer.Photo;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer.PhotoRepository;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datamapperlayer.PhotoRequestMapper;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datamapperlayer.PhotoResponseMapper;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer.PhotoRequestModel;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer.PhotoResponseModel;
import com.edward.photoonlineprintingwebservice.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhotoServiceImpl implements PhotoService {

    private PhotoRepository photoRepository;

   private PhotoRequestMapper photoRequestMapper;

   private PhotoResponseMapper photoResponseMapper;

    public PhotoServiceImpl(PhotoRepository photoRepository,
                            PhotoRequestMapper photoRequestMapper,
                            PhotoResponseMapper photoResponseMapper) {

        this.photoRepository = photoRepository;
        this.photoRequestMapper = photoRequestMapper;
        this.photoResponseMapper = photoResponseMapper;
    }

    @Override
    public List<PhotoResponseModel> getAllPhotos(){
        List<Photo>photos = photoRepository.findAll();
        return  photoResponseMapper.enityListToResponseModelList(photos);
    }

    @Override
    public PhotoResponseModel getPhotoByPhotoId(String photoId){

        Photo photo = photoRepository.findByPhotoIdentifier_PhotoId(photoId);


        if(photo == null){

            throw new NotFoundException("Unknown photoId: " + photoId);
        }

        return photoResponseMapper.entityToResponseModel(photo);
    }


    @Override
    public PhotoResponseModel addPhoto(PhotoRequestModel photoRequestModel){

        Photo photo = photoRequestMapper.requestPhotoToEntity(photoRequestModel, new PhotoIdentifier());
        return photoResponseMapper.entityToResponseModel(photoRepository.save(photo));
    }

    @Override
    public PhotoResponseModel updatePhoto(PhotoRequestModel photoRequestModel, String photoId){
        Photo existingPhoto = photoRepository.findByPhotoIdentifier_PhotoId(photoId);

        if(existingPhoto == null){


            throw  new NotFoundException("No photo found with Id: " + photoId);

        }

        Photo updatedPhoto = photoRequestMapper.requestPhotoToEntity(photoRequestModel, existingPhoto.getPhotoIdentifier());
        updatedPhoto.setId(existingPhoto.getId());

        Photo response = photoRepository.save(updatedPhoto);
        return photoResponseMapper.entityToResponseModel(response);
    }

    @Override
    public void deletePhoto(String photoId){

        Photo existingPhoto = photoRepository.findByPhotoIdentifier_PhotoId(photoId);

        if(existingPhoto == null){

            throw new NotFoundException("No photo found with Id: " + photoId);
        }

        photoRepository.delete(existingPhoto);
    }
}
