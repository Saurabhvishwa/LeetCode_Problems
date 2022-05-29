class Solution {
    public int getBinary(String word){
        int state = 0;
        int n = word.length();
        for(int i=0;i<n;i++){
            int index = word.charAt(i) - 'a';
            state |= 1<<index;
        }
        return state;
    }
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] state = new int[n];
        for(int i=0;i<n;i++){
            state[i] = getBinary(words[i]);
        }
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((state[i]&state[j]) == 0){
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}