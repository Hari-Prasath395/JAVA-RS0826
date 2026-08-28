package JavaPackages;

public class NestedForLoopDemo {

    public static void main(String[] args) {

        for(int i = 0 ; i<4 ; i++) // outer loop - deals with rows
        {
            System.out.println("Outer loop started");
            for( int j =0 ; j<4; j++) // inner loop - deals with columns
            {
                System.out.println("Inner loop started");

            }
            System.out.println("Outer loop ended");
        }


        /// make a traingle pattern using nested for loop
        for(int i = 0 ; i<4 ; i++){
              for(int j=0 ; j<=i ; j++){
                  System.out.print("* ");
              }
              System.out.println();
        }
    }
}
