class Solution {
    List<List<Integer>> ans;
    public void comb(int index, int n, int k, LinkedList<Integer> temp){
        if(k == 0){
            ans.add(new LinkedList<>(temp));
            return;
        }
        for(int i=index;i<=n-k+1;i++){
            temp.add(i);
            comb(i+1, n, k-1, temp);
            temp.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        ans = new LinkedList<>();
        comb(1, n, k, new LinkedList<Integer>());
        return ans;
    }
}