class Solution {
    public boolean hasAll(String s, int k){
        int n = s.length(), count = 1<<k;
        Set<String> set = new HashSet<>();
        if(k>n) return false;
        String temp = "";
        for(int i=0;i<n+1-k;i++){
            temp = s.substring(i,i+k);
            if(!set.contains(temp)){
                set.add(temp);
                --count;
            }
            if(count == 0) return true;
        }
        return count == 0 ? true : false;
    }
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if(k>n) return false;
        int count = 1<<k;
        boolean[] visited = new boolean[count];
        int num = k>1 ? Integer.parseInt(s.substring(n-k+1),2) << 1 : 0;
        for(int i=n-k;i>=0;i--){
            num = ((s.charAt(i)-'0'<<k)+num)>>1;
            System.out.println(num);
            if(!visited[num]){
                visited[num] = true;
                --count;
            }
            if(count == 0 ) return true;
        }
        return count == 0 ? true : false;
        // return hasAll(s, k);
    }
}