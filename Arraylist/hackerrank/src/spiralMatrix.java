import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 9/4/2017.
 */
public class spiralMatrix {


    public static void main(String[] args) {
        //  int[][] matrix=new int[][];
        List<Integer> result = new ArrayList<Integer>();
        int x = 0, y = 0;
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
        System.out.println(matrix[0].length);


// for single row or column-----------------------------------
        while (row > 0 && col > 0) {
            if (row == 1) {
                for (int i = 0; i < col; i++) {
                    result.add(matrix[x][y++]);
                }

                break;
            } else if (col == 1) {
                for (int j = 0; j < row; j++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }

//ends here---------------------------------------------------


            //top-right
            for (int i = 0; i < col - 1; i++)
                result.add(matrix[x][y++]);


            //right-down
            for (int i = 0; i < row - 1; i++)
                result.add(matrix[x++][y]);

            //bottom-left
            for (int i = 0; i < col - 1; i++)
                result.add(matrix[x][y--]);

            //bottom-top
            for (int i = 0; i < row - 1; i++)
                result.add(matrix[x--][y]);


            x++;
            y++;
            row=row-2;
            col=col-2;

        }
        //for(int i:result)
        System.out.println(result);
    }
}
