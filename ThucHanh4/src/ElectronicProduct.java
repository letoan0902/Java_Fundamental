public class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = Math.max(0, warrantyMonths);
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = Math.max(0, warrantyMonths);
    }

    @Override
    public double calculateFinalPrice() {
        if (warrantyMonths > 12) {
            return getPrice() + 1_000_000;
        }
        return getPrice();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Số tháng bảo hành: " + warrantyMonths);
    }
}
