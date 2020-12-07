import org.junit.Assert;
import org.junit.Test;

import Storage.Salad;
import Storage.Storage;
import Storage.Vegetable;

import java.io.IOException;
import java.util.HashMap;

public class StorageTest {
    @Test
    public void shouldHaveCorrectNumberOfIngridients() {

        Storage st;
        try {
            st = new Storage("storage.dat");
            for(Salad salad : st.getMenu()){
                int actual = salad.getIngridientsMap().size();
                int expected;
                switch (salad.toString()){
                    case "Rayskoe Naslajdenie": 
                        expected = 3; break;
                    case "Tomato and Cucumber Salad": 
                        expected = 2; break;
                    default:
                        expected = -1;
                }
                Assert.assertEquals(expected , actual);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } 
    }

    @Test
    public void shoudHaveMoreThanZeroKcal(){
        Storage st;
        try {
            st = new Storage("storage.dat");
            for(Salad salad : st.getMenu()){
                int actual = salad.getKcal();
                Assert.assertNotEquals(0 , actual);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } 
    }

    @Test
    public void shouldReturnCorrectVegByKcal(){
        Storage st;
        try {
            st = new Storage("storage.dat");
            for(Salad salad : st.getMenu()){
                String expected = "Ничего не найдено!";
                String actual = salad.getVegByKcal(0, 0);
                Assert.assertEquals(expected , actual);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } 
        
    }

    @Test
    public void shouldReturnCorrectNumberOfSalads(){
        Storage st;
        try {
            st = new Storage("storage.dat");
            Assert.assertEquals(2, st.getMenu().length);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } 
        
    }

    @Test
    public void shouldReturnCorrectNumberOfIngradients(){
        Storage st;
        try {
            st = new Storage("storage.dat");
            Assert.assertEquals(3, st.getIngradients().length);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } 
        
    }

    @Test
    public void shouldCorrectAddSaladToMenu(){
        Storage st;
        try {
            st = new Storage("storageTestAddSalad.dat");
            int oldAmountOfSalads = st.getMenu().length;
            HashMap<Vegetable, Integer> ingradients1 = new HashMap<Vegetable, Integer>();
            for(int i = 0;i<3;i++)
                ingradients1.put(st.getIngradients()[i], i+1);
            Salad salad = new Salad("test", ingradients1);
            st.addSalad(salad);

            Assert.assertEquals(oldAmountOfSalads+1, st.getMenu().length);
            Assert.assertEquals(3, st.getIngradients().length);
            Assert.assertEquals(3, st.getMenu()[oldAmountOfSalads].getIngridientsMap().size());
            Assert.assertEquals(salad, st.getMenu()[oldAmountOfSalads]);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } 
        
    }
}
