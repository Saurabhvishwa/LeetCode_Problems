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
        return hasAll(s, k);
    }
}