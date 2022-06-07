class Solution {
    public int countPrimes(int n) {
        boolean[] nonPrimes = new boolean[n];
        int count = 0 ;
        for(int i = 2 ; i< n; i++){
            if(nonPrimes[i] == false){
                count++;
                for(int j = 2 ; i*j< n ; j++)
                    nonPrimes[i*j] = true ;
            }
        }
        return count ;
    }
}