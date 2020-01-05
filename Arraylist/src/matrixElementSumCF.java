/**
 * Created by Sharath Nagendra on 1/24/2018.
 */
public class matrixElementSumCF {

   static int matrixElementsSum(int[][] matrix) {
        if(matrix.length==0)
            return -1;
        int sum=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++) {
                if (i == 0 && j == 0) {
                    if (matrix[i][j] == 0)
                        continue;
                }
               if(i==0){

                   sum = sum + matrix[i][j];
               }
                if (i > 0) {
                 if (matrix[i - 1][j] == 0) {//bool value here to mark
                     matrix[i][j]=0;
                  //   continue;
                 }
                     else {
                        sum = sum + matrix[i][j];
                    }
//                if(matrix[i][j]==0)
//                    else {
//                        if (i != 0) {
//                            if (matrix[i - 1][j] == 0)
//                                continue;
//
//                        }
//                    }
//                }


                }
            }
        }
return sum;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,1,1,0},{0,5,0,1},{2,1,3,10}};
        System.out.println(matrixElementsSum(matrix));
    }
}
