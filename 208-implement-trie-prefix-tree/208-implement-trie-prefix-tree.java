class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        insertWord(root, word, 0);
    }
    public void insertWord(Node root, String word, int index){
        if(index == word.length()){
            root.isLeaf = true;
            return;
        }
        int id = word.charAt(index)-'a';
        if(root.nodes[id] == null){
            root.nodes[id] = new Node();
            insertWord(root.nodes[id], word, index+1);
        }else insertWord(root.nodes[id], word, index+1);
    }
    
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        return searchWord(root, word, 0);
    }
    public boolean searchWord(Node root, String word, int index){
        if(index == word.length()){
            if(root.isLeaf) return true;
            else return false;
        }
        int id = word.charAt(index) - 'a';
        if(root.nodes[id] == null) return false;
        return searchWord(root.nodes[id], word, index+1);
    }
    
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) return false;
        return searchPrefix(root, prefix, 0);
    }
    public boolean searchPrefix(Node root, String prefix, int index){
        if(index == prefix.length()) return true;
        int id = prefix.charAt(index) - 'a';
        if(root.nodes[id] == null) return false;
        return searchPrefix(root.nodes[id], prefix, index+1);
    }
    static class Node{
        Node[] nodes;
        boolean isLeaf;
        public Node(){
            nodes = new Node[26];
            isLeaf = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */