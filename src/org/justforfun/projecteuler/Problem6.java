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
public class Problem6 {
    private static final int N = 100;
    
    public static void main(String[] args) {
        int sumOfSquare = 0;
        int squareOfSum = 0;
        
        for (int i=1; i <= N; i++) {
            sumOfSquare += Math.pow(i, 2);
            squareOfSum += i;
        }
        
        squareOfSum = (int) Math.pow(squareOfSum, 2);
        
        System.out.println(squareOfSum - sumOfSquare);
    }
}
