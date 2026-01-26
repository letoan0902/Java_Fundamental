import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong sach tra muon: ");
        int n = sc.nextInt();

        final int finePerDay = 5000;
        long total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Nhap so ngay tre cua cuon thu " + i + ": ");
            int lateDays = sc.nextInt();
            if (lateDays < 0) lateDays = 0; // phong truong hop nhap sai
            total += (long) lateDays * finePerDay;
        }

        System.out.println("===> Tong tien phat: " + total + " VND");

        sc.close();
    }
}
