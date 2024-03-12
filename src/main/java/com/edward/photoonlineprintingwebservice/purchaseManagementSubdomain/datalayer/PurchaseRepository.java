package com.edward.photoonlineprintingwebservice.purchaseManagementSubdomain.datalayer;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {

    Purchase findPurchaseByCustomerIdentifier_CustomerIdAndPurchaseIdentifier_PurchaseId(String customerId, String purchaseId);

    List<Purchase> findPurchaseByCustomerIdentifier_CustomerId(String customerId);




}

