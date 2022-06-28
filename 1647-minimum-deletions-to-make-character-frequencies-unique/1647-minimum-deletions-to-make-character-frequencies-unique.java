class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            int value = s.charAt(i) - 'a';
            arr[value]++;
        }
        Arrays.sort(arr);
        int count = 0, diff = 0;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i] == 0) break;
            else if(arr[i]<arr[i+1]) continue;
            diff = arr[i+1]-arr[i];
            if(diff == 0){
                arr[i]--;
                count++;
            }else if(diff < 0){
                int temp = arr[i]+diff-1;
                if(temp<0){
                    count += arr[i];
                    arr[i] = 0;
                }
                else{
                    arr[i] = temp;
                    count += Math.abs(diff)+1;
                }
            }
        }
        return count;
    }
}