class Solution {
    public void permutation(int[] nums, int index, List<List<Integer>> ans, List<Integer> temp, Map<Integer, Integer> visited){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited.containsKey(nums[i])){
                temp.add(nums[i]);
                visited.put(nums[i], 1);
                permutation(nums, i+1, ans, temp, visited);
                temp.remove(temp.size()-1);
                visited.remove(nums[i]);
                
            }
        }
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums, 0, ans, new ArrayList<Integer>(), new HashMap<Integer, Integer>());
        return ans;
    }
}