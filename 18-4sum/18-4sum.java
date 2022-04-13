class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int start = j+1;
                int end = n-1;
                int rem = target - nums[i] - nums[j];
                while(start < end){
                    int sum = nums[start]+nums[end];
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
                        start++;
                        end--;
                        while(start<end && nums[start] == nums[start-1]) ++start;
                        while(start<end && nums[end] == nums[end+1]) --end;
                    }
                   
                    
                }
                while(j+1<n && nums[j] == nums[j+1])j++;
            }
            while(i+1<n && nums[i] == nums[i+1]) i++;
        }
        return list;
    }
}