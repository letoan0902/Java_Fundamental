import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập đánh giá:");
        String review = scanner.nextLine();

        String[] blacklist = {"xấu", "tệ", "dở"};
        for (String word : blacklist) {
            review = review.replaceAll("(?i)" + word, "*".repeat(word.length()));
        }

        if (review.length() > 200) {
            int lastSpace = review.lastIndexOf(" ", 200);
            review = review.substring(0, lastSpace) + "...";
        }

        System.out.println("Đánh giá sau xử lý: " + review);
    }
}
