package JavaPackages.ArrayMasClass;

public class IntMinimumNumber {

    /* 2, 3, 4
       5, 7, ,9
       1, ,6 ,5
     */

    public static void main(String[] args) {

        int a[][] = {{2, 3, 4}, {5, 7, 9}, {1, 6, 5}};

        int minimumNumber = a[0][0];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if(a[i][j]<minimumNumber){
                    minimumNumber = a[i][j];
                }
            }
        }
        System.out.println(minimumNumber);


        ///Maxmimum number

        int b[][] = {{2, 3, 4}, {5, 7, 9}, {1, 6, 5}};

        int maximumNumber = a[0][0];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if(b[i][j]>maximumNumber){
                    maximumNumber = a[i][j];
                }
            }
        }
        System.out.println(maximumNumber);

    }
}
