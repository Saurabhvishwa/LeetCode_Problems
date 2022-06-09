class Solution {
    public int majorityElement(int[] nums) {
        int el = 0, freq = 0, n = nums.length;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=i;j<n;j++){
                if(nums[j] == nums[i]) count++;
            }
            if(count > freq){
                freq = count;
                el = nums[i];
            }
        }
        return el;
    }
}