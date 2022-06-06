class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        boolean zero = true;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0) zero = false;
            arr[i] = String.valueOf(nums[i]);
        }
        if(zero) return "0";
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        StringBuilder ans = new StringBuilder("");
        for(String s:arr){
            ans.append(s);
        }
        return ans.toString();
}
    
}