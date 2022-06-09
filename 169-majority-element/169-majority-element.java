class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int el:nums){
            map.put(el, map.getOrDefault(el, 0)+1);
        }
        int el = 0, freq = 0;
        for(int i:map.keySet()){
            if(map.get(i) > freq){
                freq = map.get(i);
                el = i;
            }
        }
        return el;
    }
}