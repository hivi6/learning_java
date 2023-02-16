package language_basics;

public class VarLenFunction {
    static public void varLenIntPrint(int... a) {
        for (var x: a)
            System.out.print(x + " ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        varLenIntPrint();
        varLenIntPrint(1);
        varLenIntPrint(1, 2, 3, 4);
        
    }
}
