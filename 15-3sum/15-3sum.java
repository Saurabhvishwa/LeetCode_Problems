class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> pair = new ArrayList<>();
        List<Integer> triplets = new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i == 0 || nums[i]>nums[i-1]){
                int start = i+1;
                int end = n-1;
                int rem = -nums[i];
                while(start<end){
                    if(start>i+1 && nums[start] == nums[start-1]){
                        start++;
                        continue;
                    }
                    if(end<n-1 && nums[end] == nums[end+1]){
                        end--;
                        continue;
                    }
                    if(rem == nums[start] + nums[end]){
                        triplets.add(nums[i]);
                        triplets.add(nums[start]);
                        triplets.add(nums[end]);
                        pair.add(triplets);
                        triplets = new ArrayList<>();
                        start++;
                        end--;
                    }else if(rem > nums[start] + nums[end]){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
            
        }
        return pair;
    }
}