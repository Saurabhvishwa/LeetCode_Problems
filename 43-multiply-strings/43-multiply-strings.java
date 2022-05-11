class Solution {
    public String mul(String num1, String num2){
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m+n];
        int i1 = 0;
        int i2 = 0;
        for(int i=m-1;i>=0;i--){
            int first = num1.charAt(i) - '0';
            i2 = 0;
            int carry = 0;
            for(int j=n-1;j>=0;j--){
                int second = num2.charAt(j) - '0';
                int sum = first*second + result[i1+i2]+carry;
                
                carry = sum/10;
                result[i1+i2] = sum%10;
                i2++;
            }
            if(carry>0){
                result[i1+i2] += carry;
            }
            i1++;
        }
        int i=m+n-1;
        while(i>=0 && result[i] == 0){
            i--;
        }
        StringBuilder sbr = new StringBuilder("");
        while(i>=0){
            sbr.append(result[i--]);
        }
        return sbr.toString();
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        return mul(num1, num2);
    }
}