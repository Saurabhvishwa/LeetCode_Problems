class Solution {
    public int[][] generateMatrix(int n) {
        int number = 1;
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int[][] mat = new int[n][n];
        int i = 0;
        while(true){
            i=left;
            while(i<=right){
                mat[top][i] = number;
                number++;
                i++;
            }
            top++;
            i = top;
            while(i<=bottom){
                mat[i][right] = number;
                number++;
                i++;
            }
            right--;
            i = right;
            while(i>=left){
                mat[bottom][i] = number;
                number++;
                i--;
            }
            bottom--;
            i = bottom;
            while(i>=top){
                mat[i][left] = number;
                number++;
                i--;
            }
            left++;
            if(number > n*n){
                break;
            }
            
        }
        return mat;
    }
}