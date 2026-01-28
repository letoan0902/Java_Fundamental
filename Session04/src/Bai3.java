import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bai3 {
    public static void main(String[] args) {
        List<String> transactions = new ArrayList<>();
        transactions.add("BK001, 2026-01-30");
        transactions.add("BK002, 2026-01-30");
        transactions.add("BK003, 2026-01-30");

        StringBuilder report = new StringBuilder();
        report.append("Báo cáo giao dịch ngày: ").append(LocalDateTime.now()).append("\n");
        for (String transaction : transactions) {
            report.append(transaction).append("\n");
        }

        System.out.println(report);

        // So sánh thời gian thực thi
        long startTime = System.nanoTime();
        String concatenated = "";
        for (String transaction : transactions) {
            concatenated += transaction + "\n";
        }
        long endTime = System.nanoTime();
        System.out.println("Thời gian thực thi với phép cộng chuỗi: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (String transaction : transactions) {
            sb.append(transaction).append("\n");
        }
        endTime = System.nanoTime();
        System.out.println("Thời gian thực thi với StringBuilder: " + (endTime - startTime) + " ns");
    }
}
