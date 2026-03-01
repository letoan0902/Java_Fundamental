import java.util.*;

public class Bai4 {
    public static void main(String[] args) {
        List<String> casesList = Arrays.asList(
                "Cúm A",
                "Sốt xuất huyết",
                "Cúm A",
                "Covid-19",
                "Cúm A",
                "Sốt xuất huyết"
        );

        Map<String, Integer> report = new TreeMap<>();
        for (String disease : casesList) {
            report.put(disease, report.getOrDefault(disease, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : report.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue() + " ca");
        }
    }
}
