class Solution {
    public void subset(int[] nums, int index, int n, LinkedList<Integer> temp, List<List<Integer>> ans){
        if(index>=n) return;
        temp.add(nums[index]);
        ans.add(new LinkedList<>(temp));
        subset(nums, index+1, n, temp, ans);
        temp.removeLast();
        subset(nums, index+1, n, temp, ans);
        }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(new LinkedList<>());
        int n = nums.length;
        subset(nums, 0, n, new LinkedList<>(), ans);
        return ans;
    }
}