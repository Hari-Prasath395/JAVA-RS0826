package streams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamsDemo {

    //Count the number of names starting with alphabet A in the list

    @Test
    public void countAlphabets() {

        ArrayList<String> list = new ArrayList<String>();
        list.add("Aryan");
        list.add("Tommy");
        list.add("James");
        list.add("Allan");
        list.add("Abhijit");

        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            String names = list.get(i);
            if (names.startsWith("A")) {
                count++;
            }
        }

        System.out.println("The Number of names starting with A :" + count);

    }

    // @Test is an annotation provided by JUnit.
// It tells JUnit that this method is a test method.
// When we run the test class, JUnit will automatically execute this method.
    @Test
    public void streamFilter() {

        // ArrayList<String>
        // ----------------
        // ArrayList is a class from java.util package.
        // It is used to store a collection/list of objects.
        //
        // <String> is a generic type.
        // It means this ArrayList can store ONLY String objects.
        //
        // list is the reference variable that points to the ArrayList object.
        //
        // new ArrayList<String>()
        // creates a new ArrayList object in memory.
        ArrayList<String> list = new ArrayList<String>();


        // add()
        // -----
        // add() is a method of ArrayList.
        // It adds an element to the end of the list.
        //
        // Since our ArrayList is ArrayList<String>,
        // we can add String values to it.
        list.add("Aryan");
        list.add("Tommy");
        list.add("James");
        list.add("Allan");
        list.add("Abhijit");


        // STREAM
        // ------
        // stream() is a method provided by the Collection interface.
        //
        // It creates a Stream from our list.
        //
        // A Stream allows us to process the elements of a collection
        // using operations such as:
        // filter(), map(), sorted(), count(), collect(), etc.
        //
        // IMPORTANT:
        // Creating a stream does NOT change the original list.
        //
        // list:
        // [Aryan, Tommy, James, Allan, Abhijit]
        list.stream()


                // filter()
                // --------
                // filter() is an INTERMEDIATE OPERATION.
                //
                // It is used to select elements that satisfy a condition.
                //
                // filter() expects a Predicate.
                // A Predicate is a functional interface that takes one value
                // and returns true or false.
                //
                // Here, each String from the list will be passed to the filter.
                //
                // Only elements for which the condition returns true
                // will continue to the next operation.
                .filter(

                        // s
                        // -
                        // 's' represents the current String element in the stream.
                        //
                        // For example, during execution:
                        // s = "Aryan"
                        // s = "Tommy"
                        // s = "James"
                        // s = "Allan"
                        // s = "Abhijit"
                        //
                        // The variable name 's' is arbitrary.
                        // We could also write:
                        // name -> name.startsWith("A")
                        // person -> person.startsWith("A")
                        //
                        // -> is the lambda operator.
                        //
                        // A lambda expression provides the implementation
                        // of a functional interface.
                        //
                        // s -> s.startsWith("A")
                        // means:
                        //
                        // "Take a String called s and check whether it starts with A."
                        s -> s.startsWith("A")
                )


                // count()
                // -------
                // count() is a TERMINAL OPERATION.
                //
                // It counts how many elements remain after filter().
                //
                // The return type of count() is long, NOT int.
                //
                // Why long?
                // Because a Stream could theoretically contain more elements
                // than the maximum value that an int can represent.
                .count();


        // The value returned by count() is stored in the variable 'count'.
        //
        // long
        // ----
        // long is a primitive data type in Java.
        // It is used to store whole numbers with a larger range than int.
        //
        // count contains:
        // 3
        //
        // Because these names start with "A":
        // Aryan
        // Allan
        // Abhijit
        long count = list.stream()
                .filter(s -> s.startsWith("A"))
                .count();


        // System.out.println()
        // -------------------
        // System is a predefined Java class.
        //
        // out is a static field of System.
        // It represents the standard output stream (usually the console).
        //
        // println() prints the value to the console
        // and then moves the cursor to a new line.
        //
        // Output:
        // 3
        System.out.println(count);

/*
    }// End of streamFilter() method

    The most important Stream concept

    Your original comment is correct:

// There is no life for intermediate operations
// if there is no terminal operation.


    A better way to understand it is:

// filter() is an intermediate operation.
// Intermediate operations are LAZY.
// They are not actually executed immediately.
//
// The Stream pipeline is normally executed only when
// a terminal operation is called.
//
// Here:
//
// list.stream()
//      .filter(s -> s.startsWith("A"))  // intermediate
//      .count();                         // terminal
//
// count() triggers the actual processing of the stream.



    For your example, the flow is essentially:

    Original List
     |
    v
[Aryan, Tommy, James, Allan, Abhijit]
            |
    v
    stream()
     |
    v
    filter(s -> s.startsWith("A"))
            |
            +---- Aryan   -> true  -> keep
     +---- Tommy   -> false -> remove
     +---- James   -> false -> remove
     +---- Allan   -> true  -> keep
     +---- Abhijit -> true  -> keep
     |
    v
[Aryan, Allan, Abhijit]
            |
    v
    count()
     |
    v
3

    Intermediate vs Terminal Operations
// INTERMEDIATE OPERATION
// ----------------------
// filter() returns another Stream.
// It can therefore be chained with another operation.
//
// Examples:
// filter()
// map()
// sorted()
// distinct()
// limit()
// skip()
//
// These operations are generally LAZY.


// TERMINAL OPERATION
// ------------------
// count() produces a final result.
// It does NOT return another Stream.
//
// Examples:
// count()
// collect()
// forEach()
// reduce()
// anyMatch()
// allMatch()
// findFirst()
//
// A terminal operation triggers stream processing.


    For example, this does not actually process the elements yet:

            list.stream()
            .filter(s -> s.startsWith("A"));


    But this does:

            list.stream()
            .filter(s -> s.startsWith("A"))
            .count();


    because count() is the terminal operation that triggers the stream pipeline.

    */
    }


    @Test
    public void streamdemo2(){

        long d = Stream.of("Abhi","Tuna","Tom","Alto","Adam").filter(s->{
            s.startsWith("A");
            return true;
        }).count();

        System.out.println(d);
    }
}