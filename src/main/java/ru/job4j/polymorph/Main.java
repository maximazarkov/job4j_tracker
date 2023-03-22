package ru.job4j.polymorph;

public class Main {
    public static void main(String[] args) {
        Vehicle townCar = new TownCar();
        townCar.changeGear();
        townCar.accelerate();
        townCar.steer();
        townCar.brake();

        Vehicle sportCar = new SportCar();
        sportCar.changeGear();
        sportCar.accelerate();
        sportCar.steer();
        sportCar.brake();

        System.out.println("---");
        SportCar sportCar2 = new SportCar();
        Vehicle vehicle = sportCar2;
        Fuel fuel = sportCar2;
        vehicle.changeGear();
        vehicle.accelerate();
        vehicle.steer();
        vehicle.brake();
        fuel.refill();
    }
}
