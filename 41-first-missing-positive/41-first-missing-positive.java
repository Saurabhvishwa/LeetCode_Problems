class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        for(i=0;i<n;i++){
            if(nums[i] == 1){
                break;
            }
        }
        if(i == n) return 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(i=0;i<n;i++){
            if(nums[i]<=0 || nums[i] > n) map.put(1,1);
            else map.put(nums[i], 1);
        }
        for(i=1;i<=n;i++){
            if(!map.containsKey(i)) return i;
        }
        return n+1;
    }
}