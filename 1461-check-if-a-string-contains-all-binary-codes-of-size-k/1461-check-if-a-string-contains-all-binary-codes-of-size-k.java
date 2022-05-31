class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if(k>n) return false;
        int count = 1<<k;
        boolean[] visited = new boolean[count];
        int num = k>1 ? Integer.parseInt(s.substring(n-k+1),2) << 1 : 0;
        for(int i=n-k;i>=0;i--){
            num = ((s.charAt(i)-'0'<<k)+num)>>1;
            if(!visited[num]){
                visited[num] = true;
                --count;
            }
            if(count == 0 ) return true;
        }
        return count == 0 ? true : false;
    }
}