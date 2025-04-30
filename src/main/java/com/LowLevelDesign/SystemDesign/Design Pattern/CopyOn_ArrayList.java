package WopiHostApplication.File;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOn_ArrayList {
    public static void main(String[] args) {

        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Milk");
        list.add("egg");
        list.add("rice");

        System.out.println(list);

        for(String X : list){
            System.out.println(X + " ");
            if(X.equals("Milk")){
                list.add("Bread");
                System.out.println("with Bread is added");
            }
        }

        System.out.println("Updated list " + list);
    }
}
