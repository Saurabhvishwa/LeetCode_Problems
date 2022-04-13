class Solution {
    public String commonPrefix(String s1, String s2){
        int len = Math.min(s1.length(), s2.length());
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<len;i++){
            if(s1.charAt(i) == s2.charAt(i)){
                sb.append(String.valueOf(s1.charAt(i)));
            }else{
                break;
            }
        }
        return sb.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for(int i=1;i<strs.length;i++){
            ans = commonPrefix(ans, strs[i]);
        }
        return ans;
    }
}