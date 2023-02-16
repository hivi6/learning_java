package interfaces;

interface Interface1 {
    default void exampleFunc() {
        System.out.println("Inside Interface1");
    }
}

interface Interface2 extends Interface1 {
    default void exampleFunc() {
        System.out.println("Inside Interface2");         
    }
}

interface Interface3 extends Interface1 {
    default void exampleFunc() {
        System.out.println("Inside Interface3");         
    }
}

interface Interface4 extends Interface2, Interface3 {
    // error if the function exampleFunc() is not overriden
    default void exampleFunc() {
        // can call any one of the Interface's exampleFunc like this
        // Interface2.super.exampleFunc();
        // Interface3.super.exampleFunc();
        // or can rewrite your own
        System.out.println("Inside Interface4");
    }
}

public class diamondProblem implements Interface4 {
    public static void main(String[] args) {
        diamondProblem d = new diamondProblem();
        d.exampleFunc();
    }
}
