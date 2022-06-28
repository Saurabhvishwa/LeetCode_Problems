class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            int value = s.charAt(i) - 'a';
            arr[value]++;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] == 0) break;
            if(map.containsKey(arr[i])){
                while(map.containsKey(arr[i])){
                    arr[i]--;
                    count++;
                }
                if(arr[i] != 0) map.put(arr[i],1);
            }else map.put(arr[i],1);
        }
        System.out.println(map);
        return count;
    }
}