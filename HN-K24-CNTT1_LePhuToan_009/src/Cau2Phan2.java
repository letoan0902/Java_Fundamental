import java.util.Scanner;

public class Cau2Phan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Nhap mang: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Nhap x: ");
        int x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                for (int j = i; j < n - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                n--;
                i--;
            }
        }
        if (n == 0) {
            System.out.println("Mang rong");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
