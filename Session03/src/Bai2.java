import java.util.Scanner;

public class Bai2 {
    public static int searchBooks(String[] arr, String search) {
        if (arr == null || search == null) return -1;
        String key = search.trim();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].trim().equalsIgnoreCase(key)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] books = {
                "Doraemon",
                "No pain, No gain",
                "Python Pro",
                "Web Design",
                "Data Structure"
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên sách cần tìm: ");
        String search = sc.nextLine();

        int index = searchBooks(books, search);
        if (index >= 0) {
            System.out.println("Tìm thấy sách '" + books[index] + "' tại vị trí số: " + index);
        } else {
            System.out.println("Sách không tồn tại trong thư viện.");
        }
    }
}
