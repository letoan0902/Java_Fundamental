import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    // Giới hạn tối đa
    private static final int MAX_SIZE = 100;

    // MSSV phải bắt đầu bằng 'B' theo sau đúng 7 chữ số
    private static final Pattern MSSV_PATTERN = Pattern.compile("^B\\d{7}$");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] mssvList = new String[MAX_SIZE];
        int size = 0;

        int choice;
        do {
            printMenu();
            choice = readInt(scanner, "Chọn chức năng (0-5): ");

            switch (choice) {
                case 1:
                    displayList(mssvList, size);
                    break;
                case 2:
                    size = addNew(scanner, mssvList, size);
                    break;
                case 3:
                    updateAtIndex(scanner, mssvList, size);
                    break;
                case 4:
                    size = deleteByMssv(scanner, mssvList, size);
                    break;
                case 5:
                    searchContainsIgnoreCase(scanner, mssvList, size);
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println("================= QUẢN LÝ MSSV =================");
        System.out.println("1. Hiển thị danh sách MSSV");
        System.out.println("2. Thêm mới MSSV");
        System.out.println("3. Cập nhật MSSV theo vị trí (index)");
        System.out.println("4. Xóa MSSV");
        System.out.println("5. Tìm kiếm MSSV");
        System.out.println("0. Thoát");
        System.out.println("================================================");
    }

    private static void displayList(String[] mssvList, int size) {
        if (size == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }

        System.out.printf("%-5s %-10s %-12s%n", "STT", "INDEX", "MSSV");
        for (int i = 0; i < size; i++) {
            System.out.printf("%-5d %-10d %-12s%n", i + 1, i, mssvList[i]);
        }
    }

    private static int addNew(Scanner scanner, String[] mssvList, int size) {
        if (size >= MAX_SIZE) {
            System.out.println("Mảng đã đầy (100 phần tử). Không thể thêm mới.");
            return size;
        }

        String newMssv = readValidMssv(scanner, "Nhập MSSV mới (vd B2101234): ");
        mssvList[size] = newMssv;
        System.out.println("Thêm mới thành công tại index " + size + ".");
        return size + 1;
    }

    private static void updateAtIndex(Scanner scanner, String[] mssvList, int size) {
        if (size == 0) {
            System.out.println("Danh sách rỗng. Không có gì để cập nhật.");
            return;
        }

        int index = readInt(scanner, "Nhập index cần sửa (0 - " + (size - 1) + "): ");
        while (index < 0 || index >= size) {
            System.out.println("Index không hợp lệ. Vui lòng nhập lại.");
            index = readInt(scanner, "Nhập index cần sửa (0 - " + (size - 1) + "): ");
        }

        System.out.println("MSSV hiện tại tại index " + index + " là: " + mssvList[index]);
        String newMssv = readValidMssv(scanner, "Nhập MSSV mới: ");
        mssvList[index] = newMssv;
        System.out.println("Cập nhật thành công.");
    }

    private static int deleteByMssv(Scanner scanner, String[] mssvList, int size) {
        if (size == 0) {
            System.out.println("Danh sách rỗng. Không có gì để xóa.");
            return size;
        }

        System.out.print("Nhập MSSV cần xóa: ");
        String target = scanner.nextLine().trim();

        int index = indexOfExact(mssvList, size, target);
        if (index == -1) {
            System.out.println("Không tìm thấy MSSV: " + target);
            return size;
        }

        // dịch trái từ vị trí index
        for (int i = index; i < size - 1; i++) {
            mssvList[i] = mssvList[i + 1];
        }
        mssvList[size - 1] = null;

        System.out.println("Đã xóa MSSV tại index " + index + ".");
        return size - 1;
    }

    private static void searchContainsIgnoreCase(Scanner scanner, String[] mssvList, int size) {
        if (size == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }

        System.out.print("Nhập chuỗi cần tìm: ");
        String keyword = scanner.nextLine().trim();
        if (keyword.isEmpty()) {
            System.out.println("Chuỗi tìm kiếm rỗng. Vui lòng nhập lại.");
            return;
        }

        String keywordLower = keyword.toLowerCase();
        boolean found = false;

        System.out.printf("%-5s %-10s %-12s%n", "STT", "INDEX", "MSSV");
        int stt = 1;
        for (int i = 0; i < size; i++) {
            if (mssvList[i] != null && mssvList[i].toLowerCase().contains(keywordLower)) {
                System.out.printf("%-5d %-10d %-12s%n", stt, i, mssvList[i]);
                stt++;
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có MSSV nào chứa: " + keyword);
        }
    }

    private static String readValidMssv(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (MSSV_PATTERN.matcher(input).matches()) {
                return input;
            }

            System.out.println("MSSV không đúng định dạng. MSSV phải bắt đầu bằng 'B' theo sau đúng 7 chữ số (vd: B2101234). Vui lòng nhập lại.");
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                return Integer.parseInt(raw);
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }
    }

    private static int indexOfExact(String[] mssvList, int size, String target) {
        for (int i = 0; i < size; i++) {
            if (mssvList[i] != null && mssvList[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}