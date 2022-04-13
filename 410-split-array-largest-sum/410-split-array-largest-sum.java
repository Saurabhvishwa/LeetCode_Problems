class Solution {
    public boolean check(int[] arr, int mid, int n, int k){
        int count = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            if(arr[i]>mid){
                return false;
            }
            if(sum+arr[i] > mid){
                count++;
                sum = arr[i];
            }else sum+= arr[i];
        }
        count++;
        return count<=k;
    }
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int start = 0;
        int end = 0 ;
        for(int i=0;i<n;i++){
            if(nums[i]>start){
                start = nums[i];
            }
            end += nums[i];
        }
        int ans = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(check(nums, mid, n, m)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}