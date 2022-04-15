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
        transpose(matrix, matrix.length);
        rotate(matrix, matrix.length);
    }
}