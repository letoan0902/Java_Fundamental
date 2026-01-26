import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int id;
        do {
            System.out.print("Nhap ma ID sach moi (phai > 0): ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Loi: ID phai la so nguyen. Moi nhap lai!");
                System.out.println();
                System.out.print("Nhap ma ID sach moi (phai > 0): ");
            }
            id = sc.nextInt();

            if (id <= 0) {
                System.out.println("Loi: ID phai la so duong. Moi nhap lai!");
                System.out.println();
            }
        } while (id <= 0);

        System.out.println("Xac nhan: Ma sach " + id + " da duoc ghi nhan.");
        sc.close();
    }
}
