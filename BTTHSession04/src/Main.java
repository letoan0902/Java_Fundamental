import java.util.Scanner;
import java.text.Normalizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao ho ten: ");
        String hoTen = sc.nextLine();
        hoTen = Normalizer.normalize(hoTen, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                .trim();
        String[] arr = hoTen.split("\\s+");
        String ten = arr[arr.length - 1].toLowerCase();
        StringBuilder chuCaiDau = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            if (!arr[i].isEmpty()) {
                chuCaiDau.append(arr[i].toLowerCase().charAt(0));
            }
        }
        String email = ten + "." + chuCaiDau + "@gmail.com";
        System.out.println("Email duoc tao: " + email);
    }
}