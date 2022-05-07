class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i=1;i<n;i++){
            min[i] = Math.min(min[i-1], nums[i]);
        }
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i=n-1;i>=0;i--){
            int num = nums[i];
            Integer right = tree.lower(num);
            if(i>0 && right != null){
                int left = min[i-1];
                if(left < right) return true;
            }
            tree.add(num);
        }
        System.out.println(tree);
        return false;
    }
}