class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start<=end){
            int m = (start+end)/2;
            if(nums[m] == target) return true;
            if(nums[start]<nums[m]){
                if(nums[start]<=target && target<nums[m]){
                    end = m-1;
                }else{
                    start = m+1;
                }
            }else if(nums[start]>nums[m]){
                if(nums[m]<target && target<= nums[end]){
                    start = m+1;
                }else end = m-1;
            }else{
                start++;
            }
        }
        return false;
    }
}