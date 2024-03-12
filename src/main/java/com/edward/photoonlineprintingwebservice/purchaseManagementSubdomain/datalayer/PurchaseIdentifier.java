package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class PurchaseIdentifier {

    private String purchaseId;

    public PurchaseIdentifier() {
        this.purchaseId = UUID.randomUUID().toString();
    }

    public PurchaseIdentifier(String purchaseId) {

        this.purchaseId = purchaseId;
    }
}
