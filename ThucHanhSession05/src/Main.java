import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // ---------- Helpers: input ----------
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le. Vui long nhap so nguyen!");
            }
        }
    }

    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            int val = readInt(sc, prompt);
            if (val > 0) {
                return val;
            }
            System.out.println("Vui long nhap so nguyen duong (> 0)!");
        }
    }

    private static int[] readIntArray(Scanner sc, int n, String promptEachPrefix) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt(sc, promptEachPrefix + "[" + i + "] = ");
        }
        return arr;
    }

    // ---------- FR1: Two Sum (in ra cap chi so) ----------
    private static void fr1TwoSum(Scanner sc) {
        System.out.println("\n[FR1] Two Sum - Tim cap chi so i, j sao cho arr[i] + arr[j] = target");

        int n = readInt(sc, "Nhap so phan tu (n): ");
        if (n <= 0) {
            System.out.println("Mang rong. Khong the thuc hien.");
            return;
        }

        int[] arr = readIntArray(sc, n, "Nhap arr");
        int target = readInt(sc, "Nhap target: ");

        boolean found = false;
        // Cach don gian theo dung bai ban dau: O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Tim thay: i=" + i + ", j=" + j + " (" + arr[i] + " + " + arr[j] + " = " + target + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Khong tim thay cap chi so nao thoa man.");
        }
    }

    // ---------- FR2: Move Zeroes (khong dung mang phu) ----------
    private static void fr2MoveZeroes(Scanner sc) {
        System.out.println("\n[FR2] Move Zeroes - Don so 0 ve cuoi, giu thu tu tuong doi");

        int n = readInt(sc, "Nhap so phan tu (n): ");
        if (n <= 0) {
            System.out.println("Mang rong. Ket qua: []");
            return;
        }

        int[] arr = readIntArray(sc, n, "Nhap arr");

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        while (index < n) {
            arr[index++] = 0;
        }

        System.out.println("Mang sau bien doi: " + Arrays.toString(arr));
    }

    // ---------- FR3: Valid Palindrome (String & Regex) ----------
    private static void fr3ValidPalindrome(Scanner sc) {
        System.out.println("\n[FR3] Valid Palindrome - Kiem tra chuoi doi xung (chi tinh chu cai)");
        System.out.print("Nhap chuoi can kiem tra: ");
        String str = sc.nextLine();

        // Lam sach: lower-case + bo tat ca ky tu khong phai chu cai
        String cleaned = (str == null ? "" : str).toLowerCase().replaceAll("[^a-z]", "");

        // Chuoi rong sau khi lam sach -> coi la palindrome
        int left = 0;
        int right = cleaned.length() - 1;
        boolean isPalindrome = true;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Chuoi sau khi lam sach: \"" + cleaned + "\"");
        System.out.println("Ket qua: " + isPalindrome);
    }

    // ---------- FR4: Reverse Words (Regex + 2 pointers) ----------
    private static void fr4ReverseWords(Scanner sc) {
        System.out.println("\n[FR4] Reverse Words - Dao nguoc thu tu cac tu, gom khoang trang con 1" );
        System.out.print("Nhap chuoi: ");
        String str = sc.nextLine();

        if (str == null) {
            System.out.println("Ket qua: \"\"");
            return;
        }

        String trimmed = str.trim().replaceAll("\\s+", " ");
        if (trimmed.isEmpty()) {
            System.out.println("Chuoi chi co khoang trang. Ket qua: \"\"");
            return;
        }

        String[] words = trimmed.split(" ");

        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        System.out.println("Ket qua: " + String.join(" ", words));
    }

    // ---------- FR5: Happy Number (phat hien chu trinh) ----------
    private static int sumSquareDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    private static boolean isHappy(int n) {
        // Dung HashSet de phat hien chu trinh (chac chan dung, khong phu thuoc so lan lap)
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumSquareDigits(n);
        }
        return n == 1;
    }

    private static void fr5HappyNumber(Scanner sc) {
        System.out.println("\n[FR5] Happy Number - Kiem tra so hanh phuc" );
        int n = readPositiveInt(sc, "Nhap n (so nguyen duong): ");
        System.out.println("Ket qua: " + isHappy(n));
    }

    // -------------------- Main Menu --------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========= MINI PROJECT (SRS) =========");
            System.out.println("1. [FR1] Two Sum (Tim cap so co tong = K)");
            System.out.println("2. [FR2] Move Zeroes (Don so 0 ve cuoi)");
            System.out.println("3. [FR3] Valid Palindrome (Chuoi doi xung)");
            System.out.println("4. [FR4] Reverse Words (Dao nguoc tu)");
            System.out.println("5. [FR5] Happy Number (So hanh phuc)");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            String line = sc.nextLine().trim();
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Lua chon khong hop le! Vui long nhap so tu 0..5.");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    fr1TwoSum(sc);
                    break;
                case 2:
                    fr2MoveZeroes(sc);
                    break;
                case 3:
                    fr3ValidPalindrome(sc);
                    break;
                case 4:
                    fr4ReverseWords(sc);
                    break;
                case 5:
                    fr5HappyNumber(sc);
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long nhap so tu 0..5.");
            }

        } while (choice != 0);

        sc.close();
    }
}