public class FoodProduct extends Product {
    private int discountPercent;

    public FoodProduct(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        setDiscountPercent(discountPercent);
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        if (discountPercent < 0) {
            this.discountPercent = 0;
        } else if (discountPercent > 100) {
            this.discountPercent = 100;
        } else {
            this.discountPercent = discountPercent;
        }
    }

    @Override
    public double calculateFinalPrice() {
        return getPrice() - (getPrice() * discountPercent / 100.0);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giảm giá (%): " + discountPercent);
    }
}
