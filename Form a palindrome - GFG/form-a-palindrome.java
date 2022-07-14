// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        // code here
         int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for(int[] k : dp) Arrays.fill(k, -1);
        return n-LPS(str, 0, str.length()-1, dp);
    }
    public static int LPS(String s, int start, int end, int[][] dp){
        if(start == end) return 1;
        else if(s.charAt(start) == s.charAt(end) && end == (start+1)) return 2;
        if(dp[start][end] != -1) return dp[start][end];
        if(s.charAt(start) == s.charAt(end)){
            return dp[start][end] = 2+LPS(s, start+1, end-1, dp);
        }
        return dp[start][end] = Math.max(LPS(s, start+1, end, dp), LPS(s, start, end-1, dp));
    }
}