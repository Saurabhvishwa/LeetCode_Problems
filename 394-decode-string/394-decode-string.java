class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ']') st.push(String.valueOf(s.charAt(i)));
            else{
                String temp = "";
                String top = st.pop();
                while(!top.equals("[")){
                    temp = top + temp;
                    top = st.pop();
                }
                String k = st.pop();
                String peek = st.isEmpty() ? null : st.peek();
                while(peek != null && "0".compareTo(peek) <= 0 && "9".compareTo(peek)>=0){
                    k = st.pop() + k;
                    peek = st.isEmpty() ? null : st.peek();
                }
                int value = Integer.parseInt(k);
                String merge = "";
                while(value>0){
                    merge += temp;
                    value--;
                }
                st.push(merge);
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}