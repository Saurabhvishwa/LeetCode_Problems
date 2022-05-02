class Solution {
    public int trap(int[] height) {
        int result = 0;
        int prevIndex = 0;
        int size = height.length-1;
        int prev = height[0];
        int temp = 0;
        for(int i=1;i<=size;i++){
            if(height[i] < prev){
                result += prev - height[i];
                temp += prev - height[i];
            }else{
                prev = height[i];
                prevIndex = i;
                temp = 0;
            }
        }
        if(prevIndex < size){
            result -= temp;
            prev = height[size];
            for(int i=size; i>=prevIndex;i--){
                if(height[i]>=prev){
                    prev = height[i];
                }else{
                    result += prev-height[i];
                }
            }
        }
        return result;
    }
}