public class FruitJuice extends Drink implements IMixable {
    private int discountPercent;

    public FruitJuice(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePrice() {
        return price - (price * discountPercent / 100.0);
    }

    @Override
    public void mix() {
        System.out.println("Đang ép trái cây tươi...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giảm giá: " + discountPercent + "%");
    }
}
