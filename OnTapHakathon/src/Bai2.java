import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int[] mangXuatHien=new int[26];
        for(int i=0; i<a.length();i++) {
            char c = a.charAt(i);
            if(Character.isLetter(c)){
                c = Character.toLowerCase(c);
                int index = c-'a';
                mangXuatHien[index]++;
            }
        }
        int max = 0;
        for (int j : mangXuatHien) {
            if (j > max) {
                max = j;
            }
        }
        char ketqua = ' ';
        for(int i=0;i<a.length();i++){
            char c = a.charAt(i);
            if(Character.isLetter(c)){
                c=Character.toLowerCase(c);
                int index = c-'a';
                if(mangXuatHien[index]==max){
                    ketqua=c;
                    break;
                }
            }
        }
        System.out.println(ketqua + " Xuat hien " + max + " lan");
    }
}
