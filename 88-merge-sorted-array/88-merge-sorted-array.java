class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i=0;i<n;i++) nums1[i] = nums2[i];
        }else if(n == 0) return;
        else {
            m = m+n;
            m = m-n;
            for(int i=0;i<n;i++){
                nums1[i+m] = nums2[i];
                sort(nums1, i+m);
            }
        }
    }
    public void sort(int[] nums1, int index){
        int temp = nums1[index];
        index--;
        while(index>=0){
            if(nums1[index] > temp){
                nums1[index+1] = nums1[index];
                nums1[index] = temp;
            }else return;
            index--;
        }
    }
}