class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, curMax = 0;
        for(int i:nums){
            curMax = Math.max(curMax+i, i);
            max = Math.max(max, curMax);
        }
        return max;
    }
}