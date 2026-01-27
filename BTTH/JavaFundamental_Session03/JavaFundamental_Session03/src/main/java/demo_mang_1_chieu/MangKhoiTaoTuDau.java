package demo_mang_1_chieu;

public class MangKhoiTaoTuDau {
    public static void main(String[] args) {
        int arr[] = {2,5,3,6,4,6,6,4,6,5,7,7,5,6,8,7,8,8,8,5,7};

        System.out.println("In các phần tử của mảng: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }

        System.out.println("\n Sử dụng vòng lặp for-each: ");
        for(int elem: arr){
            System.out.print(elem+"\t");
        }

        System.out.println("\nĐếm số lần xuất hiện của mỗi phần tử khác nhau: ");
        //Sử dụng vòng lặp chạy từ đầu đến cuối (duyệt qua hết các phần tử của màng)
        //Sử dụng vòng lặp chạy từ đầu đến trước phần tử đang xét ở vòng lặp đầu
        //Nếu không có phần tử nào trùng thì đếm từ đó về sau
        for(int i=0;i<arr.length;i++){
            boolean isCounted = false;
            for(int j=0;j<i;j++){
                if(arr[j]==arr[i]){
                    isCounted = true;
                    break;
                }
            }
            if(!isCounted){
                int count = 1;
                for(int j=i+1;j<arr.length;j++){
                    if(arr[j]==arr[i]){
                        count++;
                    }
                }
                System.out.println(arr[i]+":\t"+count);
            }
        }
    }
}
