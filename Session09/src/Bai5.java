public class Bai5 {
    abstract static class Employee {
        abstract double calculateSalary();
    }

    static class OfficeEmployee extends Employee {
        private double luongCoBan;
        private double phuCap;

        OfficeEmployee(double luongCoBan, double phuCap) {
            this.luongCoBan = luongCoBan;
            this.phuCap = phuCap;
        }

        @Override
        double calculateSalary() {
            return luongCoBan + phuCap;
        }
    }

    static class ProductionEmployee extends Employee {
        private int soSanPham;
        private double donGia;

        ProductionEmployee(int soSanPham, double donGia) {
            this.soSanPham = soSanPham;
            this.donGia = donGia;
        }

        @Override
        double calculateSalary() {
            return soSanPham * donGia;
        }
    }

    public static void main(String[] args) {
        Employee[] ds = {
            new OfficeEmployee(8000000, 2000000),
            new ProductionEmployee(120, 50000)
        };

        double tong = 0;
        for (Employee e : ds) {
            tong += e.calculateSalary();
        }

        System.out.println("Tong luong: " + tong);
    }
}
