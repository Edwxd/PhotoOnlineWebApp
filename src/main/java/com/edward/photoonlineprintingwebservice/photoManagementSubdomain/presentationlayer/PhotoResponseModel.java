package com.edward.photoonlineprintingwebservice.photoManagementSubdomain.presentationlayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class PhotoResponseModel extends RepresentationModel<PhotoResponseModel> {

    private String photoId;

    private String dimensions;
    private String color;
    private String framing;
    private Boolean gift_wrap;

}
