public class Bai5 {
    static class Config {
        public static final double MAX_SCORE = 10.0;
        public static final double MIN_SCORE = 0.0;
    }

    public static void main(String[] args) {
        double score = 8.5;
        System.out.println("Max: " + Config.MAX_SCORE + ", Min: " + Config.MIN_SCORE);
        System.out.println("Diem hop le? " + (score >= Config.MIN_SCORE && score <= Config.MAX_SCORE));

        // Config.MAX_SCORE = 9.0; // thu thay doi se loi bien dich
    }
}
