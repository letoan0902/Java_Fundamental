import java.util.ArrayList;
import java.util.Iterator;

public class Bai1 {
    public static void main(String[] args) {
        ArrayList<Double> temps = new ArrayList<>();
        temps.add(36.5);
        temps.add(40.2);
        temps.add(37.0);
        temps.add(12.5);
        temps.add(39.8);
        temps.add(99.9);
        temps.add(36.8);

        System.out.println("Danh sach ban dau: " + temps);

        Iterator<Double> it = temps.iterator();
        while (it.hasNext()) {
            double t = it.next();
            if (t < 34.0 || t > 42.0) {
                it.remove();
            }
        }

        System.out.println("Danh sach sau khi loc: " + temps);

        double sum = 0;
        for (double t : temps) {
            sum += t;
        }
        double avg = sum / temps.size();
        System.out.printf("Nhiet do trung binh: %.2f%n", avg);
    }
}
