package Soal_3;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // Menaikkan gaji
        for (Employee e : staff) e.raiseSalary(5);

        // Menguji metode compare
        int result = staff[0].compare(staff[1]);
        if (result < 0) {
            System.out.println(staff[0].getName() + " gaji lebih kecil dari " + staff[1].getName());
        }

        // Mencetak data
        for (Employee e : staff) e.print();
    }
}