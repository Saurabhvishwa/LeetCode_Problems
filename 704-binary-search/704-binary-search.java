class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int middle;
        while(start<=end){
            middle = (start+end)/2;
            if(nums[middle] == target){
                return middle;
            }else if(target>nums[middle]){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return -1;
    }
}