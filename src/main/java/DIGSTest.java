import digs.Sort2DMatrix;

import java.util.Random;

public class DIGSTest {
    public static void main(String[] args) {

        int paramSize=20; //Number of total contraints
        int constSize=5; // number of constraints
        int [][] costMat = new int [5][20];



        System.out.print("Cost Matrix\n ");
        //Generating the cost matrix
        for(int i = 0; i < constSize; i++){ // 1 2 3 4 5
            for(int j = 0; j <paramSize; j++) { // 1 2 3 4 5
                Random r = new Random();
                costMat[i][j] =  r.nextInt(100) ;
                if (costMat[i][j]<10) {
                    System.out.print(" " + costMat[i][j] + " ");
                } else {
                    System.out.print(costMat[i][j] + " ");
                }
            }//end of for J
            System.out.println();
        }//end of for i

        
        System.out.print("Sorted Array\n ");
        Sort2DMatrix.sortRowWise(costMat);

    }
}
