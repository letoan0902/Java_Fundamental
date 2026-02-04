public class Bai1 {
    static class Person {
        protected String hoTen;
        protected int tuoi;

        Person(String hoTen, int tuoi) {
            this.hoTen = hoTen;
            this.tuoi = tuoi;
        }

        void hienThiThongTin() {
            System.out.println("Ho ten: " + hoTen);
            System.out.println("Tuoi: " + tuoi);
        }
    }

    static class Student extends Person {
        private String maSinhVien;
        private double diemTrungBinh;

        Student(String hoTen, int tuoi, String maSinhVien, double diemTrungBinh) {
            super(hoTen, tuoi);
            this.maSinhVien = maSinhVien;
            this.diemTrungBinh = diemTrungBinh;
        }

        @Override
        void hienThiThongTin() {
            super.hienThiThongTin();
            System.out.println("Ma sinh vien: " + maSinhVien);
            System.out.println("Diem trung binh: " + diemTrungBinh);
        }
    }

    public static void main(String[] args) {
        Student sv = new Student("Nguyen Van A", 20, "SV001", 8.5);
        sv.hienThiThongTin();
    }
}
