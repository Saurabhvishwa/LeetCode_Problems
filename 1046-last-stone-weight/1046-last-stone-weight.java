class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            q.add(i);
        }
        
        while(q.size()!=1){
            int a = q.poll();
            int b = q.poll();
            int diff = Math.abs(a-b);
            if(diff == 0){
                q.add(0);
            }else{
                q.add(diff);
            }
        }
      
        return q.poll();
    }
}