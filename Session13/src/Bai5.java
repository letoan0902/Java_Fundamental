import java.util.*;

public class Bai5 {
    static List<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== QUAN LY BENH NHAN =====");
            System.out.println("1. Tiep nhan benh nhan");
            System.out.println("2. Cap nhat chan doan");
            System.out.println("3. Xuat vien");
            System.out.println("4. Sap xep danh sach");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updateDiagnosis();
                    break;
                case 3:
                    discharge();
                    break;
                case 4:
                    sortPatients();
                    break;
                case 5:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 5);
    }

    static void addPatient() {
        System.out.print("Nhap ID: ");
        String id = sc.nextLine();
        for (Patient p : patients) {
            if (p.id.equals(id)) {
                System.out.println("ID da ton tai!");
                return;
            }
        }
        System.out.print("Nhap ho ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap chan doan: ");
        String diagnosis = sc.nextLine();
        patients.add(new Patient(id, name, age, diagnosis));
        System.out.println("Tiep nhan thanh cong!");
    }

    static void updateDiagnosis() {
        System.out.print("Nhap ID benh nhan: ");
        String id = sc.nextLine();
        for (Patient p : patients) {
            if (p.id.equals(id)) {
                System.out.print("Nhap chan doan moi: ");
                p.diagnosis = sc.nextLine();
                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay benh nhan voi ID: " + id);
    }

    static void discharge() {
        System.out.print("Nhap ID benh nhan xuat vien: ");
        String id = sc.nextLine();
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            if (it.next().id.equals(id)) {
                it.remove();
                System.out.println("Xuat vien thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay benh nhan voi ID: " + id);
    }

    static void sortPatients() {
        patients.sort((a, b) -> {
            if (b.age != a.age)
                return b.age - a.age;
            return a.fullName.compareTo(b.fullName);
        });
        System.out.println("Danh sach sau khi sap xep:");
        System.out.printf("%-10s %-20s %-5s %-20s%n", "ID", "Ho Ten", "Tuoi", "Chan Doan");
        for (Patient p : patients) {
            System.out.printf("%-10s %-20s %-5d %-20s%n", p.id, p.fullName, p.age, p.diagnosis);
        }
    }
}

class Patient {
    String id;
    String fullName;
    int age;
    String diagnosis;

    Patient(String id, String fullName, int age, String diagnosis) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }
}
