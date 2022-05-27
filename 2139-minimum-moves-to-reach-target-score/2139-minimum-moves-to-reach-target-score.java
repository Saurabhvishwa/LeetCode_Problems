class Solution {
    public int minMoves(int target, int maxDoubles) {
        if(maxDoubles == 0) return target-1;
        int count = 0;
        while(target>1){
            System.out.println(target+" "+maxDoubles+" "+count);
            if(maxDoubles == 0) return count+target-1;
            else if((target&1) == 1){
                target--;
                count++;
            }else{
                target/=2;
                maxDoubles--;
                count++;
            }
        }
        return count;
    }
}
