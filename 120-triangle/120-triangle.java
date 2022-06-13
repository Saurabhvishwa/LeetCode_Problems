class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][triangle.get(n-1).size()];
        for(int i=1;i<=n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<triangle.get(i-1).size();j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i-1).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i-1).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int el : dp[n]){
            if(el<min) min = el;
        }
        return min;
    }
}