class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        int[] str = new int[256];
        int[] pat = new int[256];
        
        for(int i=0;i<n;i++){
            pat[t.charAt(i)]++;
        }
        int start = 0, index = -1, min = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0;i<m;i++){
            str[s.charAt(i)]++;
            if(str[s.charAt(i)] <= pat[s.charAt(i)]){
                count++;
            }
            if(count == n){
                while(str[s.charAt(start)] > pat[s.charAt(start)] || pat[s.charAt(start)] == 0){
                    if(str[s.charAt(start)] > pat[s.charAt(start)]){
                        str[s.charAt(start)]--;
                    }
                    start++;
                }
                int len = i - start + 1;
                if(min > len){
                    min = len;
                    index = start;
                }
            }
        }
        if(index == -1){
            return "";
        }
        return s.substring(index, index+min);
    }
}