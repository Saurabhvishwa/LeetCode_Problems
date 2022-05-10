class Solution {
    public int jump(int[] nums) {
        int curr = -1;
        int last = 0;
        int jumps = 0;
        for(int i=0;last<nums.length-1;i++){
            if(i>curr){
                jumps++;
                curr = last;
            }
            last = Math.max(last, i+nums[i]);
        }
        return jumps;
    }
}