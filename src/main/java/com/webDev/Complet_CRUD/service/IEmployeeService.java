package com.webDev.Complet_CRUD.service;

import com.webDev.Complet_CRUD.entity.Employee;

import java.util.List;

public interface IEmployeeService  {

    List<Employee> getAllEmployee();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
