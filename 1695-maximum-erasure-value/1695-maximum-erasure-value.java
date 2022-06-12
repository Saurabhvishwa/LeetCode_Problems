class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] pref = new int[n];
        for(int i=0;i<n;i++){
            if(i == 0) pref[i] = nums[i];
            else pref[i] = pref[i-1] + nums[i];
        }
        int start = -1, max = 0, i=0;
        for(;i<n;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i]) > start){
                    start = map.get(nums[i]);
                }
                map.put(nums[i], i);
            }else map.put(nums[i], i);
            if(start == -1){
                max = Math.max(max, pref[i]);
            }
            else max = Math.max(max, pref[i]-pref[start]);
        }
        return max;
    }
}