import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap tuoi cua ban: ");
        int age = sc.nextInt();

        System.out.print("Nhap so sach dang muon: ");
        int currentBorrowed = sc.nextInt();

        boolean đủTuoi = age >= 18;
        boolean duSoLuong = currentBorrowed < 3;

        if (đủTuoi && duSoLuong) {
            System.out.println("Ket qua: Ban DU DIEU KIEN muon sach quy hiem.");
        } else {
            System.out.println("Ket qua: Khong du dieu kien.");
            if (!đủTuoi) {
                System.out.println("- Ly do: Ban phai tu 18 tuoi tro len.");
            }
            if (!duSoLuong) {
                System.out.println("- Ly do: Ban da muon toi da 3 cuon.");
            }
        }

        sc.close();
    }
}
