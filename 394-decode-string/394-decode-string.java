class Solution {
    public String decodeString(String s) {
        String temp = "", top = "", peek = "", merge = "";
        StringBuilder k = new StringBuilder("");
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
                k.setLength(0);
                k.append(st.pop());
                peek = st.isEmpty() ? null : st.peek();
                while(peek != null && "0".compareTo(peek) <= 0 && "9".compareTo(peek)>=0){
                    k.insert(0, st.pop());
                    peek = st.isEmpty() ? null : st.peek();
                }
                value = Integer.parseInt(k.toString());
                merge = "";
                while((value--)>0){
                    merge += temp;
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