class Solution {
    public void combFinder(int[] arr, int target, List<List<Integer>> ans, List<Integer> temp, int index){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
        }
        
        for(int i=index;i<arr.length;i++){
            if(arr[i]>target) break;
            if(i>index && arr[i] == arr[i-1]) continue;
            temp.add(arr[i]);
            combFinder(arr, target-arr[i], ans, temp, i+1);
            temp.remove(temp.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        combFinder(candidates, target, ans, new ArrayList<Integer>(), 0);
        return ans;
    }
}