package start;

public class DataTypesAndVariables {
    public static void main(String[] args) {

        int number = 5;
        String str = "Hello World";
        boolean a =true;
        float f = 3.14f;
        double d = 3.14;

        System.out.println("Integer: " + number);
        System.out.println("String: " + str);
        System.out.println("Boolean: " + a);
        System.out.println("Float: " + f);
        System.out.println("Double: " + d);

        //Arrays

        int arr[] = new int[7];
        arr[0] =1;
        arr[1] =2;
        arr[2] =3;

        System.out.println("arr[0]: " + arr[0]);

        int arr2[] = {1,2,3,4,5};
        System.out.println("arr2[0]: " + arr2[0]);
    }
}
