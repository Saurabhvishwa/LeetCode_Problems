class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = -1;
        int right = -1;
        int length = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i]) == null){
                map.put(arr[i],i);
            }else{
                if(map.get(arr[i]) >= left){
                left = map.get(arr[i]);
                }
                map.put(arr[i],i);
            }
            right++;
            if((right-left)>length){
                length = right-left;
            }
        }
        return length;
    }
}