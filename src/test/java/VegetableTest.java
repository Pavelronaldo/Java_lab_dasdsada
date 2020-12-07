import org.junit.Assert;
import org.junit.Test;

import Storage.Vegetable;

public class VegetableTest {
    @Test
    public void shouldCorrectCreateObject(){
        Vegetable test1 = new Vegetable("test", 1, 2, 3, 4);
        Vegetable test2 = new Vegetable("test", 2, 2, 3, 4);
        Assert.assertEquals(1, test1.getKcal(), 1e-8);
        Assert.assertEquals(2, test1.getProteins(), 1e-8);
        Assert.assertEquals(3, test1.getFat(), 1e-8);
        Assert.assertEquals(4, test1.getCarbohydrates(), 1e-8);
        Assert.assertTrue("compareTo() error", test1.compareTo(test2) < 0);
    }
}
