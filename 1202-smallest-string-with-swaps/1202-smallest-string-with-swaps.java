class Solution {
    public int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    public void union(int[] parent, int x, int y){
        int xRoot = find(parent,x);
        int yRoot = find(parent, y);
        if(xRoot != yRoot){
            parent[yRoot] = xRoot;
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] parent = new int[s.length()];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        for(List<Integer> list : pairs){
            union(parent, list.get(0), list.get(1));
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<parent.length;i++){
            int ind = find(parent, i);
                List<Integer> list = map.getOrDefault(ind, new ArrayList<Integer>());
                list.add(i);
                map.put(ind, list);
        }
        // char[] arr = s.toCharArray();
        StringBuilder sbr = new StringBuilder(s);
        for(int key:map.keySet()){
            List<Integer> list = map.get(key);
            List<Character> temp = new ArrayList<>();
            for(int i:list){
                temp.add(sbr.charAt(i));
            }
            
            Collections.sort(temp);
            int index = 0;
           for(int i=0;i<temp.size();i++){
               sbr.replace(list.get(i), list.get(i)+1, String.valueOf(temp.get(i)));
               // arr[list.get(i)] = temp.get(i);
           }
        }
        return sbr.toString();
    }
}