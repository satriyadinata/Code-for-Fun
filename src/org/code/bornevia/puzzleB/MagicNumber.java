package org.code.bornevia.puzzleB;

public class MagicNumber {
    private final int size;
    private final int number;
    private String sNumber;
    
    public MagicNumber(int number, int size) {
        this.number = number;
        this.size = size;
        this.sNumber = "";
    }
    
    private boolean isPerfectSquare(long n) {
        if (n < 0) {
            return false;
        }
        
        switch((int)(n & 0x3F)) {
            case 0x00: case 0x01: case 0x04: case 0x09: case 0x10: case 0x11:
            case 0x19: case 0x21: case 0x24: case 0x29: case 0x31: case 0x39:
                long sqrt;
                if(n < 410881L) {
                    //John Carmack hack, converted to Java.
                    // See: http://www.codemaestro.com/reviews/9
                    int i;
                    float x2, y;

                    x2 = n * 0.5F;
                    y  = n;
                    i  = Float.floatToRawIntBits(y);
                    i  = 0x5f3759df - ( i >> 1 );
                    y  = Float.intBitsToFloat(i);
                    y  = y * ( 1.5F - ( x2 * y * y ) );

                    sqrt = (long)(1.0F/y);
                } else {
                    //Carmack hack gives incorrect answer for n >= 410881.
                    sqrt = (long)Math.sqrt(n);
                }
                return sqrt*sqrt == n;

            default:
                return false;
        }
    }
    
    public boolean isMagicNumber() {
        if (this.isPerfectSquare(number)) {
            sNumber = Integer.toString(number);
            int delta = size - sNumber.length();
            
            if (delta > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(new String(new char[delta]).replace("\0", "0"));
                sb.append(sNumber);
                sNumber = sb.toString();
            }
            
            double num1 = Integer.valueOf(sNumber.substring(0, size/2));
            double num2 = Integer.valueOf(sNumber.substring((size/2), size));
            
            return Math.pow((num1+num2), 2)== number;
        } else {
            return false;
        }
    }
    
    public String getNumber(){
        return this.sNumber;
    }
}