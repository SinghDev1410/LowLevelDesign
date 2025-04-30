package com.LowLevelDesign.SystemDesign.Design.CreationalPattern.Factory;

public class EmployMain {
    public static void main(String[] args) {
        Salary salary = EmployeFactory.getSalary("Java Dev");
        System.out.println(salary.amount());

        Salary salary1 = EmployeFactory.getSalary("Mern Dev");
        System.out.println(salary1.amount());
    }
}

class EmployeFactory {

    public static Salary getSalary(String employe){
        if(employe.trim().equalsIgnoreCase("Java Dev")){
            return new JavaDev();
        } else if (employe.trim().equalsIgnoreCase("Mern Dev")) {
            return new MernDev();
        }
        else return null;
    }
}

class JavaDev implements Salary{

    @Override
    public int amount() {
        System.out.println("Java developer Salary");
        return 80000;
    }
}


class MernDev implements Salary{
    @Override
    public int amount() {
        System.out.println("WEB DEV Salary " );
        return 60000;

    }
}




interface Salary {

    int amount();
}
