import java.util.Scanner;

public class Cau2Phan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Nhap mang: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                if (i != index) {
                    int temp = arr[i];
                    for (int j = i; j > index; j--) {
                        arr[j] = arr[j - 1];
                    }
                    arr[index] = temp;
                }
                index++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
