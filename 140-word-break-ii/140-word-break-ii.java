class Solution {
    List<String> ans;
    public void findWords(String s, String breakString, int index, Set<String> words){
        if(index == s.length()){
            ans.add(breakString.trim());
        }
        String temp = "";
        for(int i=index;i<s.length();i++){
            temp = s.substring(index,i+1);
            if(words.contains(temp)){
                findWords(s, breakString+temp+" ", i+1, words);
                words.add(temp);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new LinkedList<>();
        Set<String> words = new HashSet<>();
        for(String st:wordDict){
            words.add(st);
        }
        findWords(s, "", 0, words);
        return ans;
    }
}