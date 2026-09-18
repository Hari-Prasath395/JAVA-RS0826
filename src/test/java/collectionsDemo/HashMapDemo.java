package collectionsDemo;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        // Declaration

        // HashMap hm = new HashMap();
        // Map map = new HashMap();

        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(101,"Teja");
        hm.put(102,"Ram");
        hm.put(103,"Kamal");
        hm.put(104,"David");
        hm.put(102,"Happy");

        //To print the Hash Map

        System.out.println(hm);

        //To get the value of a specific key

        System.out.println(hm.get(103));

        // To remove a key value pair

        hm.remove(101);
        //After removing the key value pair
        System.out.println("After removing the key value pair : "+ hm);

        //To get all the keys

        System.out.println("To get all the keys "+ hm.keySet());

        // To get all the values

        System.out.println("To get all the values "+ hm.values());

        //To get both key and values

        System.out.println("To get both key and values in the form of set "+" "+ hm.entrySet());



    }
}
