class Solution {
    
    public void getComb(List<List<Integer>> ans, List<Integer> temp, int[] arr, int index, int sum){
        if(sum == 0){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=index;i<arr.length;i++){
            if(sum - arr[i] >= 0){
                temp.add(arr[i]);
                getComb(ans, temp, arr, i, sum-arr[i]);
                
                temp.remove(temp.indexOf(arr[i]));
            }
        }
        return ;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        getComb(ans, temp, candidates, 0, target);
        return ans;
        
    }
}