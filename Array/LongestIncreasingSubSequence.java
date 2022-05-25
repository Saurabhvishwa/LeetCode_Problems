// Time Complexity = O(n)
// Space Complexity = O(n)

clas LIS{
  public static int getLIS(int[] arr, int n){
    int[] dp = new int[n];
    int ans = 0;
    for(int el : arr){
      int left = Arrays.binarySearch(dp, 0, ans, el);
      if(left < 0) left = -left - 1;
      if(left == ans) ans++;
      dp[left] = el;
    }
    return ans;
  }
}
