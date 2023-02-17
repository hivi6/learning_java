package generics;

// single bound
class Box<T extends Number> {
}

public class BoundedTypeParameter {
    public static void main(String[] args) {
        // Box<String> s = new Box<String>(); // This is not valid because String doesnot extends Number
        Box<Integer> a = new Box<>(); // This is valid
    }
}