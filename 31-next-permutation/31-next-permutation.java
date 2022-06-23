class Solution {
    public void getPerm(int[] nums){
        int index;
        int i=0,j=0;
        for(i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]) break;
        }
        if(i<0){
            int x = 0, y = nums.length-1;
            while(x<y){
                int temp = nums[x];
                nums[x] = nums[y];
                nums[y] = temp;
                x++;y--;
            }
            return;
        }
        for(j=nums.length-1;j>i;j--){
            if(nums[j]>nums[i]) break;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        Arrays.sort(nums, i+1, nums.length);
    }
    public void nextPermutation(int[] nums) {
        getPerm(nums);
    }
}