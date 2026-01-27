import java.util.Scanner;

public class Bai1 {
    public static int[] addBookToLibraries(int n) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];

        System.out.println("Nhập mã số cho " + n + " cuốn sách:");
        for (int i = 0; i < n; i++) {
            System.out.print("Sách thứ " + (i + 1) + ": ");
            while (!sc.hasNextInt()) {
                System.out.print("Giá trị không hợp lệ. Vui lòng nhập số nguyên: ");
                sc.next();
            }
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void displayLibraries(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Danh sách mã sách: (rỗng)");
            return;
        }

        System.out.print("Danh sách mã sách: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng sách cần quản lý: ");
        int n;
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Giá trị không hợp lệ. Vui lòng nhập số nguyên >= 0: ");
                sc.next();
            }
            n = sc.nextInt();
            if (n >= 0) break;
            System.out.print("Vui lòng nhập số nguyên >= 0: ");
        }

        int[] books = addBookToLibraries(n);

        System.out.println("--- KẾT QUẢ ---");
        displayLibraries(books);
    }
}
