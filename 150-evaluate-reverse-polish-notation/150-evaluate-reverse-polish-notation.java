class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s:tokens){
            if(s.equals("+")){
                int first = st.pop(), second = st.pop();
                st.push(second+first);
            }else if(s.equals("-")){
                int first = st.pop(), second = st.pop();
                st.push(second-first);
            }else if(s.equals("*")){
                int first = st.pop(), second = st.pop();
                st.push(second*first);
            }else if(s.equals("/")){
                int first = st.pop(), second = st.pop();
                st.push(second/first);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}