package JavaPackages.ArrayMasClass;

public class MultiDimnesionalArrayRs {

    public static void main(String[] args) {

        int a[][] = new int[2][3];
        a[0][0] = 3;
        a[0][1] = 5;
        a[0][2] = 7;
        a[1][0] = 9;
        a[1][1] = 6;
        a[1][2] = 7;

        System.out.println(a[1][0]);

        int b[][]={{1,2,3},{2,3,5},{4,6,7}};

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.println(a[i][j]);
            }
        }
    }
}
