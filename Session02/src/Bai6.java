import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] days = {"Thu 2", "Thu 3", "Thu 4", "Thu 5", "Thu 6", "Thu 7", "Chu Nhat"};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        long sum = 0;
        int countOpenDays = 0;

        for (int i = 0; i < 7; i++) {
            System.out.print("Nhap luot muon ngay " + days[i] + ": ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Vui long nhap so nguyen!");
                System.out.print("Nhap luot muon ngay " + days[i] + ": ");
            }

            int lượt = sc.nextInt();
            if (lượt == 0) {
                continue; // ngay dong cua
            }

            if (lượt > max) max = lượt;
            if (lượt < min) min = lượt;

            sum += lượt;
            countOpenDays++;
        }

        System.out.println();
        System.out.println("--- KET QUA THONG KE ---");
        if (countOpenDays == 0) {
            System.out.println("Khong co ngay nao mo cua de thong ke.");
        } else {
            double avg = (double) sum / countOpenDays;
            System.out.println("Luot muon cao nhat: " + max);
            System.out.println("Luot muon thap nhat: " + min);
            System.out.println("Trung binh luot muon/ngay: " + String.format("%.1f", avg));
        }

        sc.close();
    }
}
