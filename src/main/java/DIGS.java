import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DIGS {

    List<Integer> blockRow=new ArrayList<>();
    List<Integer> blockRowCol=new ArrayList<>();

    //do one pass of DIGS
    public void onePassDIGS(KeyValuePair [][] costMatSorted, int gammaConst[]) {


       for(int k=0;k<costMatSorted[0].length;k++){    //for j in 0:numCol {


            for(KeyValuePair [] row:costMatSorted){   //   for each row in sortedC {
                int sum=0;
                int indexes[]= new int[k+1];
                int rowInd=-1;// defines which row of cost matrix is used
                   for(int j=0;j<k+1;j++){
                       rowInd++; //update the row index
                       sum+=row[j].getValue();
                       indexes[j]=row[j].getKey();

                       // you have to call checkLocalOptimal(sum,gammaConst[rowInd]) here and pass the sum and gammaConst
                       //if(checkLocalOptimal()){

                                //int rowIndTest=-1;
                               //Iterate through all remaining rows of the cost matrix for(KeyValuePair [] testRow:costMatSorted){
                                       //rowIndTest++;

                                        //skip the testRow which doesn't match rowInd  //if(!rowIndTest==rowInd){
                                                        // you have to call checkGlobalOptimal(indexes,costMatSorted,gammaConst)
                                                        // here and pass the indexes of given row, entire sorted and gamma constraint matrix
                                                            //if(checkGlobalOptimal()) {

                                                                         //add to optimality list
                                                           //}


                                        //}

                                //}  end of loop iterating through remaining rows of cost matrix to check global optimality



                        //}//end of if checking if local optimality is not violated

                       System.out.print("("+row[j].getKey()+","+row[j].getValue()+") ");


                   }
               System.out.print(" Sum --> " + sum+" Indexes--> ");
                   for(int m=0;m<indexes.length;m++){
                       System.out.print(indexes[m]+" ,");
                   }
                   System.out.println();

            }

           System.out.println("Pass No. "+k+1+" completed. ");
        }







 }


    //check if a certain value is globally optimal or not
    //Input: indexes-->Indexes of current row, costMatSorted--> The entire cost matrix,  gammaConst--> matrix of constraints
    //Output: Returns true/false depending on if the global constraint is not violated
    public boolean checkGlobalOptimal(int indexes[], KeyValuePair [][] costMatSorted,int gammaConst[]) {

        return false;
    }



    //check if a certain value is locally optimal or not
    //Input: sum-->sum of cost values in the given row of cost matrix, gammma--> cost of given metric
    //Output: Returns true/false depending on if the local constraint is not violated
    public boolean checkLocalOptimal(int sum, int gamma) {

        return false;
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
