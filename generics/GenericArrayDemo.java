package generics;

class GenericArray<T> {
    private T[] elems;
    GenericArray(T[] e) {
        elems = e;
    }
    @SuppressWarnings("unchecked") 
    GenericArray(int cap) {
        elems = (T[]) new Object[cap];
    }

    public void set(int index, T element) {
        if (elems == null || index < 0 || index >= elems.length)
            throw new IndexOutOfBoundsException();
        elems[index] = element;
    }

    public T get(int index) {
        if (elems == null || index < 0 || index >= elems.length)
            throw new IndexOutOfBoundsException();
        return elems[index];
    }

    public String toString() {
        if (elems == null)
            return "[]";
        String res = "";
        for (int i = 0; i < elems.length; i++) {
            if (i != 0)
                res += " ";
            res += elems[i];
        }
        return "[" + res + "]";
    }
}

public class GenericArrayDemo {
    public static void main(String[] args) {
        GenericArray<String> a = new GenericArray<>(10);
        a.set(1, "element-1");
        a.set(3, "no-null-value-lol");
        System.out.println(a); 
    }
}
