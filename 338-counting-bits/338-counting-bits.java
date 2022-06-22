class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        if(n == 0) return ans;
        ans[1] = 1;
        int x = 0;
        for(int i=2;i<=n;i++){
            x = i/2;
            if((i&1) == 0) ans[i] = ans[x];
            else ans[i] = ans[x] + 1;
        }
        return ans;
    }
}