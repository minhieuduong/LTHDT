/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poly.btl.model;

/**
 *
 * @author ACER
 */
import java.io.Serializable;
public class Employee implements Serializable{
    private String employeeId , name , email;
    private float salary;
    private int age;

    public Employee() {
    }

    public Employee(String employeeId, String name, String email, float salary, int age) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
