class Solution {
    public boolean wordSegment(String s, List<String> dict){
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<=s.length();i++){
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
        return dp[s.length()];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordSegment(s, wordDict);
    }
}