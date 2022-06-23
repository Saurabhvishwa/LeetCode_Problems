class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, max = 0;
        for(int i=0;i<prices.length;i++){
            if(buy > prices[i]) buy = prices[i];
            else max = Math.max(max, prices[i]-buy);
        }
        return max;
    }
}