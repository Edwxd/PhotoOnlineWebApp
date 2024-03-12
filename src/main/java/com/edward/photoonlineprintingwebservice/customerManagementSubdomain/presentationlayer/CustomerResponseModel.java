package com.edward.photoonlineprintingwebservice.customerManagementSubdomain.presentationlayer;

import com.edward.photoonlineprintingwebservice.customerManagementSubdomain.datalayer.PhoneNumberInformation;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomerResponseModel extends RepresentationModel<CustomerResponseModel> {

    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private List<PhoneNumberInformation> phoneNumbers;
}
