package com.example.SpringAndMockitoApplication1.service;

import com.example.SpringAndMockitoApplication1.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Integer getSumSalaryByDepartment(Integer departmentId);

    List<Employee>  getAllEmployeesByDepartment(Integer departmentId);

    Employee getEmployeeWithMaxSalaryByDepartment(Integer departmentId);

    Employee getEmployeeWithMinSalaryByDepartment(Integer departmentId);


    Map<Integer, List<Employee>> getGroupedByDepartmentEmployees();

}
