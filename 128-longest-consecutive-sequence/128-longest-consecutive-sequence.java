class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1 ) return nums.length;
        Arrays.sort(nums);
        int start = 0,max = 0, n = nums.length, i=0, count = 1;
        for(i=1;i<n;i++){
            if(nums[i] == nums[i-1]+1){
                count++;
                continue;
            }else if(nums[i] == nums[i-1]) continue;
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}