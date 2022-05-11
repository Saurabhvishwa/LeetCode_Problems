class Solution {
    public boolean isPermutable(int[] nums, int start, int curr){
            // for(int i=start;i<curr;i++){
            //     if(nums[i] == nums[curr]){
            //         return false;
            //     }
            // }
        
        int end = curr-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == nums[curr]){
            
                System.out.println(Arrays.toString(nums)+" "+start+" "+curr);
                return false;
            }
            else if(nums[mid] > nums[curr]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return true;
    }
    public void perm(int[] nums, List<List<Integer>> ans, List<Integer> temp){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(isPermutable(nums, 0, i) && nums[i] != Integer.MIN_VALUE){
                temp.add(nums[i]);
                int value = nums[i];
                nums[i] = Integer.MIN_VALUE;
                perm(nums, ans, temp);
                nums[i] = value;
                temp.remove(temp.size()-1);
            }
            
        }
        return;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        perm(nums , ans, new ArrayList<Integer>());
        return ans;
    }
}