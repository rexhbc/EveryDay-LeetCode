/**
 * Time: O(K+N(2K)) -> O(KN)
 * Space: O(N+K)
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] primeIndex = new int[primes.length];
        int[] primeNumber = new int[primes.length];
        
        ugly[0] = 1;
        
        for (int i = 0; i < primes.length; i++){
            primeNumber[i] = 1;
        }
        
        for (int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primeNumber.length; j++){
                primeNumber[j] = primes[j] * ugly[primeIndex[j]];
                min = Math.min(min,primeNumber[j]);
            }
            
            ugly[i] = min;
            
            for (int k = 0; k < primeIndex.length; k++){
                if (primeNumber[k] == min){
                    primeIndex[k]++;
                }
            }
        }
        
        return ugly[n-1];
    }
}
