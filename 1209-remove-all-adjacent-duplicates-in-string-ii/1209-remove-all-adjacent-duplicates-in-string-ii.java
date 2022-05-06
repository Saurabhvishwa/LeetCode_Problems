class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> sti = new Stack<>();
        sti.push(1);
        st.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
           if(st.isEmpty()){
               st.push(s.charAt(i));
               sti.push(i);
           }else if(st.peek() == s.charAt(i)){
               st.push(s.charAt(i));
               sti.push(sti.peek()+1);
           }else{
               sti.push(1);
               st.push(s.charAt(i));
           }
            if(sti.peek() == k){
                int count = sti.peek();
                while(count>0){
                    sti.pop();
                    st.pop();
                    count--;
                }
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop()+ans;
        }
        return ans;
    }
}