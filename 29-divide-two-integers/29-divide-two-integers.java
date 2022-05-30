class Solution {
    public int divide(int dividend, int divisor) {
       if (dividend == -2147483648 && divisor == -1) return 2147483647;
        int ans = 0, sign = dividend > 0 == divisor > 0 ? 1 : -1;
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;
        if (dividend == divisor) return sign;
        for (int i = 0, val = divisor; dividend - divisor >= 0; i = 0, val = divisor) {
            while (val > 0 && dividend - val >= 0) val = divisor << ++i;
            dividend -= divisor << i - 1;
            ans += 1 << i - 1;
        }
        return sign < 0 ? -ans : ans;
    }
}