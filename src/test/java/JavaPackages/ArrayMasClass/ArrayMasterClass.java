package JavaPackages.ArrayMasClass;

public class ArrayMasterClass {

    public static void main(String[] args) {
        // ============================================================
        // 1. WHAT IS AN ARRAY?
        // ============================================================

        /*
         * Interview Question:
         * What is an Array in Java?
         *
         * Answer:
         * An Array is a fixed-size collection of elements of the same data type.
         *
         * Example:
         * int[] numbers = {10, 20, 30, 40, 50};
         *
         * Here:
         * - int[]  -> Array of integers
         * - numbers -> Array variable
         * - 10,20,30,40,50 -> Elements
         *
         * Important points:
         * 1. Array size is fixed.
         * 2. Array stores elements of the same type.
         * 3. Array index starts from 0.
         * 4. Array allows duplicate values.
         * 5. Array objects are created in heap memory.
         */


        // ============================================================
        // 2. DIFFERENT WAYS TO CREATE AN ARRAY
        // ============================================================

        // Method 1: Declaration + initialization
        int[] numbers = {10, 20, 30, 40, 50};

        // Method 2: Create array with fixed size
        int[] marks = new int[5];

        marks[0] = 80;
        marks[1] = 75;
        marks[2] = 90;
        marks[3] = 85;
        marks[4] = 95;



        // ============================================================
        // 3. ACCESSING ARRAY ELEMENTS
        // ============================================================

        System.out.println("First number: " + numbers[0]);
        System.out.println("Third number: " + numbers[2]);

        /*
         * Index:
         *
         *  Value:  10   20   30   40   50
         *  Index:   0    1    2    3    4
         *
         * Last index = length - 1
         *
         * For this array:
         * length = 5
         * last index = 5 - 1 = 4
         */

        // ============================================================
        // 4. ARRAY LENGTH
        // ============================================================


        System.out.println("Array length: " + numbers.length);

        /*
         * Interview Question:
         * What is the difference between length and length()?
         *
         * Answer:
         *
         * Array:
         *     array.length
         *
         * String:
         *     string.length()
         *
         * Example:
         *
         * int[] arr = {10, 20, 30};
         * arr.length;
         *
         * String name = "Hari";
         * name.length();
         */
        // ============================================================
        // 5. PRINT ARRAY USING FOR LOOP
        // ============================================================

        System.out.println("\nUsing normal for loop:");

        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }

        // ============================================================
        // 6. PRINT ARRAY USING ENHANCED FOR LOOP
        // ============================================================

        System.out.println("\nUsing enhanced for loop:");

        for(int nums:numbers){
            System.out.println(nums);
        }


        /*
         * Interview Question:
         * What is the difference between normal for loop and
         * enhanced for loop?
         *
         * Answer:
         *
         * Normal for loop:
         * - Gives access to index.
         * - Useful when we need to modify/access elements by index.
         *
         * Enhanced for loop:
         * - Easier to read.
         * - Does not directly provide the index.
         *
         * Example:
         *
         * for (int i = 0; i < arr.length; i++)
         *
         * vs
         *
         * for (int value : arr)
         */


        // ============================================================
        // 7. MODIFY ARRAY ELEMENT
        // ============================================================

        numbers[0] =100;

