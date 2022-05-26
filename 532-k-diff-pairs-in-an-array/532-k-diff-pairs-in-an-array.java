class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(k == 0 && map.containsKey(nums[i])){
                if(i>1 && nums[i] == nums[i-2]) continue;
                else{
                    count++;
                    continue;
                }
            }
            else if(k != 0 && i > 0 && nums[i] != nums[i-1]){
                if(map.containsKey(nums[i]-k)) count++;
            }
            map.put(nums[i], 1);
        }
        return count;
    }
}
