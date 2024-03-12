package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.presentationlayer;

import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer.PhoneNumberInformation;
import com.edward.photoonlineprintingwebservice.delivaryManagementSubdomain.datalayer.Companies;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer.Color;
import com.edward.photoonlineprintingwebservice.photoManagementSubdomain.datalayer.FramingOptions;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PurchaseResponseModel extends RepresentationModel<PurchaseResponseModel> {

    private String purchaseId;

    private String customerId;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String postalCode;


    private String photoId;
    private String dimensions;
    private Color color;
    private FramingOptions framing;
    private Boolean gift_wrap;

    private String deliveryId;
    private Companies company;
    private String delivery_Instructions;
    private String date;
    private String time;

    private String sub_Total;
    private String total;
    private Type_Of_Payment typeOfPayment;
    private Status status;
    /*private Order order;*/
}
