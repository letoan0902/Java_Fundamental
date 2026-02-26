//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Drink[] drinks = new Drink[3];

        drinks[0] = new Coffee("CF01", "Bạc sỉu", 30000, true);
        drinks[1] = new FruitJuice("FJ01", "Nước cam", 40000, 10);
        drinks[2] = null;

        System.out.println("===== HÓA ĐƠN ĐỒ UỐNG =====");
        for (int i = 0; i < drinks.length; i++) {
            Drink d = drinks[i];
            if (d == null) {
                continue;
            }

            System.out.println("--- Món #" + (i + 1) + " ---");
            d.displayInfo();
            System.out.println("Thành tiền: " + d.calculatePrice());

            if (d instanceof IMixable) {
                ((IMixable) d).mix();
            }
        }
    }
}