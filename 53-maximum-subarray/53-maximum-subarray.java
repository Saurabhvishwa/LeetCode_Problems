class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int currentMax = 0;
        for(int i=0;i<nums.length;i++){
            currentMax = Math.max(currentMax+nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }
}