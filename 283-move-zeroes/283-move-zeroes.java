class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[start] = nums[i];
                if(start != i){
                    nums[i] = 0;
                }
                start++;
            }
        }
    }
}