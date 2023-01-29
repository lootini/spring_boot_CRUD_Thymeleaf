package com.webDev.Complet_CRUD.controller;

import com.webDev.Complet_CRUD.entity.Employee;
import com.webDev.Complet_CRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //display list of employees
    @GetMapping(value = "/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployee());
        return"index";
    }

    @GetMapping(value = "showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        //Create model attribute to bind from data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping(value = "/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping(value = "/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        //Get employee from service
        Employee employee = employeeService.getEmployeeById(id);

        //Set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        //call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "employee_deleted";
    }
}
