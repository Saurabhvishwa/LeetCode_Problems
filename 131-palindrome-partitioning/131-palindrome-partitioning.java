class Solution {
    public boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public void findPalindrome(String s, List<List<String>> ans, List<String> temp, int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index, i)){
                temp.add(s.substring(index, i+1));
                findPalindrome(s, ans, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        List<String> temp = new ArrayList<>();
        findPalindrome(s, ans, temp, 0);
        return ans;
    }
}