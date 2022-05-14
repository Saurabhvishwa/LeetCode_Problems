class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--){
            int temp = (carry + digits[i])/10;
            digits[i] = (carry + digits[i])%10;
            carry = temp;
        }
        System.out.println(carry);
        if(carry > 0){
            int[] ans = new int[digits.length+1];
            ans[0] = carry;
            for(int i=1;i<=digits.length;i++){
                ans[i] = digits[i-1];
            }
            return ans;
        }
        return digits;
    }
}