class Solution {
    public int longestValidParentheses(String s) {
        if(s.equals("")) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.empty()){
                    stack.pop();
                }
                if(!stack.empty()){
                    max = Math.max(max, i-stack.peek());
                }else{
                    stack.push(i);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}