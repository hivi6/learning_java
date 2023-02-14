package oop;

public class Bicycle {
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    void changeCadence(int newVal) {
        cadence = newVal;
    }

    void changeGear(int newVal) {
        gear = newVal;
    }

    void speedUp(int increment) {
        speed = speed + increment;
    }

    void applyBrakes(int decrement) {
        speed = speed - decrement;
    }

    void printStates() {
        System.out.println("cadence: " + cadence + " speed: " + speed + " gear: " + gear);
    }
}
