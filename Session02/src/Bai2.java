import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma khu vuc (A, B, C, D): ");
        String input = sc.nextLine().trim();
        char code = input.isEmpty() ? '\0' : Character.toUpperCase(input.charAt(0));

        switch (code) {
            case 'A':
                System.out.println("Vi tri: Tang 1 - Sach Van hoc");
                break;
            case 'B':
                System.out.println("Vi tri: Tang 2 - Sach Khoa hoc");
                break;
            case 'C':
                System.out.println("Vi tri: Tang 3 - Sach Ngoai ngu");
                break;
            case 'D':
                System.out.println("Vi tri: Tang 4 - Sach Tin hoc");
                break;
            default:
                System.out.println("Loi: Ma khu vuc khong hop le!");
                break;
        }

        sc.close();
    }
}
