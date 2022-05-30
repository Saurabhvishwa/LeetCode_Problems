class Solution {
    public void dfs(int num, int digit, int low, int high, List<Integer> ans){
        if(num>high) return;
        if(digit>10) return;
        if(num>=low && num<=high){
            ans.add(num);
        }
        num = num*10 + digit;
        dfs(num, digit+1, low, high, ans);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new LinkedList<>();
        for(int i=1;i<=9;i++){
            dfs(0, i, low, high, ans);
            if(i == 6) System.out.println(i+" "+ans);
        }
        Collections.sort(ans);
        return ans;
    }
}