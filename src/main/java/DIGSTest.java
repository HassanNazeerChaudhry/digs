import java.util.Random;

public class DIGSTest {
    public static void main(String[] args) {

        DIGS dg=new DIGS();
        int paramSize=20; //Number of total constraints
        int constSize=5; // number of constraints
        int [][] costMat = new int [constSize][paramSize];
        KeyValuePair [][] costMatSorted = new KeyValuePair [constSize][paramSize];
        int gammaConst[]={41,32,53,61}; //Memory, Bandwidth, Processing, Storage

        //Generates the Cost Matrix
        System.out.print("Cost Matrix\n ");
        //Generating the cost matrix
        for(int i = 0; i < constSize; i++){
            for(int j = 0; j <paramSize; j++) {
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




       //add Key with each value
        costMatSorted=Utility.appendKey(costMat);
        System.out.print("Key Value Matrix \n ");
        Utility.printKeyValMat(costMatSorted,constSize,paramSize);

        //sorted each row separately
        System.out.print("Sorted Array\n ");
        costMatSorted=Utility.sortRowWise(costMatSorted);
        Utility.printKeyValMat(costMatSorted,constSize,paramSize);

        System.out.print("Test Array\n ");
       dg.onePassDIGS(costMatSorted);


    }
}
