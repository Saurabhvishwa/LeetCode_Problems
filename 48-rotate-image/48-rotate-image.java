class Solution {
    public void transpose(int[][] matrix, int n){
        for(int i=0;i<n ;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    public void rotate(int[][] matrix, int n){
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        // transpose(matrix, matrix.length);
        // rotate(matrix, matrix.length);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int j=0;j<matrix.length/2;j++){
            for(int i=0;i<matrix.length;i++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}