package Storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;
    private Salad[] salads;
    private Vegetable[] ingradients;
    private String filepath;

    public Salad[] getMenu() {
        return salads;
    }

    public Vegetable[] getIngradients() {
        return ingradients;
    }

    private Storage(Salad[] salads, Vegetable[] ingradients, String filepath) {
        this.filepath = filepath;
        this.salads = salads;
        this.ingradients = ingradients;
    }

    public Storage(String filepath) throws IOException, ClassNotFoundException {
        this.filepath = filepath;
        Storage storage;
        try {
            storage = readFile();
        } catch (FileNotFoundException e){
            storage = createDefaultStorage(filepath);
        }
        this.salads = storage.salads;
        this.ingradients = storage.ingradients;
    }

    private Storage readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filepath);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Storage storage = (Storage) objectIn.readObject();
        objectIn.close();
        return storage;
    }

    private boolean saveToFile() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filepath);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(this);
        objectOut.close();
        return true;
    }

    public boolean addSalad(Salad salad) throws IOException {
        Salad[] newArray = new Salad[salads.length+1];
        for (int i = 0;i<salads.length;i++)
            newArray[i] = salads[i];
        newArray[salads.length] = salad;
        this.salads = newArray;
        return saveToFile();
    }

    private Storage createDefaultStorage(String filepath){
        Vegetable carrot = new Vegetable("Carrot", 32, 1.3, 0.1, 6.9);
        Vegetable cucumber = new Vegetable("Cucumber", 15, 0.8, 0.1, 2.8);
        Vegetable tomato = new Vegetable("Tomato", 20, 1.1, 0.2, 3);
        HashMap<Vegetable, Integer> ingradients1 = new HashMap<Vegetable, Integer>();
        ingradients1.put(carrot, 3);
        ingradients1.put(cucumber, 1);
        ingradients1.put(tomato, 4);
        Salad rayskoeNaslajdenie = new Salad("Rayskoe Naslajdenie", ingradients1);
        HashMap<Vegetable, Integer> ingradients2 = new HashMap<Vegetable, Integer>();
        ingradients2.put(cucumber, 2);
        ingradients2.put(tomato, 2);
        Salad tomatoCucumberSalad = new Salad("Tomato and Cucumber Salad", ingradients2);

        Salad[] salads = {rayskoeNaslajdenie, tomatoCucumberSalad};
        Vegetable[] ingradients = {carrot, cucumber, tomato};
        return new Storage(salads, ingradients, filepath);
    }
}
