package id.ac.polban.employee;


import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM MANAJEMEN KARYAWAN ===\n");

         
        Department deptIT = new Department("Information Technology");
        EmploymentType typeFullTime = new EmploymentType("Full-Time");

       
        Employee emp1 = new Employee("Fawwaz", deptIT, typeFullTime, 5000000);
        Employee emp2 = new Employee("Hasan", deptIT, typeFullTime, 4500000);

        
        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);  
        service.addEmployee(emp2);  

        
        System.out.println("--- Data Karyawan ---");
        System.out.println("Karyawan 1: " + service.getEmployee(emp1.getId()).getName() + " | Dept: " + service.getEmployee(emp1.getId()).getDepartment().getName());
        System.out.println("Karyawan 2: " + service.getEmployee(emp2.getId()).getName() + " | Dept: " + service.getEmployee(emp2.getId()).getDepartment().getName());

         
        System.out.println("\n--- Proses Kenaikan Gaji ---");
        System.out.println("Gaji awal " + emp1.getName() + ": Rp" + emp1.getSalary());
        service.raiseSalary(emp1.getId(), 10); /*  Naik gaji 10% */
        System.out.println("Gaji baru " + emp1.getName() + ": Rp" + emp1.getSalary());

        
        System.out.println("\n--- Statistik Perusahaan ---");
        System.out.println("Total Karyawan Terdaftar: " + Employee.getCountEmployees()); 
    }
}