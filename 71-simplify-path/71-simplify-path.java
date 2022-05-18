class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        String[] arr = path.split("/");
        System.out.println(Arrays.toString(arr));
        Stack<String> st = new Stack<>();
        for(String s:arr){
            if(s.equals(".") || s.length() == 0){
                continue;
            }else if(s.equals("..")){
                if(st.size()>0){
                    st.pop();
                }
            }else{
                st.push(s);
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans = "/"+st.pop()+ans;
        }
        return ans.length() == 0 ? "/" : ans;
    }
}