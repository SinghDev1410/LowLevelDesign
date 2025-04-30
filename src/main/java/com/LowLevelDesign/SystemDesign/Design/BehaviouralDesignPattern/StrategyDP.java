package com.LowLevelDesign.SystemDesign.Design.BehaviouralDesignPattern;

public class StrategyDP {
    public static void main(String[] args) {
        Vehicle vehicle = new SprotVechicle();
        vehicle.drive();

        Vehicle vehicle1 = new OffRoadVechile();
        vehicle1.drive();
    }
}

class Vehicle{
    DriveStrategy driveStrategy;

    // this is know as constructor injection
    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }
}

class OffRoadVechile extends Vehicle{

    OffRoadVechile(){
        super(new OffRoadDriveStrategy());
    }
}

class SprotVechicle extends Vehicle{
   SprotVechicle(){
       super(new SportDriveStrategy());
   }
}



interface DriveStrategy{
    public void drive();
}

class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal drive capability");
    }
}

class OffRoadDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Off-Road drive capability");
    }
}

class SportDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Sport drive capability");
    }
}