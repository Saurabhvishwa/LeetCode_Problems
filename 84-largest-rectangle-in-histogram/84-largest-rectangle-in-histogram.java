class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = 0;
        int i=0;
        while(i<n){
            if(st.isEmpty() || heights[st.peek()] <= heights[i]){
                st.push(i);
                i++;
            }else{
                int top = heights[st.pop()];
                int area = top*i;
                if(!st.isEmpty()){
                    area = top*(i-st.peek()-1);
                }
                max = Math.max(max, area);
            }
        }
        while(!st.isEmpty()){
            int top = heights[st.pop()];
            int area = top*i;
            if(!st.isEmpty()){
                area = top*(i - st.peek()-1);
            }
            max = Math.max(max, area);
        }
        return max;
    }
}