import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import Storage.Salad;
import Storage.Storage;
import Storage.Vegetable;

public class  Kitchen {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filepath;
        if(args.length == 0)
            filepath = "menu.dat";
        else 
            filepath = args[0];
        Storage storage = new Storage(filepath);
        Salad[] salads = storage.getMenu();

        System.out.println("Choose ur salad:");
        for (int i = 0; i < salads.length; i++)
            System.out.println(i+") "+salads[i].toString());
        System.out.println("\nOr type 'add' if you want to add new salad\n>");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();

        if (answer.equals("add"))
            addSaladHandler(storage);
        else{
            int saladNo = Integer.parseInt(answer);
            giveOrderHandler(salads[saladNo]);
        }
    }

    private static void addSaladHandler(Storage storage) throws IOException {
        Vegetable[] ingradients = storage.getIngradients();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the name for u salad? \n>");
        String name = reader.readLine();
        System.out.println("What ingradients do you want to add in salad? Availible ingradients: \n");
        for (int i = 0; i < ingradients.length; i++)
            System.out.println(i+") " + ingradients[i].toString());
        System.out.println("Type comma-separated list of ingradients. Each ingradient shoud be with it`s amount, separated by ':' (ex: '1:3,2:1,3:3' means 3 times of ingradient 1, 1 times of ingradient 2, and 3 times of ingradient 3):\n>");
        String ingradientsString = reader.readLine();
        String[] ingradientsStringParsed = ingradientsString.split(",");
        HashMap<Vegetable, Integer> requiredIngradients = new HashMap<Vegetable, Integer>();
        for(int i = 0; i < ingradientsStringParsed.length; i++){
            String[] vegParsed = ingradientsStringParsed[i].split(":");
            int vegIndex = Integer.parseInt(vegParsed[0]);
            int vegAmount = Integer.parseInt(vegParsed[1]);
            Vegetable veg = ingradients[vegIndex];
            requiredIngradients.put(veg, vegAmount);
        }
        
        Salad newsalad = new Salad(name, requiredIngradients);
        if (storage.addSalad(newsalad))
            System.out.println("# Success, your salad was added to menu!");
            System.out.println("# " + newsalad.toString());
            System.out.println("# " + newsalad.getIngridients());
    }

    private static void giveOrderHandler(Salad order){
        System.out.println("Thank u for ur order! " +
                    "\n\tSalad: " + order.toString() +
                    "\n\tIngridients: " + order.getIngridients() +
                    "\n\tKcal = " + order.getKcal() +
                    "\n====================================" +
                    "\n\tFound by kcal vegs: " + order.getVegByKcal(7, 15));
    }
}
/**Шеф-повар.
 * 1 Определить иерархию овощей.
 * 2 Сделать салат.
 * 3 Посчитать калорийность.
 * 4 Провести сортировку овощей для салата на основе одного из параметров.
 * 5 Найти овощи в салате, соответствующие заданному диапазону калорийности.
 * */

/*
* Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
Каждый класс должен иметь исчерпывающее смысл название и информативный состав.
Наследование должно применяться только тогда, когда это имеет смысл.
При кодировании должны быть использованы соглашения об оформлении кода java code convention.
Классы должны быть грамотно разложены по пакетам.
Работа с консолью или консольное меню должно быть минимальным.
Для хранения параметров инициализации можно использовать файлы.
Весь коддолжен быть покрыт югит тестамию Использовать Junit 4 или 5, Mockito.
*/

