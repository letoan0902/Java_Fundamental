import java.util.Random;

public class Bai4 {
    public static void sortBooks(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void displayBooks(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 5;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 100 + random.nextInt(20);
        }

        System.out.print("Trước khi sắp xếp: ");
        displayBooks(arr);

        sortBooks(arr);

        System.out.print("Sau khi sắp xếp:   ");
        displayBooks(arr);
    }
}
