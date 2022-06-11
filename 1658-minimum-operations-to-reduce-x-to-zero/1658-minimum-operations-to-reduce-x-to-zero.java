class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x, len = nums.length; 
        int right = 0, max= 0; int sum = 0;

        for(int num: nums)
            target += num;

        if(target == 0)
            return nums.length;
        for(int i=0;i<nums.length;i++){
            while(sum<target && right<nums.length){
                sum += nums[right++];
            }
            if(sum == target) max = Math.max(max, right-i);
            sum -= nums[i];
        }
        return max == 0 ? -1 : nums.length-max;
    }
}