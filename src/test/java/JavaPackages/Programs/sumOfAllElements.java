package JavaPackages.Programs;

public class sumOfAllElements {

    public static int sumOfAllElements(int[] a){

        int sum=0;
        for(int i=0;i<a.length;i++){
            sum = sum + a[i];
        }

        return sum;

    }

    public static void main(String[] args) {
        // create a method with accepts array and returns sum of all elements

        int a[] = {1, 2, 3, 4, 5};

        int sum = sumOfAllElements(a);
        System.out.println(sum);


    }
}
