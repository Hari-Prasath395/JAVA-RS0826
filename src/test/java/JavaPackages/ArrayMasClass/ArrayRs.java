package JavaPackages.ArrayMasClass;

public class ArrayRs {

    public static void main(String[] args) {
//        int a;
//        a=4;

        // A container which stores multiple values of same data type

        int a[] = new int[3];//Declares an array and allocating the memory
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;

        int b[] = {1, 2, 3, 4, 5};

        for(int i =0 ; i<b.length; i++){
            System.out.println(b[i]);
        }



    }
}
