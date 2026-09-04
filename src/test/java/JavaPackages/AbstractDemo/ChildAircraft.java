package JavaPackages.AbstractDemo;

public class ChildAircraft extends ParentAircraft {



    @Override
    public void color() {
        System.out.println("Red color");
    }

    public static void main(String[] args) {

        ChildAircraft aircraft = new ChildAircraft();
        aircraft.color();
        aircraft.engine();
        aircraft.fuel();
    }

}
