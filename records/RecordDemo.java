package records;

import java.util.List;

record Point(int x, int y) {
    public int x() {
        System.out.println("Inside x()");
        return this.x;
    }
}

record Range(int start, int end) {
    // public Range {
    //     if (end <= start) {
    //         throw new IllegalArgumentException("End cannot be lesser than start");
    //     }
    // }

    public Range(int start, int end)
    {
        if (end <= start) {
            throw new IllegalArgumentException("End cannot be lesser than start.");
        }
        this.start = start < 0 ? 0 : start;            
        this.end = end > 100 ? 10 : end;
    }
}

record State(String name, String capitalCity, List<String> cities) {
    public State {
        cities = List.copyOf(cities);
    }

    public State(String name, String capitalCity) {
        this(name, capitalCity, List.of());
    }

    public State(String name, String capitalCity, String... cities) {
        this(name, capitalCity, List.of(cities));
    }

    public List<String> cities() {
        return List.copyOf(cities);
    }
}

public class RecordDemo {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        System.out.println(p.x() + " " + p.y());

        // custom record Constructor
        // Range r1 = new Range(10, 2);
        Range r2 = new Range(-21, 1022);
        System.out.println(r2.start() + " " + r2.end());

        // create different cities
        State s1 = new State("Assam", "Dispur", "Guwahati", "Dibrugarh");
        System.out.println(s1);
    }
}
