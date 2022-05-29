class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start<end){
            if(!Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start))) start++;
            if(!Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end))) end--;
            if((Character.isAlphabetic(s.charAt(start)) || Character.isDigit(s.charAt(start))) && ((Character.isAlphabetic(s.charAt(end)) || Character.isDigit(s.charAt(end))))){
                if(Character.isAlphabetic(s.charAt(start)) && Character.isAlphabetic(s.charAt(end)) && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                    return false;
                }else if(Character.isDigit(s.charAt(start)) && Character.isDigit(s.charAt(end)) && s.charAt(start) != s.charAt(end)){
                    return false;
                }else if(Character.isDigit(s.charAt(start)) && Character.isAlphabetic(s.charAt(end)) || Character.isDigit(s.charAt(end)) && Character.isAlphabetic(s.charAt(start))){
                    return false;
                }else{
                    start++;
                    end--;
                }
            }
        }
        return true;
    }
}