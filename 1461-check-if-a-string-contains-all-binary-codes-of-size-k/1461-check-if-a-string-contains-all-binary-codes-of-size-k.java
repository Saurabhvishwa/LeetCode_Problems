class Solution {
    public double power(int x, int y){
        if(y == 1) return x;
        double half = power(x, y/2);
        if(y%2==1){
            return x*half*half;
        }
        return half*half;
    }
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length()+1-k;i++){
            set.add(s.substring(i, i+k));
        }
        return set.size() == power(2, k);
    }
}