import java.util.Locale;

class ScoreUtils {
    public static boolean checkPass(double score) {
        return score >= 5.0;
    }

    public static double calculateAverage(double[] scores) {
        if (scores == null || scores.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }
}

public class Bai3 {
    public static void main(String[] args) {
        double[] scores = {6.5, 8.0, 4.5};

        System.out.print("Danh sach diem: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
            if (i < scores.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        double avg = ScoreUtils.calculateAverage(scores);
        System.out.println(">> Ket qua xu ly:");
        System.out.println("- Diem trung binh ca lop: " + String.format(Locale.US, "%.2f", avg));

        for (double score : scores) {
            System.out.println("- Diem " + score + ": " + (ScoreUtils.checkPass(score) ? "Dat" : "Truot"));
        }
    }
}
