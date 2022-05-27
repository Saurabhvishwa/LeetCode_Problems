class Solution {
    public int minMoves(int target, int maxDoubles) {
        if(maxDoubles == 0) return target-1;
        int count = 0;
        while(target>1){
            if(maxDoubles == 0) return count+target-1;
            else if((target&1) == 1){
                target--;
            }else{
                target/=2;
                maxDoubles--;
            }
            count++;
        }
        return count;
    }
}
