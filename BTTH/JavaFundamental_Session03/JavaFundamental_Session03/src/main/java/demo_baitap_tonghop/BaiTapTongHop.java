package demo_baitap_tonghop;

import java.util.Scanner;

public class BaiTapTongHop {
    public static void main(String[] args) {
        int choose;
        Scanner sc = new Scanner(System.in);

        int[] ids;
        String[] titles;
        int[] quantities;

        int n;
        do{
            System.out.println("Nhập vào số lượng sách cần quản lý: ");
            n = sc.nextInt();
            if(n<1){
                System.out.println("Số lượng sách cần quản lý phải >1");
            }
        }while(n<1);

        //Khởi tạo 3 mảng
        ids = new int[n];
        titles = new String[n];
        quantities = new int[n];

        int total = 0;

        while (true) {
            System.out.println("\n-------------  MENU -------------");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Cập nhật số lượng");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Sắp xếp theo số lượng giảm dần");
            System.out.println("7. Thoát");
            System.out.println("Mời chọn chức năng: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    if(total==0){
                        System.out.println("Chưa có thông tin sách nào");
                    }else{
                        System.out.println("Thông tin các sách đang quản lý: ");
                        for(int i=1;i<=54;i++){
                            System.out.print("-");
                        }
                        System.out.printf("\n|%-10s|%-30s|%-10s|\n","Mã sách","Tên sách","Số lượng");
                        for(int i=1;i<=54;i++){
                            System.out.print("-");
                        }
                        for(int i=0;i<total;i++){
                            System.out.printf("\n|%-10d|%-30s|%-10d|\n",ids[i],titles[i],quantities[i]);
                            for(int j=1;j<=54;j++){
                                System.out.print("-");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nhập vào mã sách mới: ");
                    ids[total] = sc.nextInt();
                    System.out.println("Nhập vào tên sách mới: ");
                    sc.nextLine();
                    titles[total] = sc.nextLine();
                    System.out.println("Nhập vào số lượng sách mới: ");
                    quantities[total] = sc.nextInt();
                    total++;
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Bạn phải chọn từ 1 đến 7");
            }
        }
    }
}
