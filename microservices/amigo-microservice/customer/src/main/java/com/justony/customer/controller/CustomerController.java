package com.justony.customer.controller;

import com.justony.customer.dto.CustomerRegisterRequest;
import com.justony.customer.service.CustomerService;
import com.justony.customer.dto.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j(topic = "Customer microservice: ")
@AllArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public void registerCustomer(@RequestBody CustomerRegisterRequest registerRequest) {
        log.info("New customer registered {}", registerRequest);
        customerService.registerCustomer(registerRequest);
    }

    @PostMapping("/add/{name}/{lastName}/{email}")
    public void registerCustomerWithParams(@PathVariable("name") String name, @PathVariable("lastName") String lastName, @PathVariable("email") String email) {
        log.info("New customer registered {}:{}:{}", name, lastName, email);
        customerService.registerCustomer(name, lastName, email);
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Customer> getAllCustomers() {
        log.info("Was sent all customers.");
        return customerService.getAllCustomers();
    }
}
