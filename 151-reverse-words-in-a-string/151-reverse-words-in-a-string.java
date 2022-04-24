class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        StringBuilder sbr = new StringBuilder("");
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i].equals(" ") || arr[i].equals("")) continue;
            if(i == 0){
                sbr.append(arr[i]);
            }else{
                sbr.append(arr[i]+" ");
            }
        }
        return sbr.toString();
    }
}