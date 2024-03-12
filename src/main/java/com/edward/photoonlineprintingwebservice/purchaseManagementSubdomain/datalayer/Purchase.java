package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer;

import com.edward.photoonlineprintingwebservice.common.CustomerIdentifier;
import com.edward.photoonlineprintingwebservice.common.DeliveryIdentifier;
import com.edward.photoonlineprintingwebservice.common.PhotoIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchases")
@Data
@NoArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private PurchaseIdentifier purchaseIdentifier;

    @Embedded
    private CustomerIdentifier customerIdentifier;

    @Embedded
    private DeliveryIdentifier deliveryIdentifier;

    @Embedded
    private PhotoIdentifier photoIdentifier;


    @Embedded
    private TotalCost totalCost;

    @Enumerated(EnumType.STRING)
    private Type_Of_Payment typeOfPayment;

    @Enumerated(EnumType.STRING)
    private Status status;

   /* private Order order;*/


    public Purchase(@NotNull CustomerIdentifier customerIdentifier, @NotNull DeliveryIdentifier deliveryIdentifier,
                    @NotNull PhotoIdentifier photoIdentifier, @NotNull TotalCost totalCost,
                    @NotNull Type_Of_Payment typeOfPayment, @NotNull Status status /*@NotNull Order order*/) {


        this.purchaseIdentifier = new PurchaseIdentifier();
        this.customerIdentifier = customerIdentifier;
        this.deliveryIdentifier = deliveryIdentifier;
        this.photoIdentifier = photoIdentifier;
        this.totalCost = totalCost;
        this.typeOfPayment = typeOfPayment;
        this.status = status;
        //this.order = order;
    }
}
