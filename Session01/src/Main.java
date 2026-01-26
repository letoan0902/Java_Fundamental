import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final int CURRENT_YEAR = 2026;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== SESSION 01 - BAI TAP =====");
            System.out.println("1. Bai 1");
            System.out.println("2. Bai 2");
            System.out.println("3. Bai 3");
            System.out.println("4. Bai 4");
            System.out.println("5. Bai 5");
            System.out.println("6. Bai 6");
            System.out.println("0. Thoat");
            System.out.print("Chon bai: ");

            int choice = readInt(sc);
            switch (choice) {
                case 1 -> bai1(sc);
                case 2 -> bai2(sc);
                case 3 -> bai3();
                case 4 -> bai4(sc);
                case 5 -> bai5(sc);
                case 6 -> bai6(sc);
                case 0 -> {
                    System.out.println("Tam biet!");
                    return;
                }
                default -> System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }
    }

    private static int readInt(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Nhap so nguyen hop le: ");
            }
        }
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("Nhap so thuc hop le (vd 25.5): ");
            }
        }
    }

    private static float readFloat(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Float.parseFloat(line);
            } catch (NumberFormatException e) {
                System.out.print("Nhap so thuc hop le (vd 25450.0): ");
            }
        }
    }

    private static boolean readBoolean(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim().toLowerCase(Locale.ROOT);
            if (line.equals("true") || line.equals("t") || line.equals("yes") || line.equals("y")) return true;
            if (line.equals("false") || line.equals("f") || line.equals("no") || line.equals("n")) return false;
            System.out.print("Nhap true/false: ");
        }
    }

    // bai 1
    private static void bai1(Scanner sc) {
        System.out.println("\n--- BAI 1: NHAP THONG TIN SACH ---");

        System.out.print("Nhap ma sach: ");
        String bookID = sc.nextLine().trim();

        System.out.print("Nhap ten sach: ");
        String bookName = sc.nextLine().trim();

        System.out.print("Nhap nam xuat ban: ");
        int publishYear = readInt(sc);

        System.out.print("Nhap gia bia: ");
        double price = readDouble(sc);

        System.out.print("Sach con trong kho (true/false): ");
        boolean isAvailable = readBoolean(sc);

        int age = CURRENT_YEAR - publishYear;
        String uppercaseName = bookName.toUpperCase(Locale.ROOT);
        String status = isAvailable ? "Con sach" : "Da muon";

        System.out.println("\n--- PHIEU THONG TIN SACH ---");
        System.out.println("Ten sach: " + uppercaseName);
        System.out.println("Ma so: " + bookID + " | Tuoi tho: " + age + " nam");
        System.out.printf(Locale.ROOT, "Gia ban: %.2f VND%n", price);
        System.out.println("Tinh trang: " + status);
    }

    // bai 2

    private static void bai2(Scanner sc) {
        System.out.println("\n--- BAI 2: TINH TIEN PHAT TRE HAN ---");

        System.out.print("Nhap so ngay cham tre: ");
        int n = readInt(sc);

        System.out.print("Nhap so luong sach muon: ");
        int m = readInt(sc);

        double total = n * m * 5000.0;
        double original = total;

        if (n > 7 && m >= 3) {
            total *= 1.2;
        }

        boolean needLockCard = total > 50_000;

        System.out.printf(Locale.ROOT, "Tien phat goc: %.1f VND%n", original);
        System.out.printf(Locale.ROOT, "Tien phat sau dieu chinh: %.1f VND%n", total);
        System.out.println("Yeu cau khoa the: " + needLockCard);
    }

    // bai 3

    private static void bai3() {
        System.out.println("\n--- BAI 3: HOAN DOI TEN SACH (THAM CHIEU) ---");

        String book1 = "Java Basic";
        String book2 = "Python Intro";

        System.out.println("Truoc khi hoan doi: Book1 = " + book1 + ", Book2 = " + book2);

        String temp = book1;
        book1 = book2;
        book2 = temp;

        System.out.println("Sau khi hoan doi: Book1 = " + book1 + ", Book2 = " + book2);

        /*
         * Giai thich ngan gon ve Stack/Heap:
         * - String trong Java la object (bat bien), duoc luu o Heap (chuoi ky tu).
         * - Bien book1, book2, temp nam tren Stack va chi GIU THAM CHIEU (dia chi) tro toi object String tren Heap.
         * - Khi gan temp = book1: temp va book1 cung tro toi cung mot object "Java Basic" tren Heap.
         * - Khi book1 = book2: book1 doi tham chieu sang object "Python Intro".
         * - Khi book2 = temp: book2 doi tham chieu sang object "Java Basic".
         * => Khong co "dao" noi dung trong Heap; chi co viec doi tham chieu tren Stack.
         */
    }

    // bai 4

    private static void bai4(Scanner sc) {
        System.out.println("\n--- BAI 4: USD -> VND VA LAM TRON ---");

        System.out.print("Nhap gia sach (USD - kieu double): ");
        double usd = readDouble(sc);

        System.out.print("Nhap ty gia (kieu float): ");
        float rate = readFloat(sc);

        double vnd = usd * rate;
        long rounded = (long) vnd; // cat phan le de ra so chan

        // Hien thi thêm dinh dang co dau phan tach hang nghin
        NumberFormat vn = NumberFormat.getInstance(Locale.forLanguageTag("vi-VN"));
        vn.setMaximumFractionDigits(0);

        System.out.println("Gia chinh xac (so thuc): " + vnd);
        System.out.println("Gia lam tron de thanh toan (long): " + rounded);
        System.out.println("Dinh dang VND: " + vn.format(rounded) + " VND");
    }

    // bai 5

    private static void bai5(Scanner sc) {
        System.out.println("\n--- BAI 5: KIEM TRA MA SACH 4 CHU SO (CHECK-DIGIT) ---");

        System.out.print("Nhap ma sach (4 chu so): ");
        int code = readInt(sc);

        int thousands = code / 1000;
        int hundreds = (code / 100) % 10;
        int dozens = (code / 10) % 10;
        int units = code % 10;

        int sum = thousands + hundreds + dozens;
        int expectedCheckDigit = sum % 10;
        boolean valid = expectedCheckDigit == units;

        System.out.println("Chu so kiem tra ky vong: " + expectedCheckDigit);
        System.out.println("Ket qua kiem tra ma sach: " + (valid ? "HOP LE" : "SAI MA"));
        System.out.println("(boolean): " + valid);
    }

    // bai 6

    private static void bai6(Scanner sc) {
        System.out.println("\n--- BAI 6: DINH VI KHO SACH ---");

        System.out.print("Nhap so thu tu cua sach trong he thong: ");
        int stt = readInt(sc);

        if (stt <= 0) {
            System.out.println("So thu tu phai > 0.");
            return;
        }

        int shelf = (stt - 1) / 25 + 1;
        int position = (stt - 1) % 25 + 1;
        String zone = (shelf <= 10) ? "Khu Can" : "Khu Vien";

        System.out.println("\n--- THONG TIN DINH VI ---");
        System.out.println("Sach so: " + stt);
        System.out.println("Dia chi: Ke " + shelf + " - Vi tri " + position);
        System.out.println("Phan khu: " + zone + (zone.equals("Khu Can") ? " (Gan cua)" : " (Xa cua)"));
    }
}