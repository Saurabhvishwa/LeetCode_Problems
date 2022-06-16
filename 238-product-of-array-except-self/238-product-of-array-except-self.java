class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];
        Arrays.fill(prod, 1);
        int temp = 1;
        for(int i=0;i<nums.length;i++){
            prod[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for(int i=nums.length-1;i>=0;i--){
            prod[i] *= temp;
            temp *= nums[i];
        }
        return prod;
    }
}