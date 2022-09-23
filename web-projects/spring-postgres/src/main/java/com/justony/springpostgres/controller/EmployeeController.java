package com.justony.springpostgres.controller;

import com.justony.springpostgres.model.Employee;
import com.justony.springpostgres.model.EmployeeRequest;
import com.justony.springpostgres.model.EmployeeResponse;
import com.justony.springpostgres.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired private EmployeeService service;

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/employee/{id}")
    public Object getById(@PathVariable("id") long id) {
        try {
            return service.findById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new EmployeeResponse("Not found employee with id: " + id);
        }
    }

    @PutMapping("/employee/{id}")
    public EmployeeResponse insertById(@PathVariable("id") long id, @RequestBody EmployeeRequest request) {
        return service.updateById(id, request);
    }

    @DeleteMapping("/employee/{id}")
    public EmployeeResponse deleteById(@PathVariable("id") long id) {
        return service.deleteById(id);
    }

    @PostMapping("/employee")
    public EmployeeResponse insert(@RequestBody EmployeeRequest request) {
        return service.save(request.name(), request.position());
    }

}
