class Solution {
    public double pow(double x, int n){
        if(n==0) return 1;
        if(n==1) return x;
        double ans = pow(x, n/2);
        if(n%2==0){
            return ans*ans;
        }
        return ans*ans*x;
    }
    public double power(double x, int n) {
        if(n == Integer.MAX_VALUE) return x;
        else if(n == Integer.MIN_VALUE) return (x==1||x==-1) ? 1:0;
        if(n<0){
            x = 1/x;
            n *= -1;
        }
        return pow(x, n);
    }
    public double myPow(double x, int n) {
        return power(x, n);
    }
}