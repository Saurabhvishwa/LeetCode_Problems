class Solution {
    public void comb(int index, int n, int k, List<Integer> temp, List<List<Integer>> ans){
        if(k == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<=n;i++){
            temp.add(i);
            comb(i+1, n, k-1, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        comb(1, n, k, new ArrayList<Integer>(), ans);
        return ans;
    }
}