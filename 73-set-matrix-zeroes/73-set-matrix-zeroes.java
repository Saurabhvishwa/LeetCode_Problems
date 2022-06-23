class Solution {
    public void makeZero(int[][] matrix, int m, int n){
        int row = 1, col = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 && matrix[i][j] == 0) row = 0;
                if(j == 0 && matrix[i][j] == 0) col = 0;
                else if(i>0 && j>0 && matrix[i][j] == 0){
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                }
            }
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == 0) matrix[i][j] = row*matrix[i][j];
                else if(j == 0) matrix[i][j] = col*matrix[i][j];
                else if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        matrix[0][0] = matrix[0][0]*row*col;
        
    }
    public void setZeroes(int[][] matrix) {
        int col0 = 1, m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0) col0 = 0;
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=1;j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if(col0 == 0) matrix[i][0] = 0;
        }
    }
}