import java.util.*;

public class Bai3 {
    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {
        List<T> result = new ArrayList<>();
        for (T item : listA) {
            if (listB.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> idA = Arrays.asList(101, 102, 105);
        List<Integer> idB = Arrays.asList(102, 105, 108);
        System.out.println("Test Case 1 Output: " + findCommonPatients(idA, idB));

        List<String> bhytA = Arrays.asList("DN01", "DN02", "DN03");
        List<String> bhytB = Arrays.asList("DN02", "DN04");
        System.out.println("Test Case 2 Output: " + findCommonPatients(bhytA, bhytB));
    }
}
