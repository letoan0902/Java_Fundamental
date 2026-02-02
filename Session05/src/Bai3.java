public class Bai3 {
    static class Product {
        private String maSp;
        private String tenSp;
        private double giaBan;

        Product(String maSp, String tenSp, double giaBan) {
            this.maSp = maSp;
            this.tenSp = tenSp;
            setGiaBan(giaBan);
        }

        public String getMaSp() {
            return maSp;
        }

        public void setMaSp(String maSp) {
            this.maSp = maSp;
        }

        public String getTenSp() {
            return tenSp;
        }

        public void setTenSp(String tenSp) {
            this.tenSp = tenSp;
        }

        public double getGiaBan() {
            return giaBan;
        }

        public void setGiaBan(double giaBan) {
            if (giaBan <= 0) {
                System.out.println("Gia ban khong hop le: " + giaBan);
                return;
            }
            this.giaBan = giaBan;
        }

        void hienThiThongTin() {
            System.out.println("Ma SP: " + maSp);
            System.out.println("Ten SP: " + tenSp);
            System.out.println("Gia ban: " + giaBan);
        }
    }

    public static void main(String[] args) {
        Product p = new Product("P01", "Ban phim", 250000);
        p.hienThiThongTin();
        System.out.println();

        p.setGiaBan(-100);
        System.out.println("Gia ban sau khi set sai: " + p.getGiaBan());
        System.out.println();

        p.setGiaBan(300000);
        System.out.println("Gia ban sau khi set dung: " + p.getGiaBan());
    }
}
