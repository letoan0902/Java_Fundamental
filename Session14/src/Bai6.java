import java.util.*;

public class Bai6 {
    static class Patient {
        private final String name;
        private final int age;
        private final String department;

        Patient(String name, int age, String department) {
            this.name = name;
            this.age = age;
            this.department = department;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return "Patient(" + name + ", " + age + ")";
        }
    }

    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new Patient("Lan", 30, "Tim mạch"),
                new Patient("Hùng", 41, "Nội tiết"),
                new Patient("Mai", 26, "Tim mạch"),
                new Patient("Duy", 52, "Tim mạch")
        );

        Map<String, List<Patient>> byDept = new HashMap<>();
        for (Patient p : patients) {
            byDept.computeIfAbsent(p.getDepartment(), k -> new ArrayList<>()).add(p);
        }

        for (Map.Entry<String, List<Patient>> e : byDept.entrySet()) {
            System.out.println("Key \"" + e.getKey() + "\" -> Value " + e.getValue());
        }

        String queryDept = "Tim mạch";
        List<Patient> deptPatients = byDept.getOrDefault(queryDept, Collections.emptyList());
        System.out.println("Danh sách bệnh nhân khoa \"" + queryDept + "\": " + deptPatients);

        String maxDept = null;
        int max = -1;
        for (Map.Entry<String, List<Patient>> e : byDept.entrySet()) {
            int size = e.getValue().size();
            if (size > max || (size == max && (maxDept == null || e.getKey().compareTo(maxDept) < 0))) {
                max = size;
                maxDept = e.getKey();
            }
        }

        if (maxDept != null) {
            System.out.print("Khoa " + maxDept + " đang đông nhất (" + max + " bệnh nhân)");
        }
    }
}
