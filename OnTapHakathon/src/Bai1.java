import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String nguyenam ="";
        String phuam="";
        for (int i =0; i<a.length();i++){
            char c = a.charAt(i);
            if(Character.isLetter(c)){
                c=Character.toLowerCase(c);
                if(c=='u'||c=='e'||c=='o'||c=='a'||c=='i'){
                    nguyenam+=c;
                } else{
                    phuam+=c;
                }
            }
        }
        System.out.println("Nguyen am: "+nguyenam);
        System.out.println("Phu am: "+phuam);
    }
}
