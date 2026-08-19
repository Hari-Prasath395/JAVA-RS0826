package day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ifelseCondition {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.println(arr[i]);
                break;
            } else {
                System.out.println("This is not multiple of 2 :" + " " + arr[i]);
            }
        }


        ArrayList<String> a = new ArrayList<String>();
        a.add("Java");
        a.add("Selenium");
        a.add("Automation");
        a.add("Testing");

        System.out.println("ArrayList: " + a);
//        System.out.println("ArrayList remove: " + a.remove(2));

        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
        System.out.println("-------------------");

        for(String name :a){
            System.out.println(name);
        }

        //want to find whether an item is present in the list or not

        System.out.println("Is selenium Present in the list: "+ a.contains("Selenium"));

        //For example i am having an normal array and i want to convert it into arraylist

        String[] names= {"Java","Selenium","Automation","Testing"};
        List<String> nameList=Arrays.asList(names);

        System.out.println("Does the list contains Testing: " + nameList.contains("Testing"));
    }
}
