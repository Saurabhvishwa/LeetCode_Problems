class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(height[0]);
        left[0] = -1;
        for(int i=1;i<height.length;i++){
            if(stack.peek() > height[i]){
                left[i] = stack.peek();
            }else{
                stack.push(height[i]);
                left[i] = -1;
            }
        }
        right[right.length-1] = -1;
            stack.clear();
        stack.push(height[height.length-1]);
        for(int i=right.length-2;i>=0;i--){
            if(stack.peek() > height[i]){
                right[i] = stack.peek();
            }else{
                stack.push(height[i]);
                right[i] = -1;
            }
        }
        
        int result = 0;
        for(int i=0;i<height.length;i++){
            if(left[i] != -1 && right[i] != -1){
                result += Math.abs(Math.min(left[i], right[i]) - height[i]);
            }
        }
        return result;
    }
}