package demo_mang_1_chieu;

public class KhaiBaoVaCapPhat {
    public static void main(String[] args) {
        //Khai báo
        int[] arrInt;
        float[] arrFloat;
        String[] arrStr;
        boolean[] arrBool;

        //cấp phát
        arrInt = new int[10];
        arrFloat = new float[20];
        arrStr = new String[50];
        arrBool = new boolean[15];

        arrInt[0] = 10;
        arrFloat[0] = 0.5f;
        arrStr[0] = "Phần tử đầu tiên";
        arrBool[0] = true;

        System.out.println("Phần tử đầu tiên của mảng số nguyên: "+arrInt[0]);
        System.out.println("Phần tử đầu tiên của mảng số thực: "+arrFloat[0]);
        System.out.println("Phần tử đầu tiên của mảng chuỗi: "+arrStr[0]);
        System.out.println("Phần tử đầu tiên của mảng boolean: "+arrBool[0]);
    }
}
