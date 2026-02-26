import java.util.*;

public class Bai2 {
    public static List<String> getUniqueSorted(List<String> medicines) {
        Set<String> set = new LinkedHashSet<>(medicines);
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("Paracetamol", "Ibuprofen", "Panadol", "Paracetamol", "Aspirin",
                "Ibuprofen");
        System.out.println("Input: " + input);
        List<String> output = getUniqueSorted(input);
        System.out.println("Output: " + output);
    }
}
