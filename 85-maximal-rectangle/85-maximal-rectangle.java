class Solution {
    public void nextSmall(int[] row, int n, int[] next){
        Stack<Integer> stack = new Stack<>();
        int i=n-1;
        while(true){
            if(i == -1) break;
            if(stack.empty()){
                next[i] = n;
                stack.push(i);
                i--;
            }
            else if(row[stack.peek()]>=row[i]){
                stack.pop();
            }else{
                next[i] = stack.peek();
                stack.push(i);
                i--;
            }
        }
    }
    public void previousSmall(int[] row, int n, int[] prev){
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(true){
            if(i == n) break;
            if(stack.empty()){
                prev[i] = -1;
                stack.push(i);
                i++;
            }
            else if(row[stack.peek()]>=row[i]){
                stack.pop();
            }else{
                prev[i] = stack.peek();
                stack.push(i);
                i++;
            }
        }
    }
//     public int maxHis(int[] row, int n){
//         Stack<Integer> stack = new Stack<>();
//         int top;
//         int maxArea = 0;
//         int area = 0;
//         int i=0;
//         while(i<n){
//             System.out.println(stack);
//             if(stack.empty() || row[stack.peek()] <= row[i]){
//                 stack.push(i);
//                 i++;
//             }else{
//                 top = row[stack.peek()];
//                 stack.pop();
//                 area = top*i;
//                 if(!stack.empty()){
//                     area = top*(i-stack.peek()-1);
//                 }
//                 maxArea = Math.max(maxArea, area);
//             }
//         }
//         while (!stack.empty()) {
//             top = row[stack.peek()];
//             stack.pop();
//             area = top * i;
//             if (!stack.empty()){
//                 area = top * (i - stack.peek() - 1);
                
//             }
//             maxArea = Math.max(area, maxArea);
//         }
//         return maxArea;
//     }
    public int getMax(int[] prev, int[] next, int[] row){
        int max = 0;
        for(int i=0;i<row.length;i++){
            max = Math.max(max, (next[i]-prev[i]-1)*row[i]);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int[][] row = new int[matrix.length][matrix[0].length];
        int[] prev = new int[matrix[0].length];
        int[] next = new int[matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '0'){
                    row[i][j] = 0;
                }else{
                    if(i>0){
                        row[i][j] = row[i-1][j]+1;
                    }else{
                        row[i][j] = 1;
                    }
                }
            }
            previousSmall(row[i], row[i].length, prev);
            nextSmall(row[i], row[i].length, next);
            max = Math.max(max, getMax(prev, next, row[i]));
        }
        return max;
    }
}