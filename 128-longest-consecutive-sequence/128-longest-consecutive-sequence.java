class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1 ) return nums.length;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i:nums){
            if(!set.contains(i-1)){
                int num = i;
                int count = 1;
                while(set.contains(++num)){
                    ++count;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}