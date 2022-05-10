class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combFinder(1, n, k, new ArrayList<Integer>(), ans);
        return ans;
        
    }
    
    public void combFinder(int start, int sum, int k, List<Integer> temp, List<List<Integer>> ans){
        if(sum == 0){
            if(temp.size() == k){
                ans.add(new ArrayList<>(temp));
            }
            return ;
        }
        for(int i=start;i<=9;i++){
            temp.add(i);
            combFinder(i+1, sum-i, k, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
}