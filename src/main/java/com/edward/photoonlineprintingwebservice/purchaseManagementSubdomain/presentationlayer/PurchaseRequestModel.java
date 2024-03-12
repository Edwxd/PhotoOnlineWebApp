package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.presentationlayer;

import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer.Status;
import com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer.Type_Of_Payment;
import lombok.*;


@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseRequestModel {


    private String photoId;
    private String deliveryId;

    private String sub_Total;
    private String total;
    private Type_Of_Payment typeOfPayment;
    private Status status;
    /*private Order order;*/

}
