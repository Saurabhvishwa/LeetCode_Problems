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
                if(q.peek().equals(endWord)) return level;
                char[] word = q.poll().toCharArray();
                for(int j=0;j<word.length;j++){
                    char orig = word[j];
                    for(char c='a';c<='z';c++){
                        word[j] = c;
                        String temp = String.valueOf(word);
                        if(words.remove(temp)) q.add(temp);
                    }
                    word[j] = orig;
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