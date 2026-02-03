import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        int choice;
        do {
            printMenu();
            choice = readInt(sc, "Chon chuc nang: ");
            switch (choice) {
                case 1:
                    count = inputStudents(sc, students, count);
                    break;
                case 2:
                    displayStudents(students, count);
                    break;
                case 3:
                    searchByRank(sc, students, count);
                    break;
                case 4:
                    sortByRankDesc(students, count);
                    System.out.println("Da sap xep theo hoc luc giam dan.");
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }
        } while (choice != 5);
    }

    private static void printMenu() {
        System.out.println("===== QUAN LY DIEM SINH VIEN =====");
        System.out.println("1. Nhap danh sach sinh vien");
        System.out.println("2. Hien thi danh sach sinh vien");
        System.out.println("3. Tim kiem sinh vien theo hoc luc");
        System.out.println("4. Sap xep theo hoc luc giam dan");
        System.out.println("5. Thoat");
        System.out.println("==================================");
    }

    private static int inputStudents(Scanner sc, Student[] students, int count) {
        int n = readInt(sc, "Nhap so luong sinh vien: ");
        for (int i = 0; i < n; i++) {
            if (count >= students.length) {
                System.out.println("Danh sach da day (toi da 100 sinh vien).");
                break;
            }
            System.out.println("Sinh vien thu " + (i + 1) + ":");
            String id = readValidId(sc);
            String name = readNonEmpty(sc, "Nhap ho ten: ");
            double score = readDouble(sc, "Nhap diem trung binh: ");
            students[count] = new Student(id, name, score);
            count++;
        }
        return count;
    }

    private static void displayStudents(Student[] students, int count) {
        if (count == 0) {
            System.out.println("Danh sach rong.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }

    private static void searchByRank(Scanner sc, Student[] students, int count) {
        if (count == 0) {
            System.out.println("Danh sach rong.");
            return;
        }
        String keyword = readNonEmpty(sc, "Nhap hoc luc can tim (Gioi/Kha/Trung Binh/Yeu): ");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getRank().equalsIgnoreCase(keyword)) {
                System.out.println(students[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien phu hop.");
        }
    }

    private static void sortByRankDesc(Student[] students, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                Student a = students[i];
                Student b = students[j];
                int rankCompare = Integer.compare(rankWeight(b), rankWeight(a));
                if (rankCompare > 0 || (rankCompare == 0 && b.getScore() > a.getScore())) {
                    students[i] = b;
                    students[j] = a;
                }
            }
        }
    }

    private static int rankWeight(Student s) {
        String rank = s.getRank();
        if ("Gioi".equalsIgnoreCase(rank)) {
            return 3;
        }
        if ("Kha".equalsIgnoreCase(rank)) {
            return 2;
        }
        if ("Trung Binh".equalsIgnoreCase(rank)) {
            return 1;
        }
        return 0;
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen.");
            }
        }
    }

    private static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so.");
            }
        }
    }

    private static String readNonEmpty(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Khong duoc de trong.");
        }
    }

    private static String readValidId(Scanner sc) {
        while (true) {
            String id = readNonEmpty(sc, "Nhap ma SV (VD: SV001): ");
            if (isValidId(id)) {
                return id;
            }
            System.out.println("Ma SV khong hop le. Yeu cau: SV + 3 chu so.");
        }
    }

    private static boolean isValidId(String id) {
        if (!id.startsWith("SV") || id.length() != 5) {
            return false;
        }
        for (int i = 2; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

