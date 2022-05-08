class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        for(i=0;i<n;i++){
            if(nums[i] == 1){
                break;
            }
        }
        if(i == n) return 1;
        
        for(i=0;i<n;i++){
            if(nums[i]<=0 || nums[i]>n){
                nums[i] = 1;
            }
        }
        for(i=0;i<n;i++){
            nums[(nums[i]-1)%n] += n;
        }
        for(i=0;i<n;i++){
            if(nums[i]<=n) return i+1;
        }
        return n+1;
    }
}