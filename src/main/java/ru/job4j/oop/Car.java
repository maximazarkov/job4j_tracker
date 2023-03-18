package ru.job4j.oop;

public class Car {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Двигатель запущен");
    }

    public class Transmission {
        public void accelerate() {
            System.out.println("Ускорение");
        }
    }

    public class Brakes {
        public void brake() {
            System.out.println("Торможение");
        }
    }

    public static class TripComputerStatic {

        public static TripComputer getTripComputer() {
            Car car = new Car("Марка", "Модель");
            Car.TripComputer tripComputer = car.new TripComputer();
            return tripComputer;
        }
    }

    public class TripComputer {
        private String tripData = "Бортовой компьютер";

        public void getInfo() {
            System.out.println("Модель TripComputer: " + this.tripData);
            System.out.println("Модель Car: " + Car.this.model);
            System.out.println("Марка: " + brand);
            System.out.println("Модель: " + model);
        }
    }
}
