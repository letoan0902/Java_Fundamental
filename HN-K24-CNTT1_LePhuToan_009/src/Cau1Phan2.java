import java.util.Scanner;

public class Cau1Phan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String lower = s.toLowerCase();
        int[] count = new int[26];
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (Character.isLetter(c)) {
                count[c - 'a']++;
            }
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        char result = ' ';
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (Character.isLetter(c) && count[c - 'a'] == max) {
                result = c;
                break;
            }
        }
        System.out.println(result + " : " + max);
    }
}
