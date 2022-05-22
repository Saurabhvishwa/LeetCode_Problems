class Solution {
    public void subset(int[] nums, int index, List<List<Integer>> ans, LinkedList<Integer> temp, int n){
        ans.add(new ArrayList<>(temp));
        for(int i=index;i<n;i++){
            if(i == index || nums[i] != nums[i-1]){
                temp.add(nums[i]);
                subset(nums, i+1, ans, temp, n);
                temp.removeLast();
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subset(nums, 0, ans, new LinkedList<Integer>(), nums.length);
        return ans;
    }
}