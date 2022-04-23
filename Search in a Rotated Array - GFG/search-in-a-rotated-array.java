// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();
            
            System.out.println(new Solution().search(A, 0, n - 1, key));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
     public static int modifiedBinarySearch(int[] arr, int start, int end, int key){
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[start]<=arr[mid]){
                if(key>=arr[start] && key<arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(key>arr[mid] && key<arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        
        }
        return -1;
    }
    
    int search(int A[], int l, int h, int key)
    {
        // Complete this function
        return modifiedBinarySearch(A, l, h, key);
    }
}