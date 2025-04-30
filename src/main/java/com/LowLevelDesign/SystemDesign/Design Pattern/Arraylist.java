package WopiHostApplication.File;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arraylist {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        System.out.println(list.getClass().getName());

        List<String> list1 = Arrays.asList("Monday", "Tuesday");
        System.out.println(list1.getClass().getName());
        System.out.println(list1.get(1));

        String[] array = {"apple" , "Banana" , "Cherry"};
        List<String> list3 = Arrays.asList(array);
//        list3.add("Mango"); // we cannot add by using asList()
        System.out.println(list3);
        System.out.println(list1.getClass().getName());


        List<String> list4 = new ArrayList<>(list3);
        list4.add("Mango");
        System.out.println(list4);
        list4.remove("Banana");
        System.out.println(list4);

        List<Integer> list2 = List.of(1,2,3,4);
//        list2.set(1,50);


        List<Integer> list5 = new ArrayList<>();
        list5.add(1);
        list5.add(2);
        list5.add(3);

        List<Integer> list6 = List.of(4,5,6);
        list5.addAll(list6);
        System.out.println(list5);

        list5.remove(Integer.valueOf(6));
        System.out.println(list5);

        Integer[] array1 = list5.toArray(new Integer[0]);
        System.out.println(array1);

        for(Integer x : array1){
            System.out.print(x);
        }











    }
}
