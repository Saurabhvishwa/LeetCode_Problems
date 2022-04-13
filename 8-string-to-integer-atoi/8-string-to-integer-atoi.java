class Solution {
    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        char[] arr = s.trim().toCharArray();
        int n = arr.length;
        int index = 0;
        if(index<n && arr[index] == '+'){
            index++;
        }else if(index<n && arr[index] == '-'){
            sign = -1;
            index++;
        }
        while(index<n && Character.isDigit(arr[index])){
            int digit = arr[index] - '0';
            if((result>Integer.MAX_VALUE/10) || (result==Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result*10 + digit;
            index++;
        }
        return result*sign;
        
    }
}