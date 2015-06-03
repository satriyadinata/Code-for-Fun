package org.justforfun.projecteuler;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * @author Satriya
 */
public class Problem010 {
    private final static int N = 2000000;
    public static void main(String[] args) {
        long sum = 2;
        for (int i = 3; i < N; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
    
    private static boolean isPrime(int n) {
        if (n%2 == 0) 
            return false;

        for(int i=3; i*i<=n; i+=2) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}