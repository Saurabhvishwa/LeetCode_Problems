class Solution {
    int count = 0;
    public void findWays(int[] nums, int target, int index){
        if(target == 0){
            count++;
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(nums[i] != 0 && target-nums[i]>=0){
                findWays(nums, target-nums[i], i+1);
            }
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        
        int n = nums.length;
        int s2 = (sum - target)/2;
        int[][] t = new int[n + 1][s2 + 1];
        t[0][0] = 1;
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < s2 + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][s2];
    }
}