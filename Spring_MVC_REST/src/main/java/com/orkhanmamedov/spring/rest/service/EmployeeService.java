package com.orkhanmamedov.spring.rest.service;

import com.orkhanmamedov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getListOfEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    void deleteEmployee(int id);
}
