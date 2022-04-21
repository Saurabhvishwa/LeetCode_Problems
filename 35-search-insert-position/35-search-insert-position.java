class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target<=nums[0]) return 0;
        else if(target>nums[nums.length-1]) return nums.length;
        int start = 0;
        int end = nums.length-1;
        int middle;
        int index=-1;
        while(start<=end){
            middle = start + (end-start)/2;
            if(target == nums[middle]){
                index = middle;
                end = middle-1;
            }else if(target<nums[middle]){
                end = middle-1;
            }else{
                start = middle+1;
            }
        }
        System.out.println(start+" "+end);
        return index == -1 ? start:index;
    }
}