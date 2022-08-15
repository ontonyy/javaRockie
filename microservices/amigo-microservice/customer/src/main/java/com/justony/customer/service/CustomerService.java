package com.justony.customer.service;


import com.justony.customer.dto.CustomerRegisterRequest;
import com.justony.customer.dto.FraudResponse;
import com.justony.customer.repo.CustomerRepository;
import com.justony.customer.dto.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegisterRequest registerRequest) {
        registerCustomer(
                registerRequest.firstName(),
                registerRequest.lastName(),
                registerRequest.email()
        );
    }

    public void registerCustomer(String name, String lastName, String email) {
        Customer customer = Customer.builder()
                .firstName(name)
                .lastName(lastName)
                .email(email)
                .build();

        customerRepository.saveAndFlush(customer);

        FraudResponse fraudResponse = restTemplate.getForObject(
                "http://FRAUD/api/fraud/{customerId}",
                FraudResponse.class,
                customer.getId()
        );

        if (fraudResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster discovered");
        }
    }

    public @ResponseBody Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
