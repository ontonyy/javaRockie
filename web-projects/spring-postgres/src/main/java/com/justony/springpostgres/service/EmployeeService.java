package com.justony.springpostgres.service;

import com.justony.springpostgres.model.Employee;
import com.justony.springpostgres.model.EmployeeRequest;
import com.justony.springpostgres.model.EmployeeResponse;
import com.justony.springpostgres.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired private EmployeeRepository employeeRepository;


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public EmployeeResponse save(String name, String position) {
        Employee employee = employeeRepository.getEmployeeByNameAndPosition(name, position);
        if (employee == null) {
            employee = new Employee(name, position);
            employeeRepository.save(employee);
            return new EmployeeResponse(String.format("Employee: %s - %s successfully created", name, position));
        } else {
            return new EmployeeResponse(String.format("Employee - %s %s is exists!", name, position));
        }
    }

    public boolean existsById(long id) {
        return employeeRepository.existsById(id);
    }

    public Employee findById(long id) {
        return employeeRepository.findById(id).orElseThrow(
                IllegalStateException::new
        );
    }

    public EmployeeResponse updateById(long id, EmployeeRequest request) {
        if (existsById(id)) {
            Employee employee = new Employee(id, request.name(), request.position());
            employeeRepository.save(employee);
            return new EmployeeResponse(String.format("Employee: %s-%s was successfully updated", request.name(), request.position()));
        } else {
            return new EmployeeResponse(String.format("Employee with id %s not found", id));
        }
    }

    public EmployeeResponse deleteById(long id) {
        if (existsById(id)) {
            employeeRepository.deleteById(id);
            return new EmployeeResponse(String.format("Employee with id(%s) was deleted", id));
        } else {
            return new EmployeeResponse(String.format("Employee with id %s not found", id));
        }
    }
}
