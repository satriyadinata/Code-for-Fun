package org.justforfun.projecteuler;

public class Problem3 {
    private static final long INPUT = 600851475143L;
    
    public static void main(String[] args) {
        long cNum = INPUT;
        int cPF = 2;
        
        while (!isPrime(cNum)) {    
            if (cNum%cPF == 0) {
                cNum = cNum/cPF;
            } else {
                /* Will return the next PF after cPF */
                while (cNum%cPF != 0) {
                    cPF++;
                }
            }
        }
        
        System.out.println(cNum);
    }
    
    public static boolean isPrime(long n) {
        if (n%2 == 0) 
            return false;

        for(int i=3; i*i<=n; i+=2) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}