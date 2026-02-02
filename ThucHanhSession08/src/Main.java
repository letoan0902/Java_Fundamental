import java.util.Scanner;

public class Main {
    private static final int DEFAULT_CAPACITY = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager(DEFAULT_CAPACITY);

        while (true) {
            printMenu();
            int choice = readIntInRange(sc, "Chon chuc nang (1-9): ", 1, 9);

            switch (choice) {
                case 1:
                    addStudentUI(sc, manager);
                    break;
                case 2:
                    manager.displayStudentList();
                    break;
                case 3:
                    System.out.print("Nhap ma SV hoac ten can tim: ");
                    String keyword = sc.nextLine();
                    manager.findByKeyword(keyword);
                    break;
                case 4:
                    updateStudentUI(sc, manager);
                    break;
                case 5:
                    System.out.print("Nhap ma SV can xoa: ");
                    String maXoa = sc.nextLine();
                    manager.deleteStudentById(maXoa);
                    break;
                case 6:
                    System.out.print("Nhap ma SV can tinh DTB & xep loai: ");
                    String maTinh = sc.nextLine();
                    manager.printAvgAndRank(maTinh);
                    break;
                case 7:
                    sortUI(sc, manager);
                    break;
                case 8:
                    manager.thongKe();
                    break;
                case 9:
                    System.out.println("Tam biet!");
                    return;
                default:
                    // never happens due to validation
                    break;
            }

            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===== QUAN LY SINH VIEN =====");
        System.out.println("1. Them sinh vien moi");
        System.out.println("2. Hien thi tat ca sinh vien");
        System.out.println("3. Tim kiem sinh vien");
        System.out.println("4. Cap nhat thong tin sinh vien");
        System.out.println("5. Xoa sinh vien");
        System.out.println("6. Tinh diem trung binh va xep loai");
        System.out.println("7. Sap xep sinh vien");
        System.out.println("8. Thong ke");
        System.out.println("9. Thoat");
    }

    private static void addStudentUI(Scanner sc, StudentManager manager) {
        if (manager.isFull()) {
            System.out.println("Mang da day, khong the them!");
            return;
        }

        String maSV;
        do {
            System.out.print("Nhap ma SV: ");
            maSV = sc.nextLine();
            if (maSV.isBlank()) {
                System.out.println("Ma SV khong duoc de trong!");
                continue;
            }
            if (manager.findByMaSV(maSV) != null) {
                System.out.println("Ma sinh vien da ton tai!");
                maSV = "";
            }
        } while (maSV.isBlank());

        String hoTen;
        do {
            System.out.print("Nhap ho ten: ");
            hoTen = sc.nextLine();
            if (hoTen.isBlank()) {
                System.out.println("Ho ten khong duoc de trong!");
            }
        } while (hoTen.isBlank());

        int tuoi = readIntInRange(sc, "Nhap tuoi (18-30): ", 18, 30);

        String gioiTinh;
        do {
            System.out.print("Nhap gioi tinh (Nam/Nu): ");
            gioiTinh = sc.nextLine();
            if (!gioiTinh.equalsIgnoreCase("Nam") && !gioiTinh.equalsIgnoreCase("Nu")) {
                System.out.println("Gioi tinh khong hop le!");
                gioiTinh = "";
            }
        } while (gioiTinh.isBlank());

        double diemToan = readDoubleInRange(sc, "Nhap diem toan (0-10): ", 0, 10);
        double diemLy = readDoubleInRange(sc, "Nhap diem ly (0-10): ", 0, 10);
        double diemHoa = readDoubleInRange(sc, "Nhap diem hoa (0-10): ", 0, 10);

        Student s = new Student(maSV, hoTen, tuoi, gioiTinh, diemToan, diemLy, diemHoa);
        manager.addStudent(s);
    }

    private static void updateStudentUI(Scanner sc, StudentManager manager) {
        System.out.print("Nhap ma sinh vien muon cap nhat: ");
        String maSV = sc.nextLine();
        Student existing = manager.findByMaSV(maSV);

        if (existing == null) {
            System.out.println("Khong tim thay sinh vien");
            return;
        }

        String hoTen;
        do {
            System.out.print("Nhap ten sinh vien: ");
            hoTen = sc.nextLine();
            if (hoTen.isBlank()) {
                System.out.println("Ten sinh vien khong duoc de trong");
            }
        } while (hoTen.isBlank());

        int tuoi = readIntInRange(sc, "Nhap tuoi (18-30): ", 18, 30);

        String gioiTinh;
        do {
            System.out.print("Nhap gioi tinh (Nam/Nu): ");
            gioiTinh = sc.nextLine();
            if (!gioiTinh.equalsIgnoreCase("Nam") && !gioiTinh.equalsIgnoreCase("Nu")) {
                System.out.println("Gioi tinh khong hop le");
                gioiTinh = "";
            }
        } while (gioiTinh.isBlank());

        double diemToan = readDoubleInRange(sc, "Nhap diem toan (0-10): ", 0, 10);
        double diemLy = readDoubleInRange(sc, "Nhap diem ly (0-10): ", 0, 10);
        double diemHoa = readDoubleInRange(sc, "Nhap diem hoa (0-10): ", 0, 10);

        manager.updateStudent(maSV, hoTen, tuoi, gioiTinh, diemToan, diemLy, diemHoa);
    }

    private static void sortUI(Scanner sc, StudentManager manager) {
        System.out.println("1. Sap xep theo DTB giam dan (bubble sort)");
        System.out.println("2. Sap xep theo ten A-Z (selection sort)");
        int c = readIntInRange(sc, "Chon (1-2): ", 1, 2);
        if (c == 1) {
            manager.sortByAvgBubble();
        } else {
            manager.sortByNameSelection();
        }
    }

    private static int readIntInRange(Scanner sc, String prompt, int min, int max) {
        while (true) {
                System.out.print(prompt);
                int val = Integer.parseInt(sc.nextLine());
                if (val < min || val > max) {
                    System.out.println("Gia tri khong hop le!");
                    continue;
                }
                return val;
        }
    }

    private static double readDoubleInRange(Scanner sc, String prompt, double min, double max) {
        while (true) {
                System.out.print(prompt);
                double val = Double.parseDouble(sc.nextLine());
                if (val < min || val > max) {
                    System.out.println("Gia tri khong hop le!");
                    continue;
                }
                return val;
        }
    }
}