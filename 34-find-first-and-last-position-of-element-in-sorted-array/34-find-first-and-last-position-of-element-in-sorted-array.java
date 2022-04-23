class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int[] result = new int[2];
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else end = mid-1;
        }
        result[0] = start;
        
        start = 0;
        end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                start = mid+1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else end = mid-1;
        }
        result[1] = end;
        if(result[0] > result[1]){
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }
}