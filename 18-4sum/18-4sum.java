class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int start = j+1;
                int end = n-1;
                long rem = (long)target - (nums[i] + nums[j]);
                while(start < end){
                    long sum = nums[start]+nums[end];
                    if(sum<rem){
                        start++;
                    }else if(sum>rem){
                        end--;
                    }else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        list.add(temp);
                        while(start<end && nums[start] == nums[start+1]) start++;
                        while(start<end && nums[end] == nums[end-1]) end--;
                        start++; end--;
                    }
                }
            }
        }
        return list;
    }
}