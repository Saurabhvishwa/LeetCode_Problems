class Solution {
    public int search(int[] arr, int key) {
        int start = 0, end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == key) return mid;
            else if(arr[start]<=arr[mid]){
                if(key>=arr[start] && key < arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(key>arr[mid] && key<=arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}