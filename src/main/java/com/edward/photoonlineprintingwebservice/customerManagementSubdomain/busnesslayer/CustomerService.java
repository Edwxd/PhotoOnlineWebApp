package com.edward.photoonlineprintingwebservice.customerManagementSubdomain.busnesslayer;

import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.presentationlayer.CustomerRequestModel;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.presentationlayer.CustomerResponseModel;

import java.util.List;

public interface CustomerService {

    List<CustomerResponseModel> getAllCustomers();

    CustomerResponseModel getCustomerByCustomerId(String customerId);

    CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel);

    CustomerResponseModel updateCustomer(CustomerRequestModel updatedCustomer, String customerId);

    void removeCustomer(String customerId);
}
