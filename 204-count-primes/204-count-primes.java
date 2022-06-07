class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] primes = new boolean[n];
        for(int i=2;i*i<n;i++){
            int x = 2;
            while(i*x<n){
                primes[i*x] = true;
                x++;
            }
        }
        for(int i=2;i<n;i++){
            if(primes[i] == false) count++;
        }
        return count;
    }
}