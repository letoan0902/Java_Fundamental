public class Bai3 {
    public static void maxQuantityOfBooks(String[] names, int[] quantities) {
        if (names == null || quantities == null || names.length == 0 || names.length != quantities.length) {
            System.out.println("Dữ liệu không hợp lệ.");
            return;
        }

        int max = quantities[0];
        for (int i = 1; i < quantities.length; i++) {
            if (quantities[i] > max) {
                max = quantities[i];
            }
        }

        System.out.println("Sách có số lượng nhiều nhất (" + max + "):");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == max) {
                System.out.println("- " + names[i]);
            }
        }
    }

    public static void minQuantityOfBooks(String[] names, int[] quantities) {
        if (names == null || quantities == null || names.length == 0 || names.length != quantities.length) {
            System.out.println("Dữ liệu không hợp lệ.");
            return;
        }

        int min = quantities[0];
        for (int i = 1; i < quantities.length; i++) {
            if (quantities[i] < min) {
                min = quantities[i];
            }
        }

        System.out.println("----------------");
        System.out.println("Sách có số lượng ít nhất (" + min + "):");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == min) {
                System.out.println("- " + names[i]);
            }
        }
    }

    public static void main(String[] args) {
        String[] names = {"Python Pro", "Web Design", "Data Structure", "Clean Code", "Java Core"};
        int[] quantities = {50, 50, 5, 12, 12};

        maxQuantityOfBooks(names, quantities);
        minQuantityOfBooks(names, quantities);
    }
}
