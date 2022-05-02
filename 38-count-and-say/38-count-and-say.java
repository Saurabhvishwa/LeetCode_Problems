class Solution {
    public StringBuilder countSay(String n){
        StringBuilder result = new StringBuilder("");
        int i = 0;
        char temp = n.charAt(0);
        int count = 1;
        i++;
        while(i<n.length()){
            if(n.charAt(i) == temp){
                count++;
            }else{
                result.append(String.valueOf(count)+String.valueOf(temp));
                temp = n.charAt(i);
                count = 1;
            }
            i++;
        }
         result.append(String.valueOf(count)+String.valueOf(temp));
        return result;
    }
    public String countAndSay(int n) {
        if(n==1) return "1";
        StringBuilder s = new StringBuilder("1");
        for(int i=1;i<n;i++){
            s = countSay(s.toString());
        }
        return s.toString();
    }
}