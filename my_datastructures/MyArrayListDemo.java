package my_datastructures;

class MyArrayList {
    // ===== members
    private int cap; // capacity of the array list
    private int len; // actual length of the array list
    private int[] elems; // container keeping the elements

    // ===== functions
    public MyArrayList() {
        cap = len = 0;
        elems = null;
    }

    public MyArrayList(int initialCapacity) {
        cap = initialCapacity;
        len = 0;
        elems = new int[cap];
    }

    public MyArrayList(int[] elements) {
        if (elements == null) {
            cap = len = 0;
            elems = null;
            return;
        }
        cap = len = elements.length;
        elems = new int[cap];
        for (int i = 0; i < len; i++)
            elems[i] = elements[i];
    }

    // ===== methods
    public boolean add(int element) {
        if (len + 1 > cap) {
            var oldCap = cap;
            var oldElems = elems;
            cap = (len + 1) * 2;
            elems = new int[cap];
            for (int i = 0; i < oldCap; i++)
                elems[i] = oldElems[i];
        }
        elems[len] = element;
        len++;
        return true;
    }

    // for debugging purposes
    void debugPrint() {
        System.out.println("len: " + len);
        System.out.println("cap: " + cap);
        System.out.print("elems: [");
        for (int i = 0; i < len; i++) {
            if (i != 0) System.out.print(" ");
            System.out.print(elems[i]);
        }
        System.out.println("]");
    }
}

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList a = new MyArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);

        a.add(10, 122);
        a.debugPrint();
    }
}
