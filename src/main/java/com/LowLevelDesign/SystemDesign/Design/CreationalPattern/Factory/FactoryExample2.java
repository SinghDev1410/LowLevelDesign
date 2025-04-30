package com.LowLevelDesign.SystemDesign.Design.CreationalPattern.Factory;

public class FactoryExample2 {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape("Circle");
        System.out.println(shape.type());

        Shape shape1 = ShapeFactory.getShape("Rectangle");
        System.out.println(shape1.type());
    }
}

class ShapeFactory {

    public static Shape getShape(String type){
        if(type.trim().equalsIgnoreCase("Circle")){
            return new circle();
        } else if (type.trim().equalsIgnoreCase("Rectangle")) {
            return new rectangle();
        }
        else if (type.trim().equalsIgnoreCase("squre")){
            return new square();
        }
        else return null;
    }
}

class circle implements Shape{

    @Override
    public String type() {
        return "shape is circle";
    }
}

class rectangle implements Shape{

    @Override
    public String type() {
        return "shape is Rectangle";
    }
}

class square implements Shape{

    @Override
    public String type() {
        return "shape is Square";
    }
}

interface Shape{
    String type();
}
