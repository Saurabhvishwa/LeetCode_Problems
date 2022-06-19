class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for(String product: products) insert(root, product);
        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            if((root = root.children[searchWord.charAt(i)-'a']) == null) break;
            result.add(root.getTopThree());
        }
        
        while (result.size() < searchWord.length()) 
			result.add(new ArrayList<>());
        return result;
    }
    private void insert(Node root, String word) {
        int index = 0;
        for(int i=0;i<word.length();i++){
            index = word.charAt(i) - 'a';
            if(root.children[index] == null){
                root.children[index] = new Node();
            }
            root = root.children[index];
            root.addToQueue(word);
        }
    }
    static class Node {
        public Node[] children;
        public PriorityQueue<String> q;

        public Node() {
            children = new Node[26];
            q = new PriorityQueue<>((a,b) -> b.compareTo(a));
        }

        public void addToQueue(String word) {
            q.add(word);
            if (q.size() > 3) q.poll();
        }

        public List<String> getTopThree() {
            List<String> result = new ArrayList<>();
            while (!q.isEmpty()) result.add(q.poll());
            Collections.reverse(result);
            return result;
        }
    }
}