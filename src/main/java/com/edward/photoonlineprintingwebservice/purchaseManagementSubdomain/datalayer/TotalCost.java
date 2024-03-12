package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class TotalCost {

    private String sub_Total;

    private String total;

    public TotalCost(@NotNull String sub_Total, @NotNull String total) {
        this.sub_Total = sub_Total;
        this.total = total;
    }

}
