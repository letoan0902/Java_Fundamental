package demo_mang_1_chieu;

import java.util.Scanner;

public class NhapTuBanPhim {
    public static void main(String[] args) {
        int[] arr;
        int n;

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Nhập vào số phần tử của mảng: ");
            n = sc.nextInt();
            if(n<1){
                System.out.println("Nhập lại số phần tử của mảng");
            }
        }while(n<1);

        arr = new int[n];

        for(int i=0;i<n;i++){
            System.out.print("Nhập phần tử arr["+i+"]=");
            arr[i] = sc.nextInt();
        }

        System.out.println("\nMảng vừa nhập: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+"\t");
            if((i+1)%20==0){
                System.out.println();
            }
        }
    }
}
