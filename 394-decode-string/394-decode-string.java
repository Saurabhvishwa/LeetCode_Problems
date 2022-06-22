class Solution {
    public String decodeString(String s) {
        String temp = "", top = "", k = "", peek = "", merge = "";
        int value = 0;
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ']') st.push(String.valueOf(s.charAt(i)));
            else{
                temp = "";
                top = st.pop();
                while(!top.equals("[")){
                    temp = top + temp;
                    top = st.pop();
                }
                k = st.pop();
                peek = st.isEmpty() ? null : st.peek();
                while(peek != null && "0".compareTo(peek) <= 0 && "9".compareTo(peek)>=0){
                    k = st.pop() + k;
                    peek = st.isEmpty() ? null : st.peek();
                }
                value = Integer.parseInt(k);
                merge = "";
                while(value>0){
                    merge += temp;
                    value--;
                }
                st.push(merge);
            }
        }
        StringBuilder ans = new StringBuilder("");
        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }
        return ans.toString();
    }
}