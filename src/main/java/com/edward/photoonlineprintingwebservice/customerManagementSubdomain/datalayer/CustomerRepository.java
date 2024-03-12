package com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByCustomerIdentifier_CustomerId(String customerId);
}