        System.out.println("\nAfter modifying first element:");

        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }

        // ============================================================
        // 8. FIND SUM OF ARRAY ELEMENTS
        // ============================================================

        System.out.println("\n sum of Array Elements:");
        int sum =0;
        for (int i=0;i<numbers.length;i++){
            sum = sum + numbers[i];
        }

        System.out.println(sum);

        // ============================================================
        // 9. FIND AVERAGE
        // ============================================================

        System.out.println("\n Average of Array Elements:");

        double average = (double)sum/numbers.length; //type cast if the average is in decimal
        System.out.println(average);

        // ============================================================
        // 10. FIND MAXIMUM VALUE
        // ============================================================

        System.out.println("\n Maximum number present in the Array Elements:");

        int max = numbers[0];

        for(int num : numbers){
            if(num>max){
                max =num;
            }
        }

        System.out.println(max);

        // ============================================================
        // 11. FIND MINIMUM VALUE
        // ============================================================

        System.out.println("\n Minimum number present in the Array Elements:");

        int min = numbers[0];

        for(int num : numbers){
            if(num<min){
                min = num;
            }
        }
        System.out.println("minimum number :"+min);

        // ============================================================
        // 12. SEARCH AN ELEMENT
        // ============================================================

        System.out.println("\n Searching an element in the Array:");

        int searchElement = 40;
        boolean found = false;

        for(int num : numbers){

            if(num == searchElement){
                found = true;
                break;
            }
        }
        if(found){
            System.out.println(searchElement + " found");
        }else {
            System.out.println("No such element found");
        }


        // ============================================================
        // 13. REVERSE AN ARRAY
        // ============================================================

        int[] reverseArray = {10, 20, 30, 40, 50};

        for (int i = reverseArray.length-1; i >= 0; i--) {
            System.out.println(reverseArray[i]);
        }


        /*
         * ================================================================
         * INTERVIEW QUESTIONS - 4 YEARS EXPERIENCE
         * ================================================================
         */


        /*
         * Q1. What is an Array?
         *
         * Answer:
         * An Array is a fixed-size data structure that stores elements
         * of the same data type.
         */


        /*
         * Q2. Why does Array indexing start from 0?
         *
         * Answer:
         * Array indexing is based on the offset from the first element.
         *
         * The first element is at offset 0, therefore its index is 0.
         */


        /*
         * Q3. Can an Array store different data types?
         *
         * Answer:
         * Normally, an array stores elements of the same declared type.
         *
         * Example:
         *
         * int[] numbers = {10, 20, 30};
         *
         * However, an Object[] can hold objects of different types:
         *
         * Object[] data = {10, "Hari", 10.5};
         */


        /*
         * Q4. Is Array size fixed or dynamic?
         *
         * Answer:
         * Array size is fixed.
         *
         * Once an array is created:
         *
         * int[] arr = new int[5];
         *
         * Its size cannot be changed.
         *
         * If we need a dynamic size, we normally use collections such as:
         *
         * ArrayList
         * HashSet
         * HashMap
         */


        /*
         * Q5. What is the difference between Array and ArrayList?
         *
         * Answer:
         *
         * Array:
         * - Fixed size
         * - Can store primitives directly
         * - Faster for simple indexed access
         *
         * ArrayList:
         * - Dynamic size
         * - Stores objects, not primitive types directly
         * - Provides methods such as add(), remove(), contains()
         */


        /*
         * Q6. What exception occurs when we access an invalid index?
         *
         * Answer:
         *
         * ArrayIndexOutOfBoundsException
         *
         * Example:
         *
         * int[] arr = {10, 20};
         * System.out.println(arr[5]);
         */


        /*
         * Q7. What happens if an Array reference is null?
         *
         * Answer:
         *
         * Accessing the array can cause NullPointerException.
         *
         * Example:
         *
         * int[] arr = null;
         * System.out.println(arr.length);
         */


        /*
         * Q8. What is the default value of an integer Array?
         *
         * Answer:
         *
         * int[] arr = new int[3];
         *
         * Default values:
         *
         * 0
         * 0
         * 0
         *
         * Other examples:
         *
         * boolean -> false
         * double  -> 0.0
         * Object  -> null
         */


        /*
         * Q9. Can we change the size of an Array?
         *
         * Answer:
         * No.
         *
         * Once the array is created, its size is fixed.
         *
         * We need to create a new array if we need a different size.
         */


        /*
         * Q10. What is a multidimensional Array?
         *
         * Answer:
         * A multidimensional array is an array containing other arrays.
         *
         * Example:
         *
         * int[][] matrix = new int[3][3];
         *
         * It is commonly used for matrix or table-like data.
         */


        /*
         * Q11. What is a jagged Array?
         *
         * Answer:
         * A jagged array is a multidimensional array where each row
         * can have a different number of elements.
         *
         * Example:
         *
         * int[][] arr = new int[3][];
         *
         * arr[0] = new int[2];
         * arr[1] = new int[4];
         * arr[2] = new int[1];
         */


        /*
         * Q12. What is the time complexity of accessing an Array element?
         *
         * Answer:
         *
         * arr[index]
         *
         * Time complexity = O(1)
         *
         * Because Java can directly calculate the memory location
         * using the index.
         */


        /*
         * Q13. What is the time complexity of searching an unsorted Array?
         *
         * Answer:
         *
         * Linear search = O(n)
         *
         * Because in the worst case we may need to check every element.
         */


        /*
         * Q14. What is the time complexity of binary search?
         *
         * Answer:
         *
         * O(log n)
         *
         * But the array must be sorted for binary search to work correctly.
         */


        /*
         * Q15. Can we store objects in an Array?
         *
         * Answer:
         * Yes.
         *
         * Example:
         *
         * String[] names = {"Hari", "John", "David"};
         *
         * We can also create arrays of custom objects:
         *
         * Employee[] employees = new Employee[5];
         */


        /*
         * Q16. What is the difference between:
         *
         * int[] arr
         * and
         * int arr[]
         *
         * Answer:
         *
         * Both are valid Java syntax and mean the same thing.
         *
         * Recommended style:
         *
         * int[] arr;
         *
         * because the array type is clearly associated with int.
         */


        /*
         * Q17. Can an Array contain duplicate values?
         *
         * Answer:
         * Yes.
         *
         * Example:
         *
         * int[] arr = {10, 20, 10, 30};
         *
         * 10 occurs twice.
         */


        /*
         * Q18. What happens if we don't initialize an Array?
         *
         * Answer:
         *
         * If the array reference is declared but not initialized:
         *
         * int[] arr;
         *
         * We cannot use arr until it is assigned an array object.
         *
         * If we try to access it before initialization,
         * Java gives a compile-time error for a local variable.
         */


        /*
         * Q19. Where are Array objects stored?
         *
         * Answer:
         *
         * Array objects are created in heap memory.
         *
         * The array variable/reference may exist in a stack frame when
         * it is a local variable, while the actual array object is in
         * the heap.
         */


        /*
         * Q20. Why would you choose an Array instead of ArrayList?
         *
         * Answer:
         *
         * I would consider an Array when:
         *
         * 1. The number of elements is known and fixed.
         * 2. I need simple indexed access.
         * 3. I don't need dynamic resizing.
         * 4. I want to work directly with primitive values.
         *
         * If the size needs to grow or shrink dynamically, I would
         * generally consider ArrayList or another suitable collection.
         */


        /*
         * ================================================================
         * 4-YEAR EXPERIENCE INTERVIEW SCENARIO
         * ================================================================
         *
         * Interviewer:
         *
         * "You receive an integer array containing duplicate values.
         * How would you find duplicate elements?"
         *
         * Answer:
         *
         * "For a simple solution, I can use nested loops, which takes
         * O(n²) time.
         *
         * For better performance, I can use a HashSet. I can add each
         * element to the Set and identify an element as duplicate when
         * add() returns false.
         *
         * The HashSet approach generally gives O(n) average time
         * complexity with O(n) additional space."
         */


        /*
         * ================================================================
         * IMPORTANT ARRAY PROBLEMS TO PRACTICE
         * ================================================================
         *
         * 1. Find largest element
         * 2. Find smallest element
         * 3. Find second largest
         * 4. Reverse an array
         * 5. Find duplicate elements
         * 6. Remove duplicates
         * 7. Count occurrences
         * 8. Find missing number
         * 9. Find common elements between two arrays
         * 10. Merge two arrays
         * 11. Sort an array
         * 12. Find pairs whose sum equals a target
         * 13. Move zeros to the end
         * 14. Find maximum and minimum simultaneously
         * 15. Rotate an array
         * 16. Find the first non-repeated element
         * 17. Find the first repeated element
         * 18. Check whether two arrays are equal
         * 19. Find intersection of two arrays
         * 20. Find union of two arrays
         *
         * These problems are particularly useful for automation/SDET
         * interviews because they test loops, conditions, collections,
         * complexity and problem-solving skills.
         */
    }








    }



