package JavaPackages.Programs;

public class MultiplyTableWithoutMultiplyOperator
{

    public static int multiply(int i,int j){

        //logic i has to add itself with j number of times
        int sum = 0;
        int k =1;
        while (k <= j) {
            sum = sum + i;
            k++;
        }

        return sum;
    }
    public static void main(String[] args) {

        int result = multiply(3,4);
        System.out.println(result);
    }
}
