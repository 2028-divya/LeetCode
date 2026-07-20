class Solution {
    public void rotate(int[][] matrix) {
        int temp;
        // Step 1: Transpose
        for(int i = 0; i< matrix.length; i++){
            for(int j = i+1; j < matrix.length; j++){
                temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // Step 2: Reverse each row
        for(int i = 0; i< matrix.length; i++){
            int startCol=0;
            int endCol= matrix[i].length-1;
            while(startCol<endCol){
                temp= matrix[i][startCol];
                matrix[i][startCol]= matrix[i][endCol];
                matrix[i][endCol]=temp;
                startCol++;
                endCol--;
            }
        }
    }
}