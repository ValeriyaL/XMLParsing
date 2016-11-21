package test.by.liudchyk.xml.builder;

import by.liudchyk.xml.builder.AbstractCandyBuilder;
import by.liudchyk.xml.creator.CandyBuilderFactory;
import by.liudchyk.xml.entity.Candy;
import by.liudchyk.xml.entity.CandyType;
import by.liudchyk.xml.entity.Chocolate;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

/**
 * Created by Admin on 21.11.2016.
 */
public class TestCandyDOMBuilder {
    private static CandyBuilderFactory sFactory;
    private static AbstractCandyBuilder builder;
    private static Set<Candy> candySet;


    @BeforeClass
    public static void initBuilder() {
        sFactory = new CandyBuilderFactory();
        builder = sFactory.createStudentBuilder("dom");
        builder.buildSetCandies("data/candies.xml");
        candySet = builder.getCandySet();
    }

    @AfterClass
    public static void eraseBuilder() {
        builder = null;
        sFactory = null;
        candySet = null;
    }

    @Test
    public void checkBuildCandySet1() {
        int current = candySet.size();
        int expected = 16;
        Assert.assertEquals(expected, current);
    }

    @Test
    public void checkBuildCandySet2() {
        int chocolates = 0;
        for (Candy temp : candySet) {
            if (temp.getClass() == Chocolate.class) {
                chocolates++;
            }
        }
        int chocolatesExpected = 8;
        Assert.assertEquals(chocolatesExpected, chocolates);
    }

    @Test
    public void checkBuildCandySet3() {
        int candies = 0;
        for (Candy temp : candySet) {
            if (temp.getClass() == Candy.class) {
                candies++;
            }
        }
        int candiesExpected = 8;
        Assert.assertEquals(candiesExpected, candies);
    }

    @Test
    public void checkBuildCandySet4() {
        CandyType type = CandyType.CARAMEL;
        for (Candy temp : candySet) {
            if ("BLR44323".equals(temp.getCandyId())) {
                type = temp.getType();
            }
        }
        CandyType expectedType = CandyType.CHOCOLATE;
        Assert.assertTrue(expectedType.equals(type));
    }

    @Test
    public void checkBuildCandySet5() {
        int hazelnut = 10;
        for (Candy temp : candySet) {
            if ("BLR24323".equals(temp.getCandyId())) {
                hazelnut = ((Chocolate) temp).getAdditives().getHazelnut();
            }
        }
        int expectedHazelnut = 0;
        Assert.assertEquals(expectedHazelnut, hazelnut);
    }
}
