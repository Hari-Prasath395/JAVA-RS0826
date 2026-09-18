package collectionsDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        /*
         * Note on dynamic sizing:
         * A regular Java array (like int[]) has a fixed size—once you make it, you cannot expand it.
         * An ArrayList is a dynamic list that automatically grows or shrinks as you add or remove items.
         */

        // 1. Raw ArrayList Declaration
        // - How it works: Creates a standard, raw ArrayList.
        // - What can go inside: Anything. You can put a number, a word, a decimal, or an object all into this single list.
        // - The catch: Because it allows everything, Java treats everything inside as a generic Object.
        //   When you pull items out, you have to manually tell Java what type it is (typecasting), which easily leads to errors.
        ArrayList myList = new ArrayList();


        // 2. Interface Reference with Concrete Class
        // - The concept: Interface on the left (List), concrete class on the right (ArrayList).
        // - Analogy: Think of List as the general concept of a "Vehicle" and ArrayList as a specific "Sedan Car".
        // - Why use it: It gives you flexibility. Today you use ArrayList, but if tomorrow you want to
        //   switch to a LinkedList (another type of list), you only change the right side (new LinkedList()).
        //   The rest of your code doesn't break. This is considered a best practice in Java.
        List myList2 = new ArrayList();


        // 3. Generics-Enforced ArrayList
        // - The <Integer> part (Generics): The angle brackets < > set a strict rule for what is allowed inside.
        // - Simple meaning: "This list can only hold whole numbers (Integer)."
        // - Why it's better: If you try to add a word like "Hello" to myList3, Java will give you a compile-time
        //   error immediately before you even run the program. It prevents bugs early.
        // - Note: In modern Java (Java 7+), you can leave the second bracket empty: new ArrayList<>() (the diamond operator).
        ArrayList<Integer> myList3 = new ArrayList<Integer>();

        ArrayList myLt = new ArrayList();
        myLt.add(1000);
        myLt.add(12.5);
        myLt.add(true);
        myLt.add("Raja Ram");
        myLt.add(null);
        myLt.add(null);
        myLt.add('A');
        myLt.add("Welcome");

        System.out.println("To find the size of the ArrayList :"+ myLt.size());

        System.out.println("To print the ArrayList : " + myLt);

        myLt.remove(3);

        System.out.println("Remove element from an ArrayList : "+myLt);

        // Inserting a new element to an arrayList

        myLt.add(2,"Java");

        System.out.println("After inserting a new element to the List : "+ myLt);

        //Modify/Change/Replace the element in an ArrayList

        myLt.set(2,"Python");

        System.out.println("After updating the array list with new value " + myLt);

        //How to get or retrieve the element from the Array List

        myLt.get(3);
        System.out.println("To get an element from the list : "+myLt.get(3) );


        // Reading each and every element from the arrayList

//        for (int i = 0; i < myLt.size(); i++) {
//            System.out.println(myLt.get(i));
//        }

        //Using Enhanced For Loop

//        for(Object list:myLt){
//            System.out.println(list);
//        }

        //Using Iterator

        Iterator it=myLt.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

        //Checking my ArrayList is empty or not

        System.out.println(myLt.isEmpty());

        //there is a method clear to remove all the elements from the arraylist

        //Need to delete or remove elements randomly from a array list

        ArrayList myLt2 = new ArrayList();
        myLt2.add("Python");
        myLt2.add(1000);

        myLt.removeAll(myLt2);

        //After removing random elements
        System.out.println("After removing :"+myLt);

    }
}