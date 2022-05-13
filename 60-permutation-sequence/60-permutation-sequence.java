class Solution {
    public char[] getPerm(char[] arr, int n){
        int first = -1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                first = i;
                break;
            }
        }
        int second = -1;
        for(int i=n-1;i>first;i--){
            if(arr[i]>arr[first]){
                second = i;
                break;
            }
        }
        char c = arr[first];
        arr[first] = arr[second];
        arr[second] = c;
        Arrays.sort(arr, first+1, n);
        return arr;
    }
    public String getPermutation(int n, int k) {
        char[] ans = new char[n];
        char c = '1';
        for(char i=1;i<=n;i++){
            ans[i-1] = c++;
        }
        for(int i=2;i<=k;i++){
            ans = getPerm(ans, ans.length);
        }
        return String.valueOf(ans);
    }
}