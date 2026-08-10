package com.DAO;

import java.util.List;

import com.HotelManagement.model.Employee;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    void removeEmployee(String adhaar);
    List<Employee> getListOfEmployee();
    Employee getEmployee(String adhaar);
}
