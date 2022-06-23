class Solution {
    public int binSearch(int[] nums, int start, int end, int key){
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>key){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }
    public void getPerm(int[] nums){
        int index;
        int i=0,j=0;
        for(i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]) break;
        }
        if(i<0){
            int x = 0, y = nums.length-1;
            while(x<y){
                int temp = nums[x];
                nums[x] = nums[y];
                nums[y] = temp;
                x++;y--;
            }
            return;
        }
        for(j=nums.length-1;j>i;j--){
            if(nums[j]>nums[i]) break;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        Arrays.sort(nums, i+1, nums.length);
    }
    public void nextPermutation(int[] nums) {
        getPerm(nums);
        // int i = nums.length-2;
        // while(i>=0 && nums[i+1] <= nums[i]){
        //     i--;
        // }
        // if(i >=0){
        //     int index = binSearch(nums,i+1, nums.length-1,nums[i]);
        //     int temp = nums[index];
        //     nums[index] = nums[i];
        //     nums[i] = temp;
        // }
        // int j = nums.length-1;
        // i++;
        // while(i<j){
        //     int temp = nums[i];
        //     nums[i] = nums[j];
        //     nums[j] = temp;
        //     i++;
        //     j--;
        // }
    }
}