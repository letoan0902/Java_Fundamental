import java.util.*;

public class Bai2 {
    public static void main(String[] args) {
        Map<String, String> catalog = new HashMap<>();
        catalog.put("T01", "Paracetamol");
        catalog.put("T02", "Ibuprofen");
        catalog.put("T03", "Amoxicillin");
        catalog.put("T04", "Vitamin C");
        catalog.put("T05", "Loratadine");

        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine().trim();

        String name = catalog.get(code);
        if (name != null) {
            System.out.print("Tên thuốc: " + name);
        } else {
            System.out.print("Thuốc không tồn tại");
        }
    }
}
