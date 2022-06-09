class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0, prefSum = 1;
        for(int i=columnTitle.length()-1;i>=0;i--){
            int val = columnTitle.charAt(i) - 'A' + 1;
            sum += val*prefSum;
            prefSum *= 26;
        }
        return sum;
    }
}