class Solution {
    public void makeZeroes(int[][] matrix, int m, int n, int row, int col){
//         making row elements zero
        for(int i=0;i<m;i++){
            if(i == row) continue;
            if(matrix[i][col] !=0){
                matrix[i][col] = -10;
            }
        }
//         making column elements zero
        for(int i=0;i<n;i++){
            if(i==col) continue;
            if(matrix[row][i] !=0){
                matrix[row][i] = -10;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    makeZeroes(matrix, m, n, i, j);
                }else continue;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == -10){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}