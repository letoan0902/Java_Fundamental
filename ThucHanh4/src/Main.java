import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        repo.add(new ElectronicProduct("E01", "Tivi", 12000000, 18));
        repo.add(new ElectronicProduct("E02", "Laptop", 20000000, 12));
        repo.add(new FoodProduct("F01", "Sữa", 35000, 10));
        repo.add(new FoodProduct("F02", "Bánh", 15000, 0));

        System.out.println("===== DANH SÁCH SẢN PHẨM =====");
        printProducts(repo.findAll());

        System.out.println("\n===== TÌM THEO MÃ (E01) =====");
        Product found = repo.findById("E01");
        if (found != null) {
            found.displayInfo();
            System.out.println("Thành tiền: " + found.calculateFinalPrice());
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }

        System.out.println("\n===== SẮP XẾP THEO GIÁ TĂNG DẦN (THÀNH TIỀN) =====");
        List<Product> sorted = repo.findAll();
        Collections.sort(sorted, Comparator.comparingDouble(Product::calculateFinalPrice));
        printProducts(sorted);

        System.out.println("\n===== THỐNG KÊ SỐ LƯỢNG THEO LOẠI =====");
        Map<String, Integer> stats = countByType(repo.findAll());
        System.out.println(stats);
    }

    private static void printProducts(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("(Danh sách rỗng)");
            return;
        }
        for (Product p : products) {
            if (p == null) {
                continue;
            }
            p.displayInfo();
            System.out.println("Thành tiền: " + p.calculateFinalPrice());
            System.out.println("---------------------------");
        }
    }

    private static Map<String, Integer> countByType(List<Product> products) {
        Map<String, Integer> result = new HashMap<>();
        result.put("Electronic", 0);
        result.put("Food", 0);

        if (products == null) {
            return result;
        }

        for (Product p : products) {
            if (p instanceof ElectronicProduct) {
                result.put("Electronic", result.get("Electronic") + 1);
            } else if (p instanceof FoodProduct) {
                result.put("Food", result.get("Food") + 1);
            }
        }
        return result;
    }
}