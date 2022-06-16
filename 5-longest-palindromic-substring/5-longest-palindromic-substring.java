class Solution {
    public String getLength(String s, int start, int end){
        if(start<0 || end >= s.length()) return "";
        while(start>=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }
    public String longestPalindrome(String s) {
        if(s.equals("") || s == null){
            return "";
        }
        int n = s.length();
        String temp = "", max ="";
        for(int i=0;i<n;i++){
            temp = getLength(s, i, i);
            if(temp.length()>max.length()){
                max = temp;
            }
            temp =  getLength(s, i, i+1);
            if(temp.length()>max.length()){
                max = temp;
            }
        }
        return max;
        
    }
}