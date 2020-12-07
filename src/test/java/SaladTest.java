import org.junit.Assert;
import org.junit.Test;

import Storage.Salad;
import Storage.Storage;
import Storage.Vegetable;

import java.io.IOException;
import java.util.HashMap;

public class SaladTest {
    @Test
    public void shouldCorrectCreateObject(){
        Storage st;
        try {
            st = new Storage("storage.dat");
            HashMap<Vegetable, Integer> ingradients1 = new HashMap<Vegetable, Integer>();
            for(int i = 0;i<3;i++)
                ingradients1.put(st.getIngradients()[i], i+1);
            Salad salad = new Salad("test", ingradients1);
            Assert.assertEquals(3, salad.getIngridientsMap().size());
            for(int i = 0;i<3;i++)
                Assert.assertEquals(i+1, (int) salad.getIngridientsMap().get(st.getIngradients()[i]));
            Assert.assertNotEquals(salad.getKcal(),0);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } 
        
    }
}
