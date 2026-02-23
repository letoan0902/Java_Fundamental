import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bai6 {
    static class Product {
        private final String name;
        private final double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " - " + price;
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple", 20));
        products.add(new Product("Banana", 10));
        products.add(new Product("Orange", 15));

        List<Product> byPrice = new ArrayList<>(products);
        byPrice.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        List<Product> byName = new ArrayList<>(products);
        byName.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));

        // Bắt buộc dùng Anonymous Class khi cần thêm trạng thái/thuộc tính nội bộ (fields) hoặc nhiều method phức tạp,
        // vì lambda không tạo được class có field riêng.

        System.out.println("Sắp xếp theo giá (tăng dần):");
        for (Product p : byPrice) {
            System.out.println(p);
        }

        System.out.println("Sắp xếp theo tên (A-Z):");
        for (Product p : byName) {
            System.out.println(p);
        }
    }
}
