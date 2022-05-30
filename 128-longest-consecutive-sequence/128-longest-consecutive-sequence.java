class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1 ) return nums.length;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i:nums){
            if(set.contains(i-1)) continue;
            else{
                int num = i;
                int count = 0;
                while(set.contains(num)){
                    ++count;
                    ++num;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}