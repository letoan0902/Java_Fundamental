import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập tên sách:");
        String bookName = scanner.nextLine().trim().replaceAll("\\s+", " ").toUpperCase();

        System.out.println("Nhập tên tác giả:");
        String authorName = scanner.nextLine().trim().replaceAll("\\s+", " ");
        authorName = capitalizeWords(authorName);

        System.out.println("Nhập thể loại:");
        String category = scanner.nextLine().trim().replaceAll("\\s+", " ");

        System.out.printf("[%s] - Tác giả: [%s]\n", bookName, authorName);
    }

    private static String capitalizeWords(String str) {
        String[] words = str.split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            capitalized.append(Character.toUpperCase(word.charAt(0)))
                       .append(word.substring(1).toLowerCase())
                       .append(" ");
        }
        return capitalized.toString().trim();
    }
}
