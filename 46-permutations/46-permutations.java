class Solution {
    public void permutation(int[] nums, int index, List<List<Integer>> ans, List<Integer> temp){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != Integer.MAX_VALUE){
                temp.add(nums[i]);
                int value = nums[i];
                nums[i] = Integer.MAX_VALUE;
                permutation(nums, i+1, ans, temp);
                temp.remove(temp.size()-1);
                nums[i] = value;
                
            }else continue;
        }
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums, 0, ans, new ArrayList<Integer>());
        return ans;
    }
}