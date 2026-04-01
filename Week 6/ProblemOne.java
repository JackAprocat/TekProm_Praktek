import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String nama;
    private Integer uang;

    public Employee(String nama, Integer uang) {
        this.nama = nama;
        this.uang = uang;
    }

    public String getNama() {
        return nama;
    }

    public Integer getUang() {
        return uang;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Gaji: " + uang;
    }
}

public class ProblemOne {

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee("Alice", 50000));
        list.add(new Employee("bob", 70000));
        list.add(new Employee("rob", 40000));
        list.add(new Employee("john", 10000));

        // Melakukan proses filtering/sorting menggunakan Stream API
        List<Employee> sortedEmp = list.stream() // Ubah list ke stream
                // Mengurutkan employee berdasarkan nama
                .sorted((e1, e2) -> e1.getNama().compareTo(e2.getNama()))
                // Mengumpulkan hasil akhir
                .collect(Collectors.toList());

        for (Employee e : sortedEmp) {
            System.out.println(e);
        }
    }
}
// Asumsikan class Employee sudah memiliki getter getName() dan getSalary()