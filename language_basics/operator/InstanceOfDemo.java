package language_basics.operator;

class Parent {}
interface MyInterface {}
class Child extends Parent implements MyInterface {}

public class InstanceOfDemo {
    public static void main(String[] args) {
        Parent ob1 = new Parent();
        Parent ob2 = new Child();

        System.out.println("ob1 instanceof Parent: " + (ob1 instanceof Parent));
        System.out.println("ob1 instanceof Child: " + (ob1 instanceof Child));
        System.out.println("ob1 instanceof MyInterface: " + (ob1 instanceof MyInterface));

        System.out.println("ob2 instanceof Parent: " + (ob2 instanceof Parent));
        System.out.println("ob2 instanceof Child: " + (ob2 instanceof Child));
        System.out.println("ob2 instanceof MyInterface: " + (ob2 instanceof MyInterface));
    }
}
