class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int second = 1, first = 2;
        int ans = 0;
        for(int i=3;i<=n;i++){
            ans = first + second;
            second = first;
            first = ans;
        }
        return ans;
    }
}
