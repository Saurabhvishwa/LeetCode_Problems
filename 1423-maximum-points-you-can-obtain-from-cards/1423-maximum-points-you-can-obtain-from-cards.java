class Solution {
    public int maxScore(int[] cardPoints, int k) {
        k = cardPoints.length-k;
        int minSum = 0;
        int sum = 0, start = 0;
        for(int i=0;i<k;i++){
            sum += cardPoints[i];
            minSum += cardPoints[i];
        }
        int curMinSum = minSum;
        for(int i=k;i<cardPoints.length;i++){
            sum += cardPoints[i];
            curMinSum += cardPoints[i] - cardPoints[start++];
            minSum = Math.min(minSum, curMinSum);
        }
        return sum-minSum;
    }
}