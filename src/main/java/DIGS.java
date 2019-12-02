import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DIGS {

    List<Integer> blockRow=new ArrayList<>();
    List<Integer> blockRowCol=new ArrayList<>();

    //do one pass of DIGS
    public void onePassDIGS(KeyValuePair [][] sortedCostMat,KeyValuePair [][] AugumentedCostMat, int gammaConst[]) {


       for(int k=0;k<sortedCostMat[0].length;k++){    //for j in 0:numCol {
           int rowInd=-1;// defines which row of cost matrix is used

            for(KeyValuePair [] row:sortedCostMat){   //   for each row in sortedC {
                int sum=0;
                int indexes[]= new int[k+1];

                  rowInd++; //update the row index
                   for(int j=0;j<k+1;j++){

                       sum+=row[j].getValue();
                       indexes[j]=row[j].getKey();

                       System.out.print(" ("+row[j].getKey()+","+row[j].getValue()+")");



                     }//get subcolumns from each row

                System.out.print(" Sum--> "+sum+ " gamma constraint-->"+gammaConst[rowInd]);

                //Check if local optimality is violated
                if(checkLocalOptimal(sum,gammaConst[rowInd])){

                    System.out.print(" LMATCHED ");
                    int rowIndTest=-1;
                    //Iterate through all remaining rows of the cost matrix
                    for(KeyValuePair [] testRow:AugumentedCostMat){


                        rowIndTest++;

                        //skip the testRow which doesn't match rowInd
                        if(!(rowIndTest==rowInd)){
                            // Check global constraint
                            if(checkGlobalOptimal(indexes,testRow,gammaConst[rowIndTest])) {

                                System.out.print(" GMATCHED ");
                            }
                            else{
                                 System.out.print(" G-MISS-MATCHED");
                            }

                        }

                    }  //end of loop iterating through remaining rows of cost matrix to check global optimality


                }//end of if checking if local optimality is not violated


                System.out.println();

                     System.out.println("<------------------------------------->");

                 }//inner row to select one row
            
            } //outmost loop to control columns


    }



    //check if a certain value is globally optimal or not
    //Input: indexes-->Indexes of current row, costMatSorted--> The entire cost matrix,  gammaConst--> matrix of constraints
    //Output: Returns true/false depending on if the global constraint is not violated
    public boolean checkGlobalOptimal(int indexes[], KeyValuePair[] testRow,int gammaConst) {
        //go through each index
        int globalSum=0;
        boolean isValid=false;



       for(int i=0;i<indexes.length;i++){
           System.out.println();

           for(int j=0;j<testRow.length;j++){


               if(testRow[j].getKey()==indexes[i])//skip the row from which the local constraint is taken
               {
                   System.out.print("Index-->"+indexes[i]+" test row index-->"+testRow[j].getKey());
                   globalSum+=testRow[j].getValue();

                   System.out.print(" global Constraint--> "+ gammaConst+" global sum--> "+ globalSum);

               }


           }

           System.out.println();

           if(globalSum>gammaConst){
               isValid=false;
               break;
           }
           else{
               isValid=true;
           }


        }


       return isValid;
    }



    //check if a certain value is locally optimal or not
    //Input: sum-->sum of cost values in the given row of cost matrix, gammma--> cost of given metric
    //Output: Returns true/false depending on if the local constraint is not violated
    public boolean checkLocalOptimal(int sum, int gamma) {

        return (gamma>sum);
    }


    //check if a certain value is blocked locally or not
    public boolean isBlockedLocal( int rowInd, List<Integer> blockRow) {
        return false;
    }



    //check if a certain value is blocked globally or not
    public boolean isBlockedGlobal() {
        return false;
    }



    //calculate the value which is globally optimal
    public void calGlobalOptimal(){


    }
}
