class RotatedSortedArrayPivotIndex{
  
//   if (end == n-1 || end == 0) => whole array is sorted without any rotation
//  if(end > 0 && end < n-1 ) => array is sorted but rotated
  

  public static int findPivotIndex(int[] arr, int n){
        int start = 0;
        int end = n-1;
        while(start<end){
            int mid = (start+end)/2;
            if(arr[start]<=arr[mid]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return end;
    }
  
}
