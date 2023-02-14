package oop;

public class BicycleDemo {
    public static void main(String[] args) {
        // Create two different bicycle
        Bicycle b1 = new Bicycle();
        Bicycle b2 = new Bicycle();

        // invoke methods
        b1.changeCadence(10);
        b1.speedUp(10);
        b1.changeGear(2);
        b1.printStates();

        b2.changeCadence(50);
        b2.speedUp(10);
        b2.changeGear(2);
        b2.changeCadence(40);
        b2.speedUp(10);
        b2.changeGear(3);
        b2.printStates();
    }
}
