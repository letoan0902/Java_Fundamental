import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập đoạn mô tả cuốn sách:");
        String description = scanner.nextLine();

        if (description.contains("Kệ:")) {
            int startIndex = description.indexOf("Kệ:") + 3;
            int endIndex = description.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = description.length();
            }
            String position = description.substring(startIndex, endIndex).trim();
            description = description.replace("Kệ:", "Vị trí lưu trữ:");
            System.out.println("Mã vị trí: " + position);
        }

        System.out.println("Mô tả mới: " + description);
    }
}
