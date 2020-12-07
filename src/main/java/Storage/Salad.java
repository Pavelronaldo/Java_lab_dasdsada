package Storage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Salad implements Serializable {
   
    private static final long serialVersionUID = 1L;
    private HashMap<Vegetable, Integer> ingridients = new HashMap<>();
    private String name;

    public int getKcal(){
        int kcal = 0;
        for(Map.Entry<Vegetable , Integer> entry : ingridients.entrySet()  ){
              kcal += entry.getKey().getKcal()*entry.getValue();
        }
        return kcal;
    } /** TESTIN **/

    public String getVegByKcal(int MinKcal , int MaxKcal) {
        StringBuilder sb = new StringBuilder();
        for (Vegetable vegetable : ingridients.keySet()) {
            if (vegetable.getKcal() >= MinKcal && vegetable.getKcal() <= MaxKcal) {
                sb.append(vegetable.toString() + ", ");
            }
        }
        if(sb.length() > 1) {
            sb.delete(sb.lastIndexOf(","), sb.length());
            return sb.toString();
        } else {
            return "Ничего не найдено!";
        }
    } /** TESTIN **/

    public String getIngridients() {
        StringBuilder sb = new StringBuilder();
        List<Vegetable> list = new ArrayList<>();
        for(Vegetable vegetable : ingridients.keySet()) {
            list.add(vegetable);
        }

        Collections.sort(list);

        for(Vegetable vegetable : list){
            sb.append(vegetable.toString() + ", ");
        }
        sb.delete(sb.lastIndexOf(",") , sb.length());
        return sb.toString();
    }

    @Override
    public String toString(){
        return name;
    }

    public Map<Vegetable ,Integer> getIngridientsMap(){
        return ingridients;
    }

    public Salad(String name, HashMap<Vegetable, Integer > ingridients){
        this.name = name;
        this.ingridients = ingridients;
    }
}

