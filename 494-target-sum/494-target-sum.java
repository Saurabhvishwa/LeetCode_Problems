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
        int zeroCount = 0;
        for(int el : nums){
            if(el == 0)zeroCount++;
            sum += el;
        }
        target = sum-target;
        if(target < 0 || target%2==1) return 0;
        findWays(nums, target/2, 0);
        if(zeroCount>0){
            count *= Math.pow(2, zeroCount);
        }
        return count;
    }
}