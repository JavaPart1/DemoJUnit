package be.vdab;

import be.vdab.domain.Fraction;

public class FractionApp {
    public static void main(String[] args) {
        Fraction fraction = new Fraction(4,12);

        System.out.println("\n simplified fraction : " + fraction.toString());

    }
}
