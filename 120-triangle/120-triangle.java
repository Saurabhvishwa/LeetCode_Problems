class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[2][triangle.get(n-1).size()];
        for(int i=1;i<2;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=0;j<triangle.get(i-1).size();j++){
                if(j == 0){
                    dp[i%2][j] = dp[(i-1)%2][j] + triangle.get(i-1).get(j);
                }else if(j == triangle.get(i-1).size()-1){
                    dp[i%2][j] = dp[(i-1)%2][j-1] + triangle.get(i-1).get(j);
                }
                else{
                    dp[i%2][j] = Math.min(dp[(i-1)%2][j], dp[(i-1)%2][j-1]) + triangle.get(i-1).get(j);
                }
                if(i == n){
                    if(dp[i%2][j] < min) min = dp[i%2][j];
                }
            }
        }
        return min;
    }
}