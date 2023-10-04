package com.orkhanmamedov.spring.rest.dao;

import com.orkhanmamedov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getListOfEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public void deleteEmployee(int id);
}
