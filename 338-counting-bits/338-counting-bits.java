class Solution {
    public int getBits(int x){
        if(x == 0 || x == 1) return x;
        int count = 0;
        while(x>0){
            if(x%2==1) count++;
            x = x>>1;
        }
        return count;
    }
    public int[] countBits(int n) {
        int count = 0;
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i] = getBits(i);
        }
        return ans;
    }
}