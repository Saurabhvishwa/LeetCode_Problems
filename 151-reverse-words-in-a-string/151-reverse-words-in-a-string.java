class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        System.out.println(Arrays.toString(arr));
        StringBuilder sbr = new StringBuilder("");
        for(int i = arr.length-1;i>=0;i--){
            System.out.println(arr[i].length());
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