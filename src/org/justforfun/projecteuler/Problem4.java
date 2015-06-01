/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.justforfun.projecteuler;

/**
 *
 * @author Satriya
 */
public class Problem4 {
    private static final int SIZE = 3;
    private static final int MIN = Integer.valueOf("1" + new String(new char[SIZE-1]).replace("\0", "0"));
    private static final int MAX = Integer.valueOf(new String(new char[SIZE]).replace("\0", "9"));
    
    public static void main(String[] args) {
        int maxPalindrome = 0;
        
        for (int i = MIN; i <= MAX; i++) {
            for (int j = i; j <= MAX; j++) {
                int product = i*j;
                String strNum = Integer.toString(product);
                String rStrNum = new StringBuilder(strNum).reverse().toString();
                if (strNum.contentEquals(rStrNum)) {
                    if (product > maxPalindrome) {
                        maxPalindrome = product;
                    }
                }
            }
        }
        
        System.out.println(maxPalindrome);
    }
}
