package demo_mang_2_chieu;

public class NhanMaTran {
    public static void main(String[] args) {
        int[][] A = {{1,2,3,1},{4,5,6,2},{7,8,9,1}};
        int[][] B = {{1,2,3},{5,6,7},{1,2,1},{2,2,2}};

        System.out.println("Số dòng của mảng A: "+A.length);
        System.out.println("Số cột của mảng A: "+A[0].length);

        //Số cột của ma trận thứ nhất bằng số dòng của ma trận thứ hai thì 2 ma trận nhân được với nhau
        // A(m,p) x B(p,n) = C(m,n)
        if(A[0].length==B.length){
            System.out.println("Hai ma trận nhân được với nhau");
            int C[][] = new int[A.length][B[0].length];
            for(int i=0;i<A.length;i++){
                for(int j=0;j<B[0].length;j++){
                    C[i][j]=0;
                    for(int k=0;k<A[0].length;k++){
                        C[i][j] += A[i][k]*B[k][j];
                    }
                }
            }
            System.out.println("Ma trận tiích: ");
            for(int i=0;i<C.length;i++){
                for(int j=0;j<C[0].length;j++){
                    System.out.print(C[i][j]+"\t");
                }
                System.out.println();
            }
        }else{
            System.out.println("Hai ma trận không nhân được với nhau");
        }
    }
}
