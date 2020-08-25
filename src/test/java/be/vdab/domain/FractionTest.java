package be.vdab.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFraction(){
        Fraction testFraction = new Fraction(1,2);
        Assert.assertEquals(1,testFraction.getNumerator());
        Assert.assertEquals(2,testFraction.getDenominator());

        Fraction testFraction2 = new Fraction(2,4);
        Assert.assertEquals(1,testFraction2.getNumerator());
        Assert.assertEquals(2,testFraction2.getDenominator());
    }

    @Test
    public void testToString() {
        Fraction testFraction = new Fraction(1,2);
        Assert.assertNotNull(testFraction.toString());

    }
}