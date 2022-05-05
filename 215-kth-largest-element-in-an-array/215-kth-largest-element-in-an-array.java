class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(q.size()<k){
                q.add(nums[i]);
            }else{
                if(q.peek() < nums[i]){
                    q.poll();
                    q.add(nums[i]);
                }
            }
        }
        return q.peek();
    }
}