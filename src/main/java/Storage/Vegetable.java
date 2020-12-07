package Storage;

import java.io.Serializable;

public class  Vegetable implements Comparable<Vegetable>, Serializable{

     private static final long serialVersionUID = 1L;
     private String name;
     private double kcal;
     private double proteins;
     private double fat;
     private double carbohydrates;

     public double getKcal(){
          return kcal;
     }
     public double getProteins(){
          return proteins;
     }
     public double getFat(){
          return fat;
     }
     public double getCarbohydrates(){
          return carbohydrates;
     }

     public String toString(){
          return name;
     }

     @Override
     public int compareTo(Vegetable o) {
          return (int) (this.getKcal() - ((Vegetable) o).getKcal());
     }

     public Vegetable(String name, double kcal, double proteins, double fat, double carbohydrates){
          this.name = name;
          this.kcal = kcal;
          this.proteins = proteins;
          this.fat = fat;
          this.carbohydrates = carbohydrates;
     }
}


