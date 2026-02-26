import java.util.Scanner;

public class Cau1Phan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String result = "";
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                result += ' ';
                i++;
            } else {
                String word = "";
                while (i < s.length() && s.charAt(i) != ' ') {
                    word += s.charAt(i);
                    i++;
                }
                String reverseWord = "";
                for (int j = word.length() - 1; j >= 0; j--) {
                    reverseWord += word.charAt(j);
                }
                result += reverseWord;
            }
        }
        System.out.println(result);
    }
}
