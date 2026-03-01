import java.util.*;

public class Bai3 {
    public static void main(String[] args) {
        Set<String> drug = new LinkedHashSet<>(Arrays.asList("Aspirin", "Caffeine", "Paracetamol"));
        Set<String> allergy = new LinkedHashSet<>(Arrays.asList("Penicillin", "Aspirin"));

        Set<String> warning = new LinkedHashSet<>(drug);
        warning.retainAll(allergy);

        Set<String> safe = new LinkedHashSet<>(drug);
        safe.removeAll(allergy);

        System.out.println("Cảnh báo dị ứng: " + warning);
        System.out.print("Thành phần an toàn: " + safe);
    }
}
