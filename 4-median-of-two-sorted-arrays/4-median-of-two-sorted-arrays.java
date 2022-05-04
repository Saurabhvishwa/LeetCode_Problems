class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int start = 0;
        int end = nums1.length;
        int mid = (m + n + 1)/2;
        while(start<=end){
            int md = (start+end)/2;
            int leftASize = md;
            int leftBSize = mid-md;
            int leftA = (leftASize > 0) ? nums1[leftASize-1] : Integer.MIN_VALUE;
            int leftB = (leftBSize > 0) ? nums2[leftBSize -1]: Integer.MIN_VALUE;
            int rightA = (leftASize<m) ? nums1[leftASize] : Integer.MAX_VALUE;
            int rightB = (leftBSize<n) ? nums2[leftBSize] : Integer.MAX_VALUE;
            
            if(leftA <= rightB && leftB <= rightA){
                if((m+n)%2==1){
                    return Math.max(leftA, leftB);
                }else{
                    return (Math.max(leftA, leftB)+Math.min(rightA, rightB))/2.0;
                }
            }else if(leftA>rightB){
                end = md-1;
            }else{
                start = md+1;
            }
        }
        return 0.0;
    }
}