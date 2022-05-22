class Solution {
    public int max(String s, int k, char c){
        int left = 0, right = 0, max = Integer.MIN_VALUE, count = 0;
        while(right<s.length()){
            if(s.charAt(right) != c) count++;
            while(count>k){
                if(s.charAt(left) != c) count--;
                left++;
            }
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE;
        for(char c='A';c<='Z';c++){
            max = Math.max(max, max(s, k, c));
        }
        return max;
    }
}