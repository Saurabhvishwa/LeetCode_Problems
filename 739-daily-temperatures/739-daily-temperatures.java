class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=ans.length-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = 0;
            }
            else ans[i] = st.peek()-i;
            if(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) st.push(i);
            else st.push(i);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}