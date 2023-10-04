package com.orkhanmamedov.spring.rest.contoller;


import com.orkhanmamedov.spring.rest.entity.Employee;
import com.orkhanmamedov.spring.rest.exception_handling.EmployeeIncorrectData;
import com.orkhanmamedov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.orkhanmamedov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class MyRESTContoller {

    EmployeeService employeeService;
    @Autowired
    private void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    private List<Employee> showAllEmployees(){
        List<Employee> empList = employeeService.getListOfEmployees();
        return empList;
    }

    @GetMapping("/employees/{id}")
    private Employee getEmployeeById(@PathVariable("id") int id){

        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null) throw new NoSuchElementException("There is no employee with id=" + id);

        return employee;
    }
    @PostMapping("/employees")
    private Employee addEmployee(@RequestBody   Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    private Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;

    }
    @DeleteMapping("/employees/{id}")
    private String  deleteEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee==null) throw new NoSuchEmployeeException("No employee with id=" + id);
        employeeService.deleteEmployee(id);
        return "Employee with id=" + id  + " was deleted";
    }


}
