class Solution {
    public int minPartitions(String n) {
        char max = '0';
        for(int i=0;i<n.length();i++){
            if(max < n.charAt(i)) max = n.charAt(i);
        }
        System.out.println(max);
        return max-'0';
    }
}