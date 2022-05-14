class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] a:times){
            graph.computeIfAbsent(a[0], x -> new ArrayList<>()).add(new int[]{a[1], a[2]});
        }
        Map<Integer, Integer> d = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        minHeap.add(new int[]{k, 0});
        while(!minHeap.isEmpty()){
            int[] src = minHeap.poll();
            if(d.containsKey(src[0])) continue;
            d.put(src[0], src[1]);
            if(graph.containsKey(src[0])){
                for(int[] edge:graph.get(src[0])){
                    minHeap.add(new int[]{edge[0], edge[1]+src[1]});
                }
            }
        }
        if(d.size() != n) return -1;
        int ans = Integer.MIN_VALUE;
        for(int i:d.keySet()){
            ans = Math.max(ans, d.get(i));
        }
        return ans;
    }
}