class Solution {
    public void permutation(int[] nums, int index, List<List<Integer>> ans, List<Integer> temp){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                permutation(nums, i+1, ans, temp);
                temp.remove(temp.size()-1);
                
            }
        }
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums, 0, ans, new ArrayList<Integer>());
        return ans;
    }
}