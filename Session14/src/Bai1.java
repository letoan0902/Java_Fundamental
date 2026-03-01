import java.util.*;

public class Bai1 {
    public static void main(String[] args) {
        List<String> input = Arrays.asList(
                "Nguyễn Văn A – Yên Bái",
                "Trần Thị B – Thái Bình",
                "Nguyễn Văn A – Yên Bái",
                "Lê Văn C – Hưng Yên"
        );

        Set<String> uniqueInArrivalOrder = new LinkedHashSet<>(input);

        StringBuilder sb = new StringBuilder();
        for (String name : uniqueInArrivalOrder) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(name);
        }
        System.out.print("In ra danh sách gọi khám: " + sb);
    }
}
