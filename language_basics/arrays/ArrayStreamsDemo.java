package language_basics.arrays;

public class ArrayStreamsDemo {
    public static void main(String[] args) {
        String[] copyFrom = {
                "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado", "Doppio", "Espresso", "Frappucino",
                "Freddo", "Lungo", "Macchiato", "Marocchino", "Ristretto"
        };
        java.util.Arrays.stream(copyFrom).map(coffee -> coffee + " ").forEach(System.out::print);
    }
}
