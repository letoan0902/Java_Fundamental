public class Bai3 {
    static class Employee {
        protected String ten;
        protected double luongCoBan;

        Employee(String ten, double luongCoBan) {
            this.ten = ten;
            this.luongCoBan = luongCoBan;
        }
    }

    static class Manager extends Employee {
        private String phongBan;

        Manager(String ten, double luongCoBan, String phongBan) {
            super(ten, luongCoBan);
            this.phongBan = phongBan;
        }

        void hienThiThongTin() {
            System.out.println("Ten: " + ten);
            System.out.println("Luong co ban: " + luongCoBan);
            System.out.println("Phong ban: " + phongBan);
        }
    }

    public static void main(String[] args) {
        Manager m = new Manager("Tran Thi B", 15000000, "Ky thuat");
        m.hienThiThongTin();
    }
}
