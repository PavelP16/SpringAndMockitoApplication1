package com.example.SpringAndMockitoApplication1.service;

import com.example.SpringAndMockitoApplication1.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee add(String firstName, String lastName, Integer departmentNumber, Integer salary);


    Employee remove(String firstName, String lastName);

    //   Collection<Employee> findAll();

    Employee find(String firstName, String lastName);

    List<Employee> allEmployees();

    String getFullName(String firstName, String lastName);

    Map<String,Employee> getAllEmployees();


}
