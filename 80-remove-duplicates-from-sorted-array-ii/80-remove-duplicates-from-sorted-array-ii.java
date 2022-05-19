class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=1, n = nums.length;
        int count = 1;
        while(j<n){
            if(nums[i] == nums[j]){
                count++;
                if(count>2){
                   nums[j] = Integer.MIN_VALUE;
                }
            }else{
                i=j;
                count=1;
            }
            j++;
        }
        int index = 0;
        for(i=0;i<n;i++){
            if(nums[i] != Integer.MIN_VALUE){
               nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}