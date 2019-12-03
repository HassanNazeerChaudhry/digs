import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DIGS {

    List<Integer> blockRow=new ArrayList<>();
    List<RowCol> blockRowCol=new ArrayList<>();

    //do one pass of DIGS
    public void onePassDIGS(KeyValuePair [][] sortedCostMat,KeyValuePair [][] AugumentedCostMat, int gammaConst[]) {


       for(int k=0;k<sortedCostMat[0].length;k++){    //for j in 0:numCol {
           int rowInd=-1;// defines which row of cost matrix is used

            for(KeyValuePair [] row:sortedCostMat){   //   for each row in sortedC {
                int sum=0;
                int indexes[]= new int[k+1];

                  rowInd++; //update the row  index

               if(blockRow.contains(rowInd)){
                   System.out.println("................ THIS ROW IS BLOCKED...................");
               }


               // the stop condition
               if(blockRow.size()==AugumentedCostMat.length){
                   System.out.println("................ GAME OVER...................");
                   break;

               }

                if(!blockRow.contains(rowInd)){//check if the row is blocked

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
                            int checkInd =checkGlobalOptimal(indexes,rowIndTest,testRow,gammaConst[rowIndTest]);
                            if(checkInd==-1) {//its true

                                System.out.print(" GMATCHED ");
                            }
                            else{
                                System.out.println(" The new row col pair is added to the blocked col-->"+ "  ("+rowInd+","+checkInd+")");
                                blockRowCol.add(new RowCol(rowInd,checkInd));
                            }

                        }

                    }  //end of loop iterating through remaining rows of cost matrix to check global optimality


                }//end of if checking if local optimality is not violated
                else{
                    if(!blockRow.contains(rowInd)){
                        blockRow.add(rowInd);
                    }
                }




                if(blockRow.size()>0)
                    System.out.println(" .............Blockrow ");

                for(int j=0;j<blockRow.size();j++){
                    System.out.print(" "+blockRow.get(j));
                }

                System.out.println();


                     System.out.println("<------------------------------------->");


                       }//end of checking that if the row is blocked

                 }//inner row to select one row
            
            } //outmost loop to control columns


    }



    //check if a certain value is globally optimal or not
    //Input: indexes-->Indexes of current row, costMatSorted--> The entire cost matrix,  gammaConst--> matrix of constraints
    //Output: Returns true/false depending on if the global constraint is not violated
    public int checkGlobalOptimal(int indexes[], int colInd,  KeyValuePair[] testRow,int gammaConst) {
        //go through each index
        int globalSum=0;
        boolean isValid=false;



       for(int i=0;i<indexes.length;i++){
           System.out.println();

           for(int j=0;j<testRow.length;j++){

               // that col. is combination (row,col)
             // This is the point where you check col. && ()
               //if(check for if col and row constrain is not violated)
               if(testRow[j].getKey()==indexes[i] && !blockRowCol.contains(new RowCol(testRow[j].getKey(),colInd)))//skip the row from which the local constraint is taken
               {
                   System.out.print("Index-->"+indexes[i]+" test row index-->"+testRow[j].getKey());
                   globalSum+=testRow[j].getValue();

                   System.out.print(" global Constraint--> "+ gammaConst+" global sum--> "+ globalSum);

               }


           }

           System.out.println();

           if(globalSum>gammaConst){

              System.out.println(" ...............................................This index has failed-->"+indexes[i]);
               return indexes[i];

           }
           else{
               return -1;
           }


        }


       return -1;
    }



    //check if a certain value is locally optimal or not
    //Input: sum-->sum of cost values in the given row of cost matrix, gammma--> cost of given metric
    //Output: Returns true/false depending on if the local constraint is not violated
    public boolean checkLocalOptimal(int sum, int gamma) {

        return (gamma>sum);
    }



    //check if a certain value is blocked globally or not
    public boolean isBlockedGlobal() {
        return false;
    }



    //calculate the value which is globally optimal
    public void calGlobalOptimal(){


    }
}
