package JavaPackages.MethodOverloadAndOverride;

public class TestBrowser {


    public static void main(String[] args) {

        Browser browser;
        //Parent reference -> Child object

        browser = new ChromeBrowser();
        browser.openBrowser();

        // Output:
        // Opening Chrome browser

        browser = new FirefoxBrowser();

        browser.openBrowser();
        // Output:
        // Opening Firefox browser
    }



    // ================================================================
// 4-YEAR EXPERIENCE INTERVIEW QUESTIONS
// ================================================================


// Q1. What is method overloading?
//
// Answer:
// Method overloading means having multiple methods with the same
// name but different parameter lists in the same class.
//
// Example:
// login()
// login(String username)
// login(String username, String password)


// Q2. What is method overriding?
//
// Answer:
// Method overriding happens when a child class provides its own
// implementation of a method that is already defined in the
// parent class.


// Q3. What is the difference between overloading and overriding?
//
// Answer:
//
// Overloading:
// - Same method name
// - Different parameters
// - Usually within the same class
// - Compile-time polymorphism
//
// Overriding:
// - Same method signature
// - Parent-child relationship
// - Runtime polymorphism


// Q4. Can we overload a method by changing only its return type?
//
// Answer:
// NO.
//
// This will NOT work:
//
// public int login() {
//     return 1;
// }
//
// public String login() {
//     return "Success";
// }
//
// Java cannot determine which method to call based only on
// the return type.


// Q5. Can we overload static methods?
//
// Answer:
// YES.
//
// Static methods can be overloaded because overloading is based
// on the method parameters.


// Q6. Can we override a static method?
//
// Answer:
// NO.
//
// Static methods belong to the class, not the object.
// If a child class defines a static method with the same signature,
// it is called method hiding, not method overriding.


// Q7. Can we override a private method?
//
// Answer:
// NO.
//
// Private methods are not accessible outside the class in which
// they are declared, so they cannot be overridden.


// Q8. Can we override a final method?
//
// Answer:
// NO.
//
// A final method cannot be overridden by a child class.


// Q9. Can an overridden method have a different return type?
//
// Answer:
// It can have the same return type or a covariant return type.
//
// Example:
//
// Parent:
// public Browser getBrowser()
//
// Child:
// public ChromeBrowser getBrowser()
//
// This is allowed because ChromeBrowser is a subtype of Browser.


// Q10. What is @Override?
//
// Answer:
// @Override is an annotation used to tell the compiler that
// we are intentionally overriding a method from the parent class.
//
// It also helps catch mistakes in the method signature.


// Q11. What is compile-time polymorphism?
//
// Answer:
// Method overloading is compile-time polymorphism because the
// compiler determines which overloaded method should be called
// based on the arguments.


// Q12. What is runtime polymorphism?
//
// Answer:
// Method overriding is runtime polymorphism because the method
// implementation is selected at runtime based on the actual object.


// Q13. Can we override a method with a more restrictive access modifier?
//
// Example:
//
// Parent:
// public void login()
//
// Child:
// protected void login()
//
// Answer:
// NO.
//
// We cannot reduce the visibility of an overridden method.
//
// public → protected is NOT allowed.
//
// But we can increase visibility:
//
// protected → public is allowed.


// Q14. Why do we use method overriding in automation frameworks?
//
// Answer:
// It allows child classes to provide different implementations
// of common behavior.
//
// Example:
//
// Browser
//    ↓
// ChromeBrowser
// FirefoxBrowser
// EdgeBrowser
//
// Each browser can provide its own implementation of
// openBrowser().


// Q15. Give a real Selenium example of method overloading.
//
// Answer:
//
// We can create different versions of a method:
//
// clickElement(WebElement element)
// clickElement(By locator)
// clickElement(WebElement element, int timeout)
//
// Same method name, different parameters.
//
// This is method overloading.


// Q16. Give a real automation example of method overriding.
//
// Answer:
//
// Suppose we have:
//
// BaseTest
//     ↓
// ChromeTest
// FirefoxTest
//
// BaseTest can define:
//
// public void setupBrowser()
//
// ChromeTest and FirefoxTest can override setupBrowser()
// with their own browser-specific implementation.


// Q17. What happens if the parent reference points to a child object?
//
// Example:
//
// Browser browser = new ChromeBrowser();
//
// browser.openBrowser();
//
// Answer:
// The overridden method from ChromeBrowser will execute.
//
// This is runtime polymorphism.


// Q18. What is the difference between method overriding and
// method hiding?
//
// Answer:
//
// Overriding → instance methods
// Hiding     → static methods
//
// Static methods are resolved based on the reference/class,
// while overridden instance methods are resolved based on
// the actual object.


// Q19. Is @Override mandatory?
//
// Answer:
// No.
//
// The method can still override the parent method without
// @Override.
//
// However, @Override is strongly recommended because the compiler
// can detect mistakes in the method signature.


// Q20. Why is polymorphism important in automation frameworks?
//
// Answer:
// Polymorphism allows us to write flexible and reusable code.
//
// For example:
//
// WebDriver driver = new ChromeDriver();
//
// WebDriver driver = new FirefoxDriver();
//
// The same WebDriver reference can work with different
// browser implementations.
}
