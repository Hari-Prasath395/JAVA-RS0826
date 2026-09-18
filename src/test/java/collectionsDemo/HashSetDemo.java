package collectionsDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {

        /*
         * CORE CONCEPT OF HASHSET:
         * 1. No Duplicates: Unlike ArrayList, a Set cannot contain duplicate items. If you add the same item twice, it ignores it.
         * 2. Unordered: It does NOT maintain the insertion order. Items are arranged using hashing internally.
         * 3. No Indexing: You cannot access items by index like get(0) because there is no fixed position.
         * 4. Null values: It allows at most one single null element.
         */

        // 1. Raw HashSet Declaration
        // - How it works: Creates a standard, raw HashSet without any type restrictions.
        // - What can go inside: Any type of Object (Numbers, Strings, Booleans, custom objects).
        // - The catch: Lacks type safety. Java treats everything inside as a generic Object,
        //   meaning you must manually typecast elements when retrieving them, increasing the risk of runtime errors.
        HashSet mySet = new HashSet();


        // 2. Interface Reference with Concrete Implementation
        // - The concept: Interface on the left ('Set'), concrete implementation class on the right ('HashSet').
        // - Analogy: 'Set' is like the contract "Music Player", while 'HashSet' is a specific brand like "Sony Walkman".
        // - Why use it: Loose coupling and flexibility. If you later want to preserve insertion order (LinkedHashSet)
        //   or keep items sorted (TreeSet), you only change the right side: `new LinkedHashSet()`.
        //   The rest of your code using 'myset2' remains completely untouched.
        Set myset2 = new HashSet();


        // 3. Generics-Enforced Set (Recommended Best Practice)
        // - The <String> part (Generics): Restricts this Set so it ONLY accepts String objects.
        // - Type Safety: If you try to add an integer like 123, Java catches the mistake at compile-time
        //   before the code even runs.
        // - No Casting: You can pull items directly out as Strings without explicit casting.
        // - Diamond Operator: In Java 7 and newer, you can simplify the right side to `new HashSet<>()`.
        Set<String> mysSet3 = new HashSet<String>();

        HashSet mySt = new HashSet();
        mySt.add("Python");
        mySt.add(100);
        mySt.add(true);
        mySt.add("null");
        mySt.add(10.5);
        mySt.add(100);
        mySt.add(null);
        mySt.add("Java");

        //To print the Hashset
        System.out.println("To print the Hashset : "+ mySt);

        //To Remove a specific element from the hashset
        mySt.remove("Java");
        System.out.println("After removing a specific element from the hashset  : "+ mySt);

        //Inserting element is not possible
        //To get the specific element from the Hashset is not possible , However there is a work around below:

        //To get a specific element from the Hashset we can convert o Array List

        ArrayList al = new ArrayList(mySt);

        // To get the specific element

        System.out.println("To get the specific value"+" "+al.get(3));

        //To find the size of the Hashset
        System.out.println("To find the size "+ mySt.size());

        //We can't able to use for loop as it requires indexing

        //To retrieve the elements from the Set we can use enhanced for

//        for(Object myval :mySt){
//            System.out.println(myval);
//        }

        Iterator it = mySt.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //clearing all the elements from the Hashset

        mySt.clear();

        //To find the element is empty or not

        System.out.println(mySt.isEmpty());






    }
}