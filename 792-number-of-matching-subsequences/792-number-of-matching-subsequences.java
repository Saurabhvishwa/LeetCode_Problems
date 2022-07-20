class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String st:words){
            map.put(st, map.getOrDefault(st, 0)+1);
        }
        int ans = 0;
        for(String str:map.keySet()){
            int i = 0;
            int j = 0;
            while(i<s.length() && j<str.length()){
                if(s.charAt(i)==str.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            
            if(j==str.length()){
                ans+=map.get(str);
            }
            
        }
        
      return ans;
    }
    public void solve(String s, Set<String> set, String temp, int index){
        if(index>=s.length()){
            set.add(temp);
            return;
        }
        solve(s, set, temp+s.charAt(index), index+1);
        solve(s, set, temp, index+1);
    }
}