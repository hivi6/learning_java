package interfaces;

interface TestInterface {
    public void testFunction();
}

public class AnonymousClassDemo {
    public static void main(String[] args) {
        var example = new TestInterface() {
            public void testFunction() {
                System.out.println("This is an anonymous class that implements the TestInterface");
            }
        };
        example.testFunction();
    }
}
