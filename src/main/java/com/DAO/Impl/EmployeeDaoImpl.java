package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DAO.EmployeeDAO;
import com.HotelManagement.config.DatabaseConnection;
import com.HotelManagement.model.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (name, password, adhaar, address, designation, salary) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getPassword());
                ps.setString(3, employee.getAdhaar());
                ps.setString(4, employee.getAddress());
                ps.setString(5, employee.getDesignation());
                ps.setFloat(6, employee.getSalary());

                int rows = ps.executeUpdate();
                if(rows > 0){
                    System.out.println("\nEmployee Added\n");
                }
                else{
                    System.out.println("\nTRY AGAIN\n");
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeEmployee(String adhaar) {
        String sql = "DELETE FROM employee WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, adhaar);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployee(String adhaar) {
        String sql = "SELECT * FROM employee WHERE adhaar = ?";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                ps.setString(1, adhaar);

                Employee employee = new Employee();
                while(rs.next()){
                    employee.setName(rs.getString("name"));
                    employee.setAdhaar(rs.getString("adhaar"));
                    employee.setAddress(rs.getString("address"));
                    employee.setDesignation(rs.getString("designation"));
                    employee.setSalary(rs.getFloat("salary"));
                }
                return employee;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<Employee> getListOfEmployee() {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Employee employee = new Employee();
                    employee.setName(rs.getString("name"));
                    employee.setAdhaar(rs.getString("adhaar"));
                    employee.setAddress(rs.getString("address"));
                    employee.setDesignation(rs.getString("designation"));
                    employee.setSalary(rs.getFloat("salary"));

                    employees.add(employee);
                }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return employees;
    }
    
}
