package day20;

public class DeclareString {

    public static void main(String[] args) {

        // String is an object that represents a sequence of characters
        String str1 = "Hello World"; // String literal
        //Explain about string literal and string object
        // String literal is a sequence of characters enclosed in double quotes. It is stored in the string pool, which is a special memory area for storing string literals. When you create a string literal, Java checks if the same string already exists in the pool. If it does, it reuses the existing string instead of creating a new one. This helps save memory and improve performance.
        // String object is an instance of the String class that is created using the new keyword.
        // It is stored in the heap memory, which is a general-purpose memory area for storing objects. When you create a string object, Java always creates a new object in the heap, even if the same string already exists in the pool. This can lead to more memory usage and slower performance compared to string literals.

        String str2 = new String("Hello World"); // String object


        String str3 = "Hello welcome to Java";
        String[] splittedString = str3.split(" ");
        for(String s : splittedString){
            System.out.println(s);
        }

        String str4 = "Hari Academy";
        String[]  t =str4.split("");
        for(int i =t.length-1 ; i>=0;i--){
            System.out.println(str4.charAt(i));
        }

    }
}
