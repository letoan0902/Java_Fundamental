import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai5 {
    public static void main(String[] args) {
        String log = "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345";

        Pattern pattern = Pattern.compile("(?<date>\\d{4}-\\d{2}-\\d{2}) \\\| User: (?<user>\\w+) \\\| Action: (?<action>\\w+) \\\| BookID: (?<bookID>\\w+)");
        Matcher matcher = pattern.matcher(log);

        if (matcher.find()) {
            String date = matcher.group("date");
            String user = matcher.group("user");
            String action = matcher.group("action");
            String bookID = matcher.group("bookID");

            System.out.println("Ngày: " + date);
            System.out.println("Người dùng: " + user);
            System.out.println("Hành động: " + action);
            System.out.println("Mã sách: " + bookID);
        }

        // Thống kê hành động
        String[] logs = {
            "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345",
            "2024-05-21 | User: NguyenVanB | Action: RETURN | BookID: BK12346",
            "2024-05-22 | User: NguyenVanC | Action: BORROW | BookID: BK12347"
        };

        int borrowCount = 0;
        int returnCount = 0;

        for (String entry : logs) {
            if (entry.contains("BORROW")) {
                borrowCount++;
            } else if (entry.contains("RETURN")) {
                returnCount++;
            }
        }

        System.out.println("Số lần mượn: " + borrowCount);
        System.out.println("Số lần trả: " + returnCount);
    }
}
