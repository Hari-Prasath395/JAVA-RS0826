package JavaPackages.MethodOverloadAndOverride;

public class ChromeBrowser extends Browser {

    // This is METHOD OVERRIDING.
    //
    // Parent class:
    //     openBrowser()
    //
    // Child class:
    //     openBrowser()
    //
    // Same method signature, but different implementation.

    @Override
    public void openBrowser(){
        System.out.println("Opening chrome browser");
    }

}
