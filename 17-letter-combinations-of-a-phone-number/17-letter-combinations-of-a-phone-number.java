class Solution {
    public void findCombinations(String[] arr, List<String> list, String temp, String orig,  int n, int index){
        if(temp.length() == n){
            list.add(temp);
            return;
        }
        int val = Integer.parseInt(String.valueOf(orig.charAt(index)));
        String current = arr[val-2];
        for(int i=0;i<current.length();i++){
            findCombinations(arr, list, temp+current.charAt(i), orig, n, index+1);
        }
    }
    public List<String> findComb(String[] arr, int n, String orig){
        List<String> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("");
        while(!q.isEmpty()){
            String s = q.remove();
            if(s.length() == n){
                list.add(s);
            }else{
                String val = arr[Integer.parseInt(String.valueOf(orig.charAt(s.length())))-2];
                for(int i=0;i<val.length();i++){
                    q.add(s+val.charAt(i));
                }
            }
        }
        return list;
    }
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals("")){
            return new ArrayList<>();
        }
        String[] arr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return findComb(arr, digits.length(), digits);
    }
}