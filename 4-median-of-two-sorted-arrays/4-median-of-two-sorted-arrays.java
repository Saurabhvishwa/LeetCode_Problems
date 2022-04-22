class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n == 0 && m == 0){
            return 0.0;
        }else if(n == 0){
            if(m%2==0){
                return (nums2[m/2]+nums2[(m/2)-1])/2.0;
            }else{
                return nums2[m/2];
            }
        }else if(m == 0){
            if(n%2==0){
                return (nums1[n/2]+nums1[(n/2)-1])/2.0;
            }else{
                return nums1[n/2];
            }
        }
        int[] res = new int[n+m];
        int i=0, j=0;
        int k = 0;
        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                res[k] = nums1[i];
                i++;
                k++;
            }else{
                res[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(i<n){
            res[k] = nums1[i];
            i++;
            k++;
        }
        while(j<m){
            res[k] = nums2[j];
            j++;
            k++;
        }
        if((m+n)%2==0){
            return (res[(m+n)/2]+res[((m+n)/2)-1])/2.0;
        }
        return res[(m+n)/2];
    }
}