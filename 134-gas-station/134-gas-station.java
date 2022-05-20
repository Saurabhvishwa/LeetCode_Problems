class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int p = 0, d = 0, n = gas.length, start = 0;
        for(int i=0;i<n;i++){
            p += gas[i] - cost[i];
            if(p<0){
                d += p;
                p = 0;
                start = i+1;
            }
        }
        return (p+d)>=0 ? start:-1;
    }
}