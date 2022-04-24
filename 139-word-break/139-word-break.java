class Solution {
    public boolean wordSegment(String s, List<String> dict, int n){
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=0;i<=n;i++){
            if(dp[i]){
                for(String str:dict){
                    int end = i+str.length();
                    if(end<=s.length()){
                        if(str.equals(s.substring(i,end))){
                            dp[end] = true;
                        }
                    }else continue;
                }
            }else continue;
        }
        return dp[n];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordSegment(s, wordDict,s.length());
    }
}