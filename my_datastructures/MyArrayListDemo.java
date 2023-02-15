package my_datastructures;

class MyArrayList {
    // ===== members
    private int cap; // capacity of the array list
    private int len; // actual length of the array list
    private Integer[] elems; // container keeping the elements

    // ===== functions
    public MyArrayList() {
        cap = len = 0;
        elems = null;
    }

    public MyArrayList(int initialCapacity) {
        cap = initialCapacity;
        len = 0;
        elems = new Integer[cap];
    }

    public MyArrayList(Integer[] elements) {
        if (elements == null) {
            cap = len = 0;
            elems = null;
            return;
        }
        cap = len = elements.length;
        elems = new Integer[cap];
        for (int i = 0; i < len; i++)
            elems[i] = elements[i];
    }

    // ===== methods
    public void trimToSize() {
        cap = len;
        var oldElems = elems;
        elems = new Integer[cap];
        for (int i = 0; i < cap; i++)
            elems[i] = oldElems[i];
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity < cap)
            return;
        cap = minCapacity;
        var oldElems = elems;
        elems = new Integer[cap];
        for (int i = 0; i < len; i++)
            elems[i] = oldElems[i];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean contains(Object obj) {
        for (int i = 0; i < len; i++)
            if (obj == null ? elems[i] == null : obj.equals(elems[i]))
                return true;
        return false;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++)
            if (obj == null ? elems[i] == null : obj.equals(elems[i]))
                return i;
        return -1;
    }

    public int lastIndexOf(Object obj) {
        for (int i = len - 1; i >= 0; i--)
            if (obj == null ? elems[i] == null : obj.equals(elems[i]))
                return i;
        return -1;
    }

    public Object clone() {
        MyArrayList res = new MyArrayList();
        res.elems = elems;
        res.cap = cap;
        res.len = len;
        return res;
    }

    public Object[] toArray() {
        if (len == 0)
            return null;
        Integer[] res = new Integer[len];
        for (int i = 0; i < len; i++)
            res[i] = elems[i].intValue();
        return res;
    }

    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return elems[index];
    }

    public Integer set(int index, Integer element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        elems[index] = element;
        return element;
    }

    public boolean add(Integer element) {
        if (len + 1 > cap) {
            ensureCapacity((len + 1) * 2);
        }
        elems[len] = element;
        len++;
        return true;
    }

    public void add(int index, Integer element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        if (len + 1 > cap) {
            ensureCapacity((len + 1) * 2);
        }
        // shift the elements
        for (int i = len - 1; i >= index; i++)
            elems[i + 1] = elems[i];
        elems[index] = element;
        len++;
    }

    public Integer remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        var res = elems[index];
        for (int i = index; i < len - 1; i++)
            elems[i] = elems[i + 1];
        len--;
        return res;
    }

    public boolean remove(Object obj) {
        var index = indexOf(obj);
        if (index == -1)
            return false;
        remove(index);
        return true;
    }

    public void clear() {
        cap = len = 0;
        elems = null;
    }

    public boolean addAll(MyArrayList list) {
        if (list == null)
            throw new NullPointerException();
        ensureCapacity(len + list.len);
        for (int i = 0; i < list.len; i++)
            add(list.elems[i]);
        return !list.isEmpty();
    }

    public boolean addAll(int index, MyArrayList list) throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        if (list == null)
            throw new NullPointerException();
        ensureCapacity(len + list.len);
        int i = len + list.len - 1;
        while (i >= index + list.len) {
            elems[i] = elems[i - list.len];
            i--;
        }
        for (int j = index; j < index + list.len; j++)
            elems[j] = list.elems[j - index];
        len += list.len;
        return !list.isEmpty();
    }

    protected void removeRange(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        if (fromIndex < 0 || fromIndex >= size() || toIndex > size() || toIndex < fromIndex)
            throw new IndexOutOfBoundsException();
        // [1, 2, 3, 4, 5, 6]
        // (1, 3) remove
        // [1, 4, 5, 6]
        for (int i = toIndex; i < len; i++)
            elems[i - (toIndex - fromIndex)] = elems[i];
        len -= (toIndex - fromIndex);
    }

    private void mergeSort(int start, int end) {
        // both start and end inclusive
        if (start >= end)
            return;
        if (start < end) {
            var mid = start + (end - start) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            // merge
            Integer[] left = new Integer[mid - start + 1];
            Integer[] right = new Integer[end - mid];
            for (int i = start; i <= mid; i++)
                left[i - start] = elems[i];
            for (int i = mid + 1; i <= end; i++)
                right[i - mid - 1] = elems[i];
            int i = 0, j = 0, k = start;
            while (i < (mid - start + 1) && j < (end - mid)) {
                if (left[i] <= right[j])
                    elems[k++] = left[i++];
                else
                    elems[k++] = right[j++];
            }
            while (i < (mid - start + 1))
                elems[k++] = left[i++];
            while (j < (end - mid))
                elems[k++] = right[j++];
        }
    }

    public void sort() {
        mergeSort(0, size() - 1);
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < len; i++) {
            if (i != 0)
                res += " ";
            res += elems[i];
        }
        return "[" + res + "]";
    }
}

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList a = new MyArrayList();
        a.add(5);
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(1);
        System.out.println(a);
        a.sort();
        System.out.println(a);
        a.removeRange(0, a.size());
        System.out.println(a);
    }
}
