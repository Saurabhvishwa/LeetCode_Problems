class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x; int len = nums.length; 
    int right = 0; int max_length = 0; int sum = 0;
    
    for(int num: nums)
        target += num;
        
    if(target == 0)
        return nums.length;
    
    for(int i = 0; i<nums.length; i++){
        while(sum < target && right<len)
            sum += nums[right++];
        
        if(sum == target)
            max_length = Math.max(max_length, right-i);
        sum -= nums[i];
    }
    return max_length == 0? -1:nums.length - max_length;
    }
}