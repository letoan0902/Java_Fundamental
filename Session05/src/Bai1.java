public class Bai1 {
    static class Student {
        String maSinhVien;
        String hoTen;
        int namSinh;
        double diemTrungBinh;

        Student(String maSinhVien, String hoTen, int namSinh, double diemTrungBinh) {
            this.maSinhVien = maSinhVien;
            this.hoTen = hoTen;
            this.namSinh = namSinh;
            this.diemTrungBinh = diemTrungBinh;
        }

        void hienThiThongTin() {
            System.out.println("Ma SV: " + maSinhVien);
            System.out.println("Ho ten: " + hoTen);
            System.out.println("Nam sinh: " + namSinh);
            System.out.println("Diem TB: " + diemTrungBinh);
        }
    }

    public static void main(String[] args) {
        Student sv1 = new Student("SV001", "Nguyen Van A", 2004, 8.2);
        Student sv2 = new Student("SV002", "Tran Thi B", 2003, 7.6);

        System.out.println("Sinh vien 1");
        sv1.hienThiThongTin();
        System.out.println();

        System.out.println("Sinh vien 2");
        sv2.hienThiThongTin();
    }
}
