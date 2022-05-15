class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length()-1;
        StringBuilder sbr = new StringBuilder("");
        int carry = 0;
        while(i>=0 || j>=0){
            int first = 0, second = 0;
            if(i>=0){
                first = a.charAt(i) - '0';
            }
            if(j>=0){
                second = b.charAt(j) - '0';
            }
            if(first == 1 && second == 1 && carry == 1){
                carry = 1;
                sbr.append(1);
            }else if(first == 1 && second == 1 && carry == 0){
                carry = 1;
                sbr.append(0);
            }
            else if((first == 1 || second == 1) && carry == 1){
                carry = 1;
                sbr.append(0);
            }else if((first == 1 || second == 1) && carry == 0){
                sbr.append(1);
            }else{
                sbr.append(carry);
                carry = 0;
            }
            i--;
            j--;
        }
        if(carry == 1) sbr.append(carry);
        return sbr.reverse().toString();
    }
}