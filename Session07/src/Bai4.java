public class Bai4 {
    static class ClassRoom {
        static double classFund = 0.0;
        String studentName;

        ClassRoom(String studentName) {
            this.studentName = studentName;
        }

        void contribute(double amount) {
            classFund += amount;
            System.out.println(studentName + " dong: " + amount);
        }

        static void showFund() {
            System.out.println("Tong quy lop: " + classFund);
        }
    }

    public static void main(String[] args) {
        ClassRoom a = new ClassRoom("An");
        ClassRoom b = new ClassRoom("Binh");

        a.contribute(100_000);
        b.contribute(50_000);
        ClassRoom.showFund();
    }
}
