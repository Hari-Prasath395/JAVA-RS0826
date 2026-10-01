package JavaPackages.TypeCasting;

public class UpAndDownCasting {

    //upcasting -   converting a value from smaller to larger

    //down casting - converting a value from higher to smaller

    public static void main(String[] args) {

        //Upcasting - automatic ---smaller to larger
        //Example 1
        int intValue = 100;
        long longValue = intValue;
        System.out.println(longValue);

        //Example 2

        float floatValue = 10.4f;
        double doubleValue = floatValue;
        System.out.println(doubleValue);

        // downcasting --manual --- larger to smaller
        // Example 3

        long longVal = 1000;
        int i =(int) longVal;
        System.out.println(i);

        // Example 4

        double dlvalue = 10323.22;
        float fl =(float) dlvalue;
        System.out.println(fl);

        //Example 5

        int j = 100;
        double dj = j;  // upcasting
        System.out.println(dj);

        // Example 6

        double d = 10.421321;
        int k = (int)d;
        System.out.println(k);





    }
}
