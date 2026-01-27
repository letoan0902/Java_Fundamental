import java.util.Scanner;

public class Bai5 {
    public static void displayBooks(int[] arr, int n) {
        System.out.print("Kho sách hiện tại (" + n + " cuốn): [ ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static int findIndex(int[] arr, int n, int bookId) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == bookId) return i;
        }
        return -1;
    }

    public static int deleteBook(int[] arr, int n, int bookId) {
        int idx = findIndex(arr, n, bookId);
        if (idx < 0) return n;

        for (int i = idx; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return n - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] books = {101, 102, 103, 104, 105};
        int n = books.length;

        while (n > 0) {
            displayBooks(books, n);

            System.out.print("Nhập mã sách cần xóa (0 để thoát): ");
            while (!sc.hasNextInt()) {
                System.out.print("Giá trị không hợp lệ. Vui lòng nhập số nguyên: ");
                sc.next();
            }

            int bookId = sc.nextInt();
            if (bookId == 0) break;

            int oldN = n;
            n = deleteBook(books, n, bookId);

            if (n == oldN) {
                System.out.println("Không tìm thấy sách mã " + bookId);
            } else {
                System.out.println("Đã xóa sách mã " + bookId);
            }
        }

        if (n == 0) {
            System.out.println("Kho sách đã rỗng.");
        }
    }
}
