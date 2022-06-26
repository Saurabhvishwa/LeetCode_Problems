class Solution {
    public int maxScore(int[] cardPoints, int k) {
        k = cardPoints.length-k;
        int sum = 0, start = 0;
        int curMinSum = 0, minSum = Integer.MAX_VALUE;
        for(int i=0;i<cardPoints.length;i++){
            sum += cardPoints[i];
            if(i<k) curMinSum += cardPoints[i];
            else curMinSum += cardPoints[i] - cardPoints[start++];
            if(i>=k-1) minSum = Math.min(minSum, curMinSum);
        }
        System.out.println(k+" "+minSum+" "+sum);
        return sum-minSum;
    }
}