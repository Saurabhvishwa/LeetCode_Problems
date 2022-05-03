class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[2][word2.length()+1];
        dp[0][0] = 0;
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                if(i == 0 && j == 0){
                    dp[i%2][j] = 0;
                }
                else if(i == 0){
                    dp[i%2][j] = j;
                }else if(j == 0){
                    dp[i%2][j] = i;
                }else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i%2][j] = dp[(i-1)%2][j-1];
                    }else{
                        dp[i%2][j] = 1+Math.min(Math.min(dp[(i-1)%2][j-1], dp[(i-1)%2][j]), dp[i%2][j-1]);
                    }
                }
            }
        }
        for(int[] i:dp){
            System.out.println(Arrays.toString(i));
        }
        return dp[word1.length()%2][word2.length()];
    }
}