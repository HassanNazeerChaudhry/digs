import java.util.List;

public class Utility {


    static public KeyValuePair [][] appendKey(int mat[][]) {
        KeyValuePair [][] costMatIndexed = new KeyValuePair [mat.length][mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                costMatIndexed[i][j]=new KeyValuePair(j,mat[i][j]);


            }

        }

        return costMatIndexed;

    }

    static public KeyValuePair [][] sortRowWise(KeyValuePair mat[][])
    {
        //KeyValuePair [][] costMatSorted = new KeyValuePair [mat.length][mat[0].length];

        // loop for rows of matrix
        for (int i = 0; i < mat.length; i++) {

            // loop for column of matrix
            for (int j = 0; j < mat[i].length; j++) {

                // loop for comparison and swapping
                for (int k = 0; k < mat[i].length - j - 1; k++) {
                        KeyValuePair mVal=mat[i][k];
                        KeyValuePair mValNext=mat[i][k + 1];
                          if (mVal.getValue() > mValNext.getValue()) {
                                    mat[i][k]=mValNext;
                                    mat[i][k + 1]=mVal;
                            }

                }
            }
        }


        return mat;
    }

    static public void printKeyValMat(KeyValuePair costMatSorted[][], int constSize, int paramSize){

            for(int i=0;i<constSize;i++){
                for(int j=0;j<paramSize;j++){
                    if (costMatSorted[i][j].getValue()<10) {
                        System.out.print(" " + "("+ costMatSorted[i][j].getKey()+","+costMatSorted[i][j].getValue()+")"+ " ");
                    } else {
                        System.out.print("("+ costMatSorted[i][j].getKey()+","+costMatSorted[i][j].getValue()+")" + " ");
                    }
                }
                System.out.println();
            }

    }

    static public boolean isContainRowCol(List<RowCol> listRowCol, int row, int col){
        for(int s=0;s<listRowCol.size();s++) {
            if(listRowCol.get(s).getRow()==row && listRowCol.get(s).getCol()==col){
               return true;
            }
        }

        return false;

    }



}
