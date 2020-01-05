import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 11/27/2017.
 */
public class anotherSpiralMatrix {


    public static void main(String[] args) {


    Scanner scanner = new Scanner(System.in);
        System.out.println("enter row");
    int row = scanner.nextInt();
        System.out.println("enter col");
    int col = scanner.nextInt();
    int[][] matrix = new int[row][col];
        System.out.println("enter the elements");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                matrix[i][j] = scanner.nextInt();

            }
            System.out.println("\n");
        }


        int T=0;
        int B=row-1;
        int L=0;
        int R=col-1;
        int dir=0;

        while(T<=B && L<=R){
            //left to right
            if(dir==0){
                for(int k=T;k<=R;k++)
                    System.out.println(matrix[T][k]);
                T++;
            }
            //top to bottom
            if(dir==1){
                for(int k=T;k<=B;k++)
                    System.out.println(matrix[k][R]);
                R--;
            }

            //right to left
            if(dir==2){
                for(int k=R;k>=L;k--)
                    System.out.println(matrix[B][k]);
                B--;
            }

            //bottom to top
            if(dir==3){
                for(int k=B;k>=T;k--)
                    System.out.println(matrix[k][L]);
                L++;
            }
            dir=(dir+1)%4;
        }

    }
}
