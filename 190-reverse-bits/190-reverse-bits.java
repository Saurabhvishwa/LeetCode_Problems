public class Solution {
    // you need treat n as an unsigned value
    public String leadingZero(int n, String bin){
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<n;i++){
            sb.append("0");
        }
        sb.append(bin);
        return sb.toString();
    }
    public int reverseBits(int n) {
        String bin = Integer.toBinaryString(n);
        int ans = 0, two = 1;
        String binString = leadingZero(32-bin.length(), bin);
        for(int i=0;i<binString.length();i++){
            if(binString.charAt(i) == '1'){
                ans += two;
            }
            two *= 2;
        }
        return ans;
    }
}