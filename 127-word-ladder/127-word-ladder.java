class Solution {
    public int get(String start, String endWord, List<String> wordList){
        if(start.equals(endWord)) return 0;
        if(!wordList.contains(endWord)) return 0;
        Set<String> words = new HashSet<>();
        for(String s:wordList){
            words.add(s);
        }
        int level = 1, wordLength = start.length();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String word = q.poll();
                if(word.equals(endWord)) return level;
                for(int j=0;j<word.length();j++){
                    for(char c='a';c<='z';c++){
                        String temp = word.substring(0,j)+c+word.substring(j+1);
                        if(words.remove(temp)) q.add(temp);
                    }
                }
            }
            ++level;
        }
        return 0;
    }
    public int ladderLength(String start, String endWord, List<String> wordList) {
        return get(start, endWord, wordList);
    }
}