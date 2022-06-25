class Solution {
    public int numSquares(int n) {
        int count = 0;
        Set<Integer> v = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            Queue<Integer> temp = new LinkedList<>();
            while(!q.isEmpty()){
                int cur = q.poll();
                if(cur == n) return count;
                for(int i=1;cur+i*i<=n;i++){
                    int next = cur + i*i;
                    if(!v.contains(next)) temp.add(next);
                    v.add(next);
                }
            }
            q = temp;
            count++;
        }
        return -1;
    }
}