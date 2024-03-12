package com.edward.photoonlineprintingwebservice.customerManagementSubdomain.busnesslayer;


import com.edward.photoonlineprintingwebservice.common.CustomerIdentifier;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer.Address;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer.Customer;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer.CustomerRepository;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datamapperlayer.CustomerRequestMapper;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datamapperlayer.CustomerResponseMapper;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.presentationlayer.CustomerRequestModel;
import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.presentationlayer.CustomerResponseModel;
import com.edward.photoonlineprintingwebservice.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    private final CustomerRequestMapper customerRequestMapper;

    private final CustomerResponseMapper customerResponseMapper;


    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerRequestMapper customerRequestMapper,
                               CustomerResponseMapper customerResponseMapper) {

        this.customerRepository = customerRepository;
        this.customerRequestMapper = customerRequestMapper;
        this.customerResponseMapper = customerResponseMapper;
    }

    @Override
    public List<CustomerResponseModel> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerResponseMapper.entityListToResponseModelList(customers);
    }

    @Override
    public CustomerResponseModel getCustomerByCustomerId(String customerId) {
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        if(customer == null) {
        throw new NotFoundException("Unknown customer id: " + customerId);
        }

        return customerResponseMapper.entityToResponseModel(customer);

    }

    @Override
    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel) {

        Address address = new Address(customerRequestModel.getStreetAddress(), customerRequestModel.getCity(),
                customerRequestModel.getState(), customerRequestModel.getCountry(),
                customerRequestModel.getPostalCode());

        Customer customer = customerRequestMapper.requestModelToEntity(customerRequestModel,
                new CustomerIdentifier(), address);

        customer.setAddress(address);
        return  customerResponseMapper.entityToResponseModel(customerRepository.save(customer));

    }

    @Override
    public CustomerResponseModel updateCustomer(CustomerRequestModel customerRequestModel, String customerId) {
        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        if(existingCustomer == null){
            throw new NotFoundException("Unknown customerId: " + customerId);
        }

        Address address = new Address(customerRequestModel.getStreetAddress(), customerRequestModel.getCity(),
                customerRequestModel.getState(), customerRequestModel.getCountry(),
                customerRequestModel.getPostalCode());

        Customer updatedcustomer = customerRequestMapper.requestModelToEntity(customerRequestModel,
                existingCustomer.getCustomerIdentifier(), address);

        updatedcustomer.setId(existingCustomer.getId());

        Customer response = customerRepository.save(updatedcustomer);

        return customerResponseMapper.entityToResponseModel(response);
    }

    @Override
    public void removeCustomer(String customerId) {

        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        if(existingCustomer == null){

            throw new NotFoundException("Unknown customerId: " + customerId);
        }

        customerRepository.delete(existingCustomer);
    }

}
