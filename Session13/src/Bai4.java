import java.util.LinkedList;

public class Bai4 {
    private LinkedList<String> queue = new LinkedList<>();

    public void patientCheckIn(String name) {
        queue.addLast(name);
        System.out.println(name + " da check-in.");
    }

    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
        System.out.println(name + " cap cuu - chen vao dau hang doi!");
    }

    public void treatPatient() {
        if (queue.isEmpty()) {
            System.out.println("Khong co benh nhan trong hang doi.");
            return;
        }
        String patient = queue.removeFirst();
        System.out.println("Dang kham: " + patient);
    }

    public static void main(String[] args) {
        Bai4 er = new Bai4();
        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        System.out.println("\n--- Bac si bat dau kham ---");
        String p1 = er.queue.removeFirst();
        System.out.println("Dang cap cuu: " + p1);
        String p2 = er.queue.removeFirst();
        System.out.println("Dang kham: " + p2);
        String p3 = er.queue.removeFirst();
        System.out.println("Dang kham: " + p3);
    }
}
