import java.util.Scanner;

public class StudentManager {
    private final Student[] students;
    private int size;

    public StudentManager(int capacity) {
        this.students = new Student[capacity];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return size >= students.length;
    }

    public Student findByMaSV(String maSV) {
        for (int i = 0; i < size; i++) {
            if (students[i].getMaSV().equalsIgnoreCase(maSV)) {
                return students[i];
            }
        }
        return null;
    }

    public boolean addStudent(Student newStudent) {
        if (isFull()) {
            System.out.println("Mang da day, khong the them!");
            return false;
        }
        if (findByMaSV(newStudent.getMaSV()) != null) {
            System.out.println("Ma sinh vien da ton tai!");
            return false;
        }
        students[size] = newStudent;
        size++;
        System.out.println("Them moi sinh vien thanh cong!");
        return true;
    }

    // =====  HIEN THI DANH SACH =====
    public void displayStudentList() {
        if (size == 0) {
            System.out.println("Chua co sinh vien");
            return;
        }

        System.out.printf("%-10s %-17s %-7s %-10s %-15s %-15s\n",
                "Ma SV", "Ho ten", "Tuoi", "Gioi tinh", "DTB", "Xep loai");
        System.out.println("-----------------------------------------------------------------------");

        for (int i = 0; i < size; i++) {
            students[i].studentInfo();
        }
    }

    // ===== Tim kiem (ma chinh xac, ten mo) =====
    public void findByKeyword(String keyword) {
        if (size == 0) {
            System.out.println("Danh sach sinh vien rong!");
            return;
        }

        boolean found = false;
        String kw = keyword.toLowerCase();
        for (int i = 0; i < size; i++) {
            Student s = students[i];
            if (s.getMaSV().equalsIgnoreCase(keyword) || s.getHoTen().toLowerCase().contains(kw)) {
                if (!found) {
                    System.out.printf("%-10s %-17s %-7s %-10s %-15s %-15s\n",
                            "Ma SV", "Ho ten", "Tuoi", "Gioi tinh", "DTB", "Xep loai");
                    System.out.println("-----------------------------------------------------------------------");
                }
                s.studentInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien");
        }
    }

    // ===== Cap nhat thong tin (khong doi ma) =====
    public boolean updateStudent(String maSV, String hoTen, int tuoi, String gioiTinh,
                                 double diemToan, double diemLy, double diemHoa) {
        Student s = findByMaSV(maSV);
        if (s == null) {
            System.out.println("Khong tim thay sinh vien");
            return false;
        }

        s.setHoTen(hoTen);
        s.setTuoi(tuoi);
        s.setGioiTinh(gioiTinh);
        s.setDiemToan(diemToan);
        s.setDiemLy(diemLy);
        s.setDiemHoa(diemHoa);
        s.tinhDiemVaXepLoai();

        System.out.println("Cap nhat sinh vien thanh cong");
        return true;
    }

    // =====  XOA THEO MA + xac nhan + dich mang =====
    public boolean deleteStudentById(String maSV) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (students[i].getMaSV().equals(maSV)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Khong tim thay sinh vien co ma: " + maSV);
            return false;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print(" Ban co chac muon xoa sinh vien nay? (Y/N): ");
        String confirm = sc.nextLine();

        if (!confirm.equals("Y") && !confirm.equals("y")) {
            System.out.println("Huy thao tac xoa.");
            return false;
        }

        // Dich mang sang trai
        for (int i = index; i < size - 1; i++) {
            students[i] = students[i + 1];
        }

        students[size - 1] = null;
        size--;

        System.out.println("Xoa sinh vien thanh cong");
        return true;
    }

    // ===== FR6: in DTB + xep loai theo ma =====
    public void printAvgAndRank(String maSV) {
        Student s = findByMaSV(maSV);
        if (s == null) {
            System.out.println("Khong tim thay sinh vien");
            return;
        }
        System.out.printf("Ma SV: %s | Ho ten: %s | DTB: %.2f | Xep loai: %s\n",
                s.getMaSV(), s.getHoTen(), s.getDiemTB(), s.getXepLoai());
    }

    // =====  sort theo DTB giam dan (bubble sort) =====
    public void sortByAvgBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (students[j].getDiemTB() < students[j + 1].getDiemTB()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("sap xep theo diem TB giam dan thanh cong");
    }

    // =====  sort theo ten A-Z (selection sort) =====
    public void sortByNameSelection() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (students[j].getHoTen().compareToIgnoreCase(students[minIndex].getHoTen()) < 0) {
                    minIndex = j;
                }
            }

            Student temp = students[i];
            students[i] = students[minIndex];
            students[minIndex] = temp;
        }
        System.out.println("sap xep theo ten A-Z thanh cong");
    }

    // =====  THONG KE =====
    public void thongKe() {
        if (size == 0) {
            System.out.println("Danh sach sinh vien rong!");
            return;
        }

        int gioi = 0, kha = 0, trungBinh = 0, yeu = 0;
        double tongDTB = 0;

        Student max = students[0];
        Student min = students[0];

        for (int i = 0; i < size; i++) {
            Student s = students[i];
            tongDTB += s.getDiemTB();

            // Thong ke xep loai
            switch (s.getXepLoai()) {
                case "Gioi":
                    gioi++;
                    break;
                case "Kha":
                    kha++;
                    break;
                case "Trung binh":
                    trungBinh++;
                    break;
                default:
                    yeu++;
            }

            // Tim diem cao nhat
            if (s.getDiemTB() > max.getDiemTB()) {
                max = s;
            }

            // Tim diem thap nhat
            if (s.getDiemTB() < min.getDiemTB()) {
                min = s;
            }
        }

        // In bao cao thong ke
        System.out.println("===== BAO CAO THONG KE =====");
        System.out.println("So SV Gioi       : " + gioi);
        System.out.println("So SV Kha        : " + kha);
        System.out.println("So SV Trung binh : " + trungBinh);
        System.out.println("So SV Yeu        : " + yeu);
        System.out.printf("Diem TB chung    : %.2f\n", tongDTB / size);
        System.out.println("SV diem cao nhat : " + max.getHoTen());
        System.out.println("SV diem thap nhat: " + min.getHoTen());
    }
}
