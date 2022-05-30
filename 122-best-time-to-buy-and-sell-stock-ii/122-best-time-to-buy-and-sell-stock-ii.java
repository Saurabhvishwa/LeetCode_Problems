class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int start = 0;
        int i=0;
        for(i=1;i<prices.length;i++){
            if(prices[i] <= prices[i-1]){
                max += prices[i-1]-prices[start];
                start = i;
            }
        }
        max += prices[i-1]-prices[start];
        return max;
    }
}