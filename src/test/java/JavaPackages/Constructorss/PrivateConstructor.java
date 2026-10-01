package JavaPackages.Constructorss;

public class PrivateConstructor {

    public PrivateConstructor() {
        System.out.println("Private constructor");
    }

    public static void main(String[] args) {

        //Now this is not allowed outside the class:

        PrivateConstructor obj1 = new PrivateConstructor();
        //because the constructor is private.
    }
    /*
    Why use a private constructor?

    A common use case is the Singleton design pattern, where we want to control object creation.

     */


    /*
10. Can a Constructor be static?

No.

This is a common interview question.

public static ConstructorDemo() {
}

This is invalid.

Why?

static belongs to the class, whereas a constructor is associated with creating an object.

A constructor is invoked as part of object creation, so it cannot be static.

11. Can a Constructor be final?

No.

public final ConstructorDemo() {
}

This is invalid.

Why?

Constructors are not inherited or overridden, so final has no meaningful purpose for constructors.

12. Can a Constructor be abstract?

No.

An abstract method has no implementation and is intended to be overridden.

A constructor is responsible for object initialization, so it cannot be abstract.

13. Can a Constructor be Overridden?

No.

Constructors cannot be overridden because constructors are not inherited.

However, constructors can be overloaded.

Remember:

Constructor → Overloading → YES
Constructor → Overriding  → NO

This is a very important interview point.


Q: What is a constructor?

A constructor is a special member of a class used to initialize an object. It has the same name as
the class and does not have a return type. It is invoked as part of object creation.

Q: What are the types of constructors?

We commonly discuss no-argument constructors, parameterized constructors, and compiler-provided default constructors.
Constructors can also be overloaded.

Q: Constructor vs method?

A constructor initializes an object and is invoked during object creation.
A method performs an operation and is normally called explicitly.

Q: Can constructors be overloaded?

Yes. We can define multiple constructors with different parameter lists.

Q: Can constructors be overridden?

No. Constructors are not inherited, so they cannot be overridden.

Q: Can a constructor be private?

Yes. A private constructor can restrict object creation from outside the class and is commonly used in
patterns such as Singleton.

Q: What happens if we don't create a constructor?

The compiler can provide a default no-argument constructor, which implicitly invokes the accessible
no-argument constructor of the superclass.

Q: What happens if we create a parameterized constructor but don't create a no-argument constructor?

A no-argument constructor will not be automatically provided by the compiler. Therefore, new ClassName()
will result in a compilation error unless we explicitly define a no-argument constructor.

Q: What is the difference between this() and super()?

this() calls another constructor in the same class, while super() calls a constructor of the parent class.

Q: Where should this() and super() appear?

If used inside a constructor, this() or super() must be the first statement. You cannot use both as constructor
calls in the same constructor.

One sentence to remember

"A constructor is used to initialize an object, has the same name as the class, has no return type, is invoked
during object creation, can be overloaded but cannot be overridden."
     */
}
