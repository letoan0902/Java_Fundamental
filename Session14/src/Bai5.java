import java.util.*;

public class Bai5 {
    static class Patient {
        private final String name;
        private final int severity;
        private final int arrivalTime;

        Patient(String name, int severity, int arrivalTime) {
            this.name = name;
            this.severity = severity;
            this.arrivalTime = arrivalTime;
        }

        String getName() {
            return name;
        }

        int getSeverity() {
            return severity;
        }

        int getArrivalTime() {
            return arrivalTime;
        }

        @Override
        public String toString() {
            return "Bệnh nhân " + name + " (Mức " + severity + " - " + severityLabel(severity) + ", đến lúc " + formatTime(arrivalTime) + ")";
        }
    }

    private static String severityLabel(int severity) {
        if (severity == 1) return "Nguy kịch";
        if (severity == 2) return "Nặng";
        return "Nhẹ";
    }

    private static String formatTime(int minutesSinceMidnight) {
        int h = minutesSinceMidnight / 60;
        int m = minutesSinceMidnight % 60;
        return h + ":" + (m < 10 ? "0" + m : String.valueOf(m));
    }

    public static void main(String[] args) {
        Comparator<Patient> cmp = (p1, p2) -> {
            int c = Integer.compare(p1.getSeverity(), p2.getSeverity());
            if (c != 0) return c;
            c = Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
            if (c != 0) return c;
            return p1.getName().compareTo(p2.getName());
        };

        Set<Patient> queue = new TreeSet<>(cmp);

        queue.add(new Patient("A", 3, 8 * 60));
        queue.add(new Patient("B", 1, 8 * 60 + 15));
        queue.add(new Patient("C", 1, 8 * 60 + 5));
        queue.add(new Patient("D", 2, 8 * 60 + 2));

        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}
