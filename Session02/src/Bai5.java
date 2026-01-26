import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score = 100;

        System.out.println("--- HE THONG DANH GIA DOC GIA ---");
        System.out.println("(Nhap so ngay tre. Nhap 999 de ket thuc)");

        while (true) {
            System.out.print("So ngay tre cua lan nay: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Vui long nhap so nguyen!");
                System.out.print("So ngay tre cua lan nay: ");
            }

            int days = sc.nextInt();
            if (days == 999) {
                break;
            }

            if (days <= 0) {
                score += 5;
                System.out.println("-> Tra dung han: +5 diem.");
            } else {
                int minus = days * 2;
                score -= minus;
                System.out.println("-> Tra tre " + days + " ngay: -" + minus + " diem.");
            }

            System.out.println();
        }

        System.out.println("Tong diem uy tin: " + score);
        if (score > 120) {
            System.out.println("Xep loai: DOC GIA THAN THIET");
        } else if (score >= 80) {
            System.out.println("Xep loai: DOC GIA TIEU CHUAN");
        } else {
            System.out.println("Xep loai: DOC GIA CAN LUU Y");
        }

        sc.close();
    }
}
