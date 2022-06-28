class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            int value = s.charAt(i) - 'a';
            arr[value]++;
        }
        Arrays.sort(arr);
        int count = 0;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i] == 0) break;
            while(arr[i] !=0 && arr[i]>=arr[i+1]){
                arr[i]--;
                count++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return count;
    }
}