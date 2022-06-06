class Solution {
    public String fractionToDecimal(int n, int d) {
        if(n == 0) return "0";
        long num = n, den = d;
        int sign = 1;
        if(num<0){
            sign *= -1;
            num = -num;
        }
        if(den < 0){
            sign *= -1;
            den = -den;
        }
        
        StringBuilder ans = new StringBuilder("");
        long q = num/den, rem = num%den;
        ans.append(q);
        if(sign == -1){
            ans.insert(0, "-");
        }
        if(rem == 0) return ans.toString();
        else{
            Map<Long, Integer> map = new HashMap<>();
            ans.append(".");
            map.put(rem, ans.length());
            while(rem != 0){
                rem *= 10;
                q = rem/den;
                rem = rem%den;
                ans.append(q);
                if(map.containsKey(rem)) break;
                map.put(rem, ans.length());
            }
            if(rem != 0){
                ans.insert(map.get(rem), "(");
                ans.insert(ans.length(),")");
            }
        }
        return ans.toString();
    }
}