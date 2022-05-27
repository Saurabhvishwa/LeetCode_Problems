class Solution {
    public int numSteps(String s) {
        if(s.length() == 1) return 0;
        char[] arr = s.toCharArray();
        int count = 0;
        int c = 0;
        for(int i=arr.length-1;i>=1;){
            if(arr[i] == '0'){
                count++;
                i--;
            }else{
                count++;
                while(arr[i] == '1' && i>0){
                    count++;
                    i--;
                }
                if(i == 0){
                    count++;
                }
                arr[i] = '1';
            }
        }
        return count;
    }
}