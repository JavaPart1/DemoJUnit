package be.vdab.domain;

import static java.lang.Math.abs;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        simplify();
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator/denominator :  " + numerator +
                "/" + denominator +
                '}';
    }

    private void simplify(){
        int gCf = greatestCommonFactor(this.numerator,this.denominator);
        this.numerator /= gCf;
        this.denominator /= gCf;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public static int greatestCommonFactor(int a, int b) {
        if(a == 0 || b == 0) {
            return 1;
        }

        a = abs(a);
        b = abs(b);
        if(a < b) {
            return greatestCommonFactor(b, a);
        }

        int delta = a % b;
        if(delta == 0) {
            return b;
        } else {
            return greatestCommonFactor(b, delta);
        }
    }
}
