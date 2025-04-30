package com.LowLevelDesign.SystemDesign.Design.CreationalPattern.Builder.Car;

class CarManifacture {
    public static void main(String[] args) {

        Car.CarBuilder builder = new Car.CarBuilder();
        Car.CarBuilder builder1 = new Car.CarBuilder();
        Car car = builder.Engine("V5")
                .Color("Red")
                .Seats(4)
                .Sunroof(true)
                .navigationSystem(true)
                .build();



        Car car1 = builder1.Engine("V5")
                .Sunroof(true)
                .build();

        System.out.println(car1);
        System.out.println(car);
    }
}

class Car {
    String engine;
    int wheels;
    int seats;
    String color;
    boolean sunroof;
    boolean navigationSystem;

    Car(CarBuilder builder){
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.seats = builder.seats;
        this.color = builder.color;
        this.sunroof = builder.sunroof;
        this.navigationSystem = builder.navigationSystem;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels=" + wheels +
                ", seats=" + seats +
                ", color='" + color + '\'' +
                ", sunroof=" + sunroof +
                ", navigationSystem=" + navigationSystem +
                '}';
    }

    static class CarBuilder{
        String engine;
        int wheels = 4;
        int seats = 5;
        String color = "Black";
        boolean sunroof = false;
        boolean navigationSystem = false;

        CarBuilder Engine(String engine){
            this.engine = engine;
            return this;
        }

        CarBuilder Wheels(int wheels){
            this.wheels = wheels;
            return this;
        }

        CarBuilder Seats(int seats){
            this.seats = seats;
            return this;
        }

        CarBuilder Color(String color){
            this.color = color;
            return this;
        }

        CarBuilder Sunroof(boolean sunroof){
            this.sunroof = sunroof;
            return this;
        }

        CarBuilder navigationSystem(boolean navigationSystem){
            this.navigationSystem = navigationSystem;
            return this;
        }

        Car build(){
            return new Car(this);
        }

    }

}



