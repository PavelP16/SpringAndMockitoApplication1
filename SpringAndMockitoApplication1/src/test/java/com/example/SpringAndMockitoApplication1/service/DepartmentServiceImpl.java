package com.example.SpringAndMockitoApplication1.service;

import com.example.SpringAndMockitoApplication1.model.Employee;
import org.springframework.stereotype.Service;

;import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override


    public Integer getSumSalaryByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartmentNumber().equals(departmentId))
                .map(Employee::getSalary)
                .mapToInt(Integer::intValue)
                .sum();

    }


    @Override
    public Employee getEmployeeWithMaxSalaryByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(e -> e.getDepartmentNumber().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }
    @Override
    public Employee getEmployeeWithMinSalaryByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(e -> e.getDepartmentNumber() .equals( departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }
    @Override
    public List<Employee> getAllEmployeesByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(e -> e.getDepartmentNumber().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees() {
        return employeeService.getAllEmployees().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentNumber));
    }
}
