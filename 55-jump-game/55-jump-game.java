class Solution {
    public boolean isReachPossible(int[] nums, int n){
        if(n <= 1) return true;
        int max = nums[0];
        for(int i=0;i<n;i++){
            if(max <= i && nums[i] == 0){
                return false;
            }
            if(i+nums[i] > max){
                max = i+nums[i];
            }
            if(max >= n-1) return true;
        }
        return true;
    }
    public boolean canJump(int[] nums) {
        return isReachPossible(nums, nums.length);
    }
}