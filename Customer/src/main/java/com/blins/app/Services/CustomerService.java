package com.blins.app.Services;

import com.blins.app.Entity.Customer;
import com.blins.app.FraudCheckResponse;
import com.blins.app.Pojos.CustomerRegistrationRequest;
import com.blins.app.Repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service

public class CustomerService {

    private  final CustomerRepository customerRepository;
    private  final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer = Customer.builder()
                .firstName(
                customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email()).build();

        //todo:check if email is valid
        //todo:check if email not taken
        //todo:store customer in db
        customerRepository.saveAndFlush(customer);

        //todo:check if fraudster

       FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check", FraudCheckResponse.class,customer.getId()
        );

       if (fraudCheckResponse.isFradulent()){
           throw new IllegalStateException("fraudster");
       }
        //todo:send notification
    }
}
