class Solution {
    public String getUnitString(int n){
        String s = "";
        if(n>0 && n<4){
            for(int i=0;i<n;i++){
                s += "I";
            }
            return s;
        }else if(n == 4){
            return "IV";
        }else if(n>4 && n<9){
            s += "V";
            for(int i=5;i<n;i++){
                s += "I";
            }
            return s;
        }else if(n==9){
            return "IX";
        }
        return "";
    }
    public String getTensString(int n){
        String s = "";
        if(n>0 && n<4){
            for(int i=0;i<n;i++){
                s += "X";
            }
            return s;
        }else if(n == 4){
            return "XL";
        }else if(n>4 && n<9){
            s += "L";
            for(int i=5;i<n;i++){
                s += "X";
            }
            return s;
        }else if(n==9){
            return "XC";
        }
        return "";
    }
    public String getHundredString(int n){
        String s = "";
        if(n>0 && n<4){
            for(int i=0;i<n;i++){
                s += "C";
            }
            return s;
        }else if(n == 4){
            return "CD";
        }else if(n>4 && n<9){
            s += "D";
            for(int i=5;i<n;i++){
                s += "C";
            }
            return s;
        }else if(n==9){
            return "CM";
        }
        return "";
    }
    public String getThousandString(int n){
        String s = "";
        if(n>0 && n<4){
            for(int i=0;i<n;i++){
                s += "M";
            }
            return s;
        }
        return "";
    }
    
    public String intToRoman(int num) {
        if(num == 0){
            return "";
        }
        String result = "";
        int digit = 0;
        digit = num%10;
        num = num/10;
        result= getUnitString(digit) + result;
        if(num>0){
            digit = num%10;
        num = num/10;
        result = getTensString(digit) + result;
        }
        if(num>0){
            digit = num%10;
        num = num/10;
        result = getHundredString(digit) + result;
        }
        if(num>0){
            digit = num%10;
        num = num/10;
        result = getThousandString(digit) + result;
        }
        return result;
    }
}