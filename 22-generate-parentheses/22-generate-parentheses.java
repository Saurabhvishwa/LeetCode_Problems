class Solution {
    public void getP(List<String> list, String s, int open, int close, int max){
        if(s.length() == max*2){
            list.add(s);
            return;
        }
        if(open<max){
            getP(list, s+"(", open+1, close, max);
        }
        if(close<open){
            getP(list, s+")", open, close+1, max);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getP(result, "", 0,0,n);
        return result;
    }
}