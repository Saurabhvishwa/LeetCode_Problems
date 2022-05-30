class Solution {
    public List<Integer> getPascal(int n){
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
                    int value = ans.get((i-2)%2).get(j-1)+ans.get((i-2)%2).get(j);
                    temp.add(value);
                }
            }
            if(ans.size()>1){
                ans.set((i-1)%2, temp);
            }else{
                ans.add(temp);
            }
        }
        return ans.get((n-1)%2);
    }
    public List<Integer> getRow(int rowIndex) {
        return getPascal(rowIndex+1);
    }
}