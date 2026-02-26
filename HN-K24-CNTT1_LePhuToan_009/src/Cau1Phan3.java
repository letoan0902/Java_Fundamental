import java.util.Scanner;

public class Cau1Phan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.printf("Nhap arr 1: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.printf("Nhap m: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        System.out.printf("Nhap arr 2: ");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] arr3 = new int[n + m];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boolean exists = false;
            for (int j = 0; j < index; j++) {
                if (arr[i] == arr3[j]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                arr3[index] = arr[i];
                index++;
            }
        }

        for (int i = 0; i < m; i++) {
            boolean exists = false;
            for (int j = 0; j < index; j++) {
                if (arr2[i] == arr3[j]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                arr3[index] = arr2[i];
                index++;
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
