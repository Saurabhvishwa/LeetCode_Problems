class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                start = i;
                break;
            }
        }
        int end = -1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i] < nums[i-1]){
                end = i;
                break;
            }
        }
        if(start == -1 || end == -1){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            if(nums[i]>max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        for(int i=0;i<start;i++){
            if(nums[i]>min){
                start = i;
                break;
            }
        }
        for(int i=nums.length-1;i>end;i--){
            if(nums[i]<max){
                end = i;
                break;
            }
        }
        return end-start+1;
    }
}