class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int maxProduct = nums[0];
        int minProduct = nums[0];
        for(int i=1;i<nums.length;i++){
            int a = maxProduct*nums[i];
            int b = minProduct*nums[i];
            maxProduct = Math.max(Math.max(a,b), nums[i]);
            minProduct = Math.min(Math.min(a,b), nums[i]);
            maxSoFar = Math.max(maxSoFar, maxProduct);
        }
        return maxSoFar;
    }
}