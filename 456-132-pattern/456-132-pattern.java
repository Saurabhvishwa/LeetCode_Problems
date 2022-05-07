class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        st.push(nums[0]);
        for(int i=1;i<n-1;i++){
            st.push(Math.min(st.peek(), nums[i]));
        }
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i=n-1;i>=0;i--){
            int num = nums[i];
            Integer right = tree.lower(num);
            if(st.isEmpty()) return false;
            int left = st.pop();
            if(i>0 && right != null){
                if(left < right) return true;
            }
            tree.add(num);
        }
        return false;
    }
}