class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, cd = 0;
        for(int num:nums){
            if(count == 0){
                cd = num;
            }
            count += (num == cd) ? 1: -1;
        }
        return cd;
    }
}