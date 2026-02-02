public class Student {
    // Thong tin sinh vien
    private String maSV;
    private String hoTen;
    private int tuoi;
    private String gioiTinh;

    private double diemToan;
    private double diemLy;
    private double diemHoa;

    private double diemTB;
    private String xepLoai;

    public Student() {
    }

    public Student(String maSV, String hoTen, int tuoi, String gioiTinh,
                   double diemToan, double diemLy, double diemHoa) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
        tinhDiemVaXepLoai();
    }

    // ===== TINH DIEM TRUNG BINH & XEP LOAI (giu nguyen dieu kien) =====
    public void tinhDiemVaXepLoai() {
        this.diemTB = (diemToan + diemLy + diemHoa) / 3;

        if (diemTB >= 8.0 && diemToan >= 6.5 && diemLy >= 6.5 && diemHoa >= 6.5) {
            this.xepLoai = "Gioi";
        } else if (diemTB >= 6.5 && diemToan >= 5.0 && diemLy >= 5.0 && diemHoa >= 5.0) {
            this.xepLoai = "Kha";
        } else if (diemTB >= 5.0 && diemToan >= 3.5 && diemLy >= 3.5 && diemHoa >= 3.5) {
            this.xepLoai = "Trung binh";
        } else {
            this.xepLoai = "Yeu";
        }
    }

    // ===== hien thi 1 dong dang bang =====
    public void studentInfo() {
        System.out.printf("%-10s %-17s %-7s %-10s %-15.2f %-15s\n",
                maSV, hoTen, tuoi, gioiTinh, diemTB, xepLoai);
    }

    // ===== Getter/Setter =====
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
    }

    public double getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public String getXepLoai() {
        return xepLoai;
    }
}
