import java.util.*;

public class Bai6 {
    static List<Medicine> medicines = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== KE DON THUOC =====");
            System.out.println("1. Them thuoc vao don");
            System.out.println("2. Dieu chinh so luong");
            System.out.println("3. Xoa thuoc");
            System.out.println("4. In hoa don");
            System.out.println("5. Tim thuoc gia re (< 50.000 VND)");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    adjustQuantity();
                    break;
                case 3:
                    removeMedicine();
                    break;
                case 4:
                    printBill();
                    break;
                case 5:
                    findCheap();
                    break;
                case 6:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 6);
    }

    static Medicine findById(String id) {
        for (Medicine m : medicines) {
            if (m.drugId.equals(id))
                return m;
        }
        return null;
    }

    static void addMedicine() {
        System.out.print("Nhap ma thuoc: ");
        String id = sc.nextLine();
        Medicine existing = findById(id);
        if (existing != null) {
            System.out.print("Thuoc da ton tai. Nhap so luong them: ");
            int qty = Integer.parseInt(sc.nextLine());
            existing.quantity += qty;
            System.out.println("Da cong them so luong!");
            return;
        }
        System.out.print("Nhap ten thuoc: ");
        String name = sc.nextLine();
        System.out.print("Nhap don gia: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong: ");
        int qty = Integer.parseInt(sc.nextLine());
        medicines.add(new Medicine(id, name, price, qty));
        System.out.println("Them thuoc thanh cong!");
    }

    static void adjustQuantity() {
        System.out.print("Nhap ma thuoc: ");
        String id = sc.nextLine();
        Medicine m = findById(id);
        if (m == null) {
            System.out.println("Khong tim thay thuoc voi ma: " + id);
            return;
        }
        System.out.print("Nhap so luong moi: ");
        int qty = Integer.parseInt(sc.nextLine());
        if (qty == 0) {
            medicines.remove(m);
            System.out.println("So luong = 0, da xoa thuoc khoi don!");
        } else {
            m.quantity = qty;
            System.out.println("Cap nhat so luong thanh cong!");
        }
    }

    static void removeMedicine() {
        System.out.print("Nhap ma thuoc can xoa: ");
        String id = sc.nextLine();
        Medicine m = findById(id);
        if (m == null) {
            System.out.println("Khong tim thay thuoc voi ma: " + id);
            return;
        }
        medicines.remove(m);
        System.out.println("Da xoa thuoc: " + m.drugName);
    }

    static void printBill() {
        if (medicines.isEmpty()) {
            System.out.println("Don thuoc trong!");
            return;
        }
        System.out.println("\n=========== HOA DON THUOC ===========");
        System.out.printf("%-10s %-20s %-12s %-8s %-15s%n", "Ma", "Ten Thuoc", "Don Gia", "SL", "Thanh Tien");
        System.out.println("--------------------------------------------------------------");
        double total = 0;
        for (Medicine m : medicines) {
            double subtotal = m.unitPrice * m.quantity;
            total += subtotal;
            System.out.printf("%-10s %-20s %-12.0f %-8d %-15.0f%n", m.drugId, m.drugName, m.unitPrice, m.quantity,
                    subtotal);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.printf("TONG TIEN: %.0f VND%n", total);
        medicines.clear();
        System.out.println("Da xoa don thuoc sau khi in hoa don.");
    }

    static void findCheap() {
        System.out.println("Thuoc co don gia duoi 50.000 VND:");
        boolean found = false;
        for (Medicine m : medicines) {
            if (m.unitPrice < 50000) {
                System.out.printf("  %s - %s: %.0f VND%n", m.drugId, m.drugName, m.unitPrice);
                found = true;
            }
        }
        if (!found)
            System.out.println("  Khong co thuoc nao duoi 50.000 VND.");
    }
}

class Medicine {
    String drugId;
    String drugName;
    double unitPrice;
    int quantity;

    Medicine(String drugId, String drugName, double unitPrice, int quantity) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
}
