class Solution {
    public List<List<Integer>> getPascal(int n){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        for(int i=2;i<=n;i++){
            temp = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(j == 0 || j == i-1){
                    temp.add(1);
                }else{
                    int value = ans.get(i-2).get(j-1)+ans.get(i-2).get(j);
                    temp.add(value);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        return getPascal(numRows);
    }
}