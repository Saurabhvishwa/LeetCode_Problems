class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        if(nums[0] == 0) return -1;
        
        int cur = -1, ans = 0, jumps = 0;
        for(int i=0;ans<nums.length-1;i++){
            if(i>cur){
                jumps++;
                cur = ans;
            }
            ans = Math.max(ans, i+nums[i]);
        }
        return jumps;
        
        // int maxReach = nums[0], steps = nums[0], jumps = 1;
        // for(int i=1;i<nums.length;i++){
        //     if(i == nums.length-1) return jumps;
        //     maxReach = Math.max(maxReach, i+nums[i]);
        //     steps--;
        //     if(steps == 0){
        //         if(i >= maxReach) return -1;
        //         jumps++;
        //         steps = maxReach - i;
        //     }
        // }
        // return -1;
    }
}