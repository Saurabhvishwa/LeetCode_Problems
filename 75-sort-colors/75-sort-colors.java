class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0, one = 0, two = 0;
        for(int i:nums){
            if(i == 0)zero++;
            else if(i == 1) one++;
            else two++;
        }
        int i = 0;
        while(zero > 0 || one > 0 || two > 0){
            if(zero>0){
                nums[i] = 0;
                zero--;
            }else if(one>0){
                nums[i] = 1;
                one--;
            }else if(two>0){
                nums[i] = 2;
                two--;
            }
            i++;
        }
    }
}