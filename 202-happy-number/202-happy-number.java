class Solution {
    public int getNum(int x){
        int value = 0;
        while(x>0){
            value += Math.pow(x%10,2);
            x = x/10;
        }
        return value;
    }
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while(n != 1){
            n = getNum(n);
            if(map.containsKey(n)) return false;
            else map.put(n,1);
        }
        return true;
    }
}