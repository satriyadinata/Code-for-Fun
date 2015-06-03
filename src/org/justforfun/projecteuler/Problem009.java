package org.justforfun.projecteuler;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 *
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * @author Satriya
 */
public class Problem009 {
    private static final int SUM = 1000;
    
    public static void main(String[] args) {
        int sum;
        int product = 0;
        
        for (int a = 1; a <= SUM; a++) {
            for (int b = a+1; b <= SUM; b++) {
                for (int c = b+1; c <= SUM; c++) {
                    sum = a+b+c;
                    if (a*a + b*b == c*c) {
                        if (SUM%sum == 0) {
                            int factor = SUM/sum;
                            product = (a*factor)*(b*factor)*(c*factor); 
                            break;
                        }
                    }
                }
            }
        }
        
        System.out.println(product);
    }
}