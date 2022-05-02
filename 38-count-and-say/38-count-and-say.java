class Solution {
    public String countSay(String n){
        String result = "";
        int i = 0;
        char temp = n.charAt(0);
        int count = 1;
        i++;
        while(i<n.length()){
            if(n.charAt(i) == temp){
                count++;
            }else{
                result += String.valueOf(count)+String.valueOf(temp);
                temp = n.charAt(i);
                count = 1;
            }
            i++;
        }
         result += String.valueOf(count)+String.valueOf(temp);
        return result;
    }
    public String countAndSay(int n) {
        if(n==1) return "1";
        String s = "1";
        for(int i=1;i<n;i++){
            s = countSay(s);
        }
        return s;
    }
}