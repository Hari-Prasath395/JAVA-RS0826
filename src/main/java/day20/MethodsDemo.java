package day20;

public class MethodsDemo {

    public static String getData() {
        System.out.println("Hello World");
        return "Automation framework";
    }

    public static void main(String[] args) {
//        MethodsDemo demo = new MethodsDemo();
        String s = getData();
        System.out.println("Data from method: " + s);


        MethodsDemo2 demo2 = new MethodsDemo2();
        demo2.userData();

    }
}
