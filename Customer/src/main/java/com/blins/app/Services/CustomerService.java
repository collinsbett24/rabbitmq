package com.blins.app.Services;

import com.blins.app.Entity.Customer;
import com.blins.app.Pojos.CustomerRegistrationRequest;
import com.blins.app.Repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer = Customer.builder()
                .firstName(
                customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email()).build();

        //todo:check if email is valid
        //todo:check if email not taken
        //todo:store customer in db
        customerRepository.save(customer);
    }
}
