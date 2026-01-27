package demo_mang_1_chieu;

import java.util.Random;
import java.util.Scanner;

public class NhapMangTuDong {
    public static void main(String[] args) {
        int arr[];
        int n;

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Nhập số phần tử của mảng: ");
            n = sc.nextInt();
            if(n<1){
                System.out.println("Nhập lai số phần tử");
            }
        }while(n<1);

        arr = new int[n];

        //Sử dụng lớp Random để sinh số ngẫu nhiên trong java
        Random r = new Random();
        for(int i=0;i<n;i++){
            arr[i] = r.nextInt(100);  //Sinh các số ngẫu nhiên từ 0 đến 99

            //Muốn sinh các số ngẫu nhiên từ 30 - 50 thì làm thế nào?
            //int number = r.nextInt(21)+30;
            System.out.print(arr[i]+"\t");
            if((i+1)%22==0){
                System.out.println();
            }
        }
//        System.out.println("Mảng vừa tạo: ");
//        for(int i=0;i<n;i++){
//            System.out.print(arr[i]+"\t");
//            if((i+1)%22==0){
//                System.out.println();
//            }
//        }
    }
}
