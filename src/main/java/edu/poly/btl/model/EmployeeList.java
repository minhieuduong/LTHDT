/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poly.btl.model;
import edu.poly.btl.helper.XFile;
import java.io.File;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class EmployeeList {
    private ArrayList<Employee> list = new ArrayList<>();
    private String path ="D:/bai tap/lthdt/BTL/employees.txt";
    public void saveToFile() throws Exception{
        XFile.writeObject(path, list);
    }
    public void loadFromFile() throws Exception{
        File file = new File(path);
        if(file.exists()){
             list = (ArrayList<Employee>) XFile.readObject(path);
        }
        else{
            initEmployeeData();
        }
    }
    private void initEmployeeData(){
        
        list.add(new Employee ("E01","Hoàng Tô Lập","lap@gmail.com",500,20));
        list.add(new Employee ("E02","Hoàng thanh Tú","tu@gmail.com",500,20));
        list.add(new Employee ("E03","Hoàng A Minh","minh@gmail.com",500,24));
        list.add(new Employee ("E04","Hoàng lan Anh","anh@gmail.com",600,20));
    
    }
    private int currentIndex = -1;
    public String getCurrentEmployeeInfo(){
        return "Record" +(currentIndex+1)+ " of " + list.size();
    }
    public void setCurrentEmployee(Employee emp){
        currentIndex = list.indexOf(emp);
    }
    public void first(){
        if(currentIndex>0){
            currentIndex=0;
        }
    }
    public void previcious(){
        if(currentIndex>0){
            currentIndex--;
        }
    }
    public void next(){
        if(currentIndex < list.size()-1){
         currentIndex++;
    }
        
        }
    public void last(){
        currentIndex = list.size()-1;
    }
    public int getCurrentEmployeeIndex(){
        return currentIndex;
    }

  
    public Employee getCurrentEmployee(){
      if(list.size()==0)
          return null;
      return list.get(currentIndex);
  
  }
    public void add(Employee emp){
        list.add(emp);
    }
    public boolean update(Employee emp){
        Employee existedEmp = findById(emp.getEmployeeId());
        boolean flag = false;
        if(existedEmp != null){
            existedEmp.setName(emp.getName());
            existedEmp.setAge(emp.getAge());
            existedEmp.setEmail(emp.getEmail());
            existedEmp.setSalary(emp.getSalary());
            flag = true;
        }
        return flag;
    }
    public void renderToTable(DefaultTableModel tblModel){
        tblModel.setRowCount(0);
        for(Employee employee : list){
            Object [] row = new Object []{
                employee.getEmployeeId(),employee.getName(),employee.getAge(),employee.getEmail(),employee.getSalary()
            };
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }
    public Employee findById(String employeeId){
        for(Employee employee : list){
            if(employee.getEmployeeId().equals(employeeId)){
                return employee;
            }
        }
        return null;
    }
    public boolean deleteById(String employeeId){
        for(Employee employee : list){
            if(employee.getEmployeeId().equals(employeeId)){
                list.remove(employee);
                return true;
            }
    }
        return false;
}
    }
