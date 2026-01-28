import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập mã thẻ:");
        String cardCode = scanner.nextLine();

        if (!cardCode.matches("^[A-Z]{2}\\d{4}\\d{5}$")) {
            if (!cardCode.startsWith("TV")) {
                System.out.println("Thiếu tiền tố TV");
            } else if (!cardCode.substring(2, 6).matches("\\d{4}")) {
                System.out.println("Năm không hợp lệ");
            } else {
                System.out.println("Mã thẻ không hợp lệ");
            }
        } else {
            System.out.println("Mã thẻ hợp lệ");
        }
    }
}
