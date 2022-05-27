class Solution {
    public int minMoves(int target, int maxDoubles) {
        if(maxDoubles == 0) return target-1;
        int count = 0;
        while(target>1 && maxDoubles > 0){
            if((target&1) == 1){
                --target;
            }else{
                target/=2;
                --maxDoubles;
            }
            ++count;
        }
        return count+target-1;
    }
}
