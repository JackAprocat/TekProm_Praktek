import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name;
    }
}

public class ProblemTwo {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(101, "Joe"),
                new Student(103, "Zulkifli"),
                new Student(102, "Riza"),
                new Student(104, "Alice"),
                new Student(105, "Joshua"));

        List<Student> ans = students.stream() // Membuka stream
                .sorted((s1, s2) -> { // Melakukan pengurutan
                    // Logika: Jika nama sama, bandingkan ID
                    if (s1.getName().equalsIgnoreCase(s2.getName())) {
                        return Integer.compare(s1.getId(), s2.getId());
                    }
                    // Jika nama berbeda, bandingkan Nama
                    else {
                        return s1.getName().compareTo(s2.getName());
                    }
                })
                .collect(Collectors.toList()); // Mengumpulkan hasil

        for (Student student : ans) {
            System.out.println(student);
        }
    }
}

// Buatlah class Student disertai dengan attribute dan method lainnya yang
// diperlukan!
