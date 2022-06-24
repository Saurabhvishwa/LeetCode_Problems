class Solution {
    public boolean isPossible(int[] target) {
        int sum = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        for(int i:target){
            sum += i;
            q.add(i);
        }
        int max = 0, prev = 0;
        while(q.peek()!=1){
            max = q.poll();
            if(sum-max==1) return true;
            if(sum-max==0) return false;
            prev = max % (sum-max);
            sum = sum-max+prev;
            if(prev == 0 || prev == max) return false;
            else q.add(prev);
        }
        return true;
    }
}