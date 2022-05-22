class Solution {
    public int findPalindrome(String s, int l, int r, int n){
        int count = 0;
        while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            count += findPalindrome(s, i, i, n);
            count += findPalindrome(s, i, i+1, n);
        }
        return count;
    }
}