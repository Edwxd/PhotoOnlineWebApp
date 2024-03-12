package com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    Photo findByPhotoIdentifier_PhotoId(String photoId);
}
