package day20;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        //Declaration

        ArrayList list =new ArrayList<>();
//        List<Integer> ls = new ArrayList<>();

        // For Homogenous elements to store

//        ArrayList <Integer> al = new ArrayList<Integer>();

        // Adding data to the ArrayList

            list.add(1000);
            list.add('A');
            list.add(true);
            list.add(10.7);
            list.add(null);
            list.add(null);
            list.add("welcome");
            list.add(1000);

        // to find the size of an Array List

        System.out.println("size of the list :"+list.size());

        // to print the data from the arraylist

        System.out.println("to print the values :"+ list);

        // to remove elements from the list

        list.remove(7); // need to specify the index
        System.out.println("New List after remove the element :"+ list);

        // Insert some element in the array list

        list.add(5,"Apple");
        System.out.println("After inserting :"+ list);

        // Brushing up loops concepts

        int arr[] ={1,2,3,4,5,6};

        for (int i=0;i<arr.length;i++){
            System.out.println("Array elements :"+arr[i]);
        }

        System.out.println("Break");

        int arr2[] = new int[6];
        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 3;
        arr2[3] = 4;
        arr2[4] = 5;
        arr2[5] = 6;

        for(int i =0 ; i<arr2.length;i++){
            System.out.println("Array elements :"+arr2[i]);
        }

        String name[] = {"Hari","Java","Selenium"};
        System.out.println(name[0]);
        System.out.println(name.length);


        for(String s:name){
            System.out.println(s);
        }




    }
}
