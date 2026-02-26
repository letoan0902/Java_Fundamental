public class Coffee extends Drink {
    private boolean hasMilk;

    public Coffee(String id, String name, double price, boolean hasMilk) {
        super(id, name, price);
        this.hasMilk = hasMilk;
    }

    @Override
    public double calculatePrice() {
        return hasMilk ? price + 5000 : price;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Loại: " + (hasMilk ? "Có sữa" : "Đen đá"));
    }
}
