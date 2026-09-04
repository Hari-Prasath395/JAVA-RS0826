package JavaPackages.InterfaceDemo;

public class AustralianTrafficRules implements CentralTraffic, ContinentalTraffic {
    @Override
    public void greenGo() {
        System.out.println("Go with the implementation of Australian traffic rules");
    }

    @Override
    public void redStop() {
        System.out.println("Stop with the implementation of Australian traffic rules");
    }

    @Override
    public void flashYellow() {
        System.out.println("Flash yellow with the implementation of Australian traffic rules");
    }

    public void walkOnZebraCrossing() {
        System.out.println("Walk on zebra crossing with the implementation of Australian traffic rules");
    }

    @Override
    public void trainSymbol() {
        System.out.println("Train symbol with the implementation of Australian traffic rules");
    }

    public static void main(String[] args) {

        AustralianTrafficRules australianTrafficRules = new AustralianTrafficRules();
        australianTrafficRules.greenGo();
        australianTrafficRules.redStop();
        australianTrafficRules.flashYellow();
        australianTrafficRules.trainSymbol();
        australianTrafficRules.walkOnZebraCrossing();

    }


}
