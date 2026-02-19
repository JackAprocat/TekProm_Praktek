import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class App {
    public static void main(String[] args) {
        System.out.println("=== MENGUJI FILE JAR ===");
        
        // Memanggil class dari dalam JAR
        Department dept = new Department("Keuangan");
        EmploymentType type = new EmploymentType("Part-Time");
        
        // Cek Auto-Increment dan Relasi
        Employee emp = new Employee("Budi", dept, type, 3000000);
        EmployeeService service = new EmployeeService();
        service.addEmployee(emp);
        
        System.out.println("Berhasil menambahkan: " + service.getEmployee(emp.getId()).getName());
        System.out.println("Total Karyawan saat ini: " + Employee.getCountEmployees());
        System.out.println("STATUS: File JAR bekerja 100% sempurna!");
    }
}