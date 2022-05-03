class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // int[] temp = nums;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int start = -1;
        int end = -1;
        for(int i=0;i<temp.length;i++){
            if(temp[i] == nums[i]){
                continue;
            }
            if(start == -1 && temp[i]!=nums[i]){
                start = i;
            }
            if(temp[i]!=nums[i]){
                end = i;
            }
        }
        if(start == -1 || end == -1){
            return 0;
        }
        return end - start + 1;
    }
}