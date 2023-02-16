package generics;

class Pair<Key, Value> {
    private Key key;
    private Value value;

    public Pair(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
    
    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String toString() {
        return "(" + key + ": " + value + ")";
    }
}

public class GenericPairDemo {
    public static void main(String[] args) {
        var pair1 = new Pair<String, Integer>("one", 1);
        var pair2 = new Pair<String, Integer>("two", 2);

        System.out.println(pair1 + ", " + pair2);
    }
}
