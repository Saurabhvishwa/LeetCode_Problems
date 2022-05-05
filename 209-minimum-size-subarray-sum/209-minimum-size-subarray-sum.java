class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    int i=-1;
        int j=-1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(i<nums.length && j< nums.length){
            if(sum>= target){
                min = Math.min(min, i-j);
                j++;
                if(j>=nums.length) break;
                sum -= nums[j];
            }else{
                i++;
                if(i>=nums.length) break;
                sum+=nums[i];
            }
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
}