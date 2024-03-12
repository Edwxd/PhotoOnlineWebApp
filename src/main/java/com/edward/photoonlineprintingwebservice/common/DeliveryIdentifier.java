package com.edward.photoonlineprintingwebservice.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class DeliveryIdentifier {

    private String deliveryId;

    public DeliveryIdentifier() {
        this.deliveryId = UUID.randomUUID().toString();
    }

}

