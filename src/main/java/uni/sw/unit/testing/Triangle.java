package uni.sw.unit.testing;

import java.lang.Math;

public class Triangle {
    private int a, b, c;

    public Triangle (int a, int b, int c){
        if ( ((a + b) > c ) && ((b + c) > a ) && ((a + c) > b )){
            this.a = a;
            this.b = b;
            this.c = c;    
        }
        else{
            throw new ArithmeticException(
                String.format("The triangle cannot be constructed from the the numbers %d, %d, %d.", a, b, c));
        }
    }

    public boolean isIsosceles(){
        return ((a == b) || (b == c) || (a == c)) ? true : false;
    }

    public boolean isEquilateral(){
        return ((a == b) && (b == c)) ? true : false;
    }

    public boolean isRightAngeled(){
        return (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) || (Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)) || (Math.pow(c, 2) + Math.pow(b, 2) == Math.pow(a, 2)) ? true : false;
    }

    public int getPerimeter(){
        return a + b + c;
    }

    public double getArea(){
        double s = this.getPerimeter() / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
