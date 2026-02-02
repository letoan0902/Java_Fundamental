public class Bai4 {
    static class Employee {
        String ma;
        String ten;
        double luong;

        Employee() {
            this.ma = "";
            this.ten = "";
            this.luong = 0;
        }

        Employee(String ma, String ten) {
            this.ma = ma;
            this.ten = ten;
            this.luong = 0;
        }

        Employee(String ma, String ten, double luong) {
            this.ma = ma;
            this.ten = ten;
            this.luong = luong;
        }

        void hienThiThongTin() {
            System.out.println("Ma: " + ma);
            System.out.println("Ten: " + ten);
            System.out.println("Luong: " + luong);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("E01", "Nguyen Van C");
        Employee e3 = new Employee("E02", "Tran Thi D", 15000000);

        System.out.println("Nhan vien 1");
        e1.hienThiThongTin();
        System.out.println();

        System.out.println("Nhan vien 2");
        e2.hienThiThongTin();
        System.out.println();

        System.out.println("Nhan vien 3");
        e3.hienThiThongTin();
    }
}
