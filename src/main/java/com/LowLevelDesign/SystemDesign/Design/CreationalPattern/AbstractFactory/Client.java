package com.LowLevelDesign.SystemDesign.Design.CreationalPattern.AbstractFactory;

public class Client {
    public static void main(String[] args) {
        Employe employe = EmployeFactory.getEmploye(new AndroidDevFactory());
        System.out.println(employe.name() + " and Salary is " + employe.salary());

        Employe employe1 = EmployeFactory.getEmploye(new WebDevFactory());
        System.out.println(employe1.name() +"and salary is "+ employe1.salary());
    }
}

interface Employe {
    int salary();
    String name();
}

class EmployeFactory {
    public static Employe getEmploye(AbstactEmploye abstactEmploye){
        return abstactEmploye.createEmploye();
    }
}

abstract  class AbstactEmploye {
    public abstract Employe createEmploye();
}

class WebDev implements Employe{

    @Override
    public int salary() {
        return 80000;
    }

    @Override
    public String name() {
        return "I am web developer";
    }
}

class WebDevFactory extends AbstactEmploye{

    @Override
    public Employe createEmploye() {
        return new WebDev();
    }
}
class AndroidDevFactory extends AbstactEmploye {

    @Override
    public Employe createEmploye() {
        return new AndroidDev();
    }
}

class AndroidDev implements Employe {
    @Override
    public int salary() {
        return 100000;
    }

    @Override
    public String name() {
        return "I am android developer";
    }
}
