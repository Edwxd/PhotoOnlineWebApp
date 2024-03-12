package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer;

import com.edward.photoonlineprintingwebservice.common.PhotoIdentifier;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Embeddable
@Getter
@NoArgsConstructor
public class Order {

    private List<PhotoIdentifier> order;

    public Order(@NotNull List<PhotoIdentifier> order) {
        this.order = order;
    }
}
