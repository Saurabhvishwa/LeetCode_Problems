class Solution {
    public int count(int n){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(1);
        }
        for(int i=2;i<=n;i++){
            for(int j=3;j>=0;j--){
                list.set(j, list.get(j)+list.get(j+1));
            }
        }
        int count = 0;
        for(int i:list){
            count+=i;
        }
        return count;
    }
    public int countVowelStrings(int n) {
        // return (n+1)*(n+2)*(n+3)*(n+4)/24;
        return count(n);
         }
}