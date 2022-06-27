class Solution {
    public int minPartitions(String n) {
        char max = '0';
        int i=0;
        while(i<n.length()){
            if(max < n.charAt(i)) max = n.charAt(i);
            i++;
        }
        return max-'0';
    }
}