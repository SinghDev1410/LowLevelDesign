package WopiHostApplication.File.Structure_Dp.DecoratorDP;

public class DecoratorDP {
    public static void main(String[] args) {
        basePizza basePizza = new onionPizza();
        System.out.println("cost of onionPizza  "+basePizza.cost());

        basePizza = new cheessToping(basePizza);
        System.out.println("cost of onionPizza + cheessTopping "+basePizza.cost());

        basePizza = new OlliveToping(basePizza);
        System.out.println("cost of onionPizza + cheessTopping + OlliveTopping "+basePizza.cost());
    }
}

interface basePizza{
    double cost();
}

class onionPizza implements basePizza {

    @Override
    public double cost() {
        return 100;
    }
}

class cornPizza implements basePizza {

    @Override
    public double cost() {
        return 80;
    }
}

class mashromPizza implements basePizza {

    @Override
    public double cost() {
        return 250;
    }
}

abstract class PizzaDecorater implements basePizza{
    basePizza basePizza;

    PizzaDecorater(basePizza basePizza){
        this.basePizza=basePizza;
    }

    public double cost(){
        return basePizza.cost();
    }
}

class cheessToping extends PizzaDecorater{

    public cheessToping(basePizza basePizza){
        super(basePizza);
    }

    @Override
    public double cost() {
        return basePizza.cost() + 20;
    }
}

class OlliveToping extends PizzaDecorater{

    public OlliveToping(basePizza basePizza){
        super(basePizza);
    }

    @Override
    public double cost() {
//        System.out.println("Ollive topping");
        return basePizza.cost() + 30;
    }
}

class ExtracheessToping extends PizzaDecorater{

    public ExtracheessToping(basePizza basePizza){
        super(basePizza);
    }

    @Override
    public double cost() {
        return basePizza.cost() + 40;
    }
}