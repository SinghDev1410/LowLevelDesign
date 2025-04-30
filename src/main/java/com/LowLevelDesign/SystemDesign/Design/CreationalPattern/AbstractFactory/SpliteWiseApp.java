package com.LowLevelDesign.SystemDesign.Design.CreationalPattern.AbstractFactory;

import java.util.Arrays;
import java.util.List;

public class SpliteWiseApp {
    public static void main(String[] args) {

        SplitFactory factory = new ExertSplitFactory();
        ExpenseService service = new ExpenseService(factory);
        List<Double> contribution  = Arrays.asList(100.0,200.0,300.0);

        service.executeSplit(contribution);

    }
}

class ExpenseService{
    Split split;
    SpliteCalculator spliteCalculator;


    public ExpenseService(SplitFactory factory) {
        split = factory.createSplit();
        spliteCalculator = factory.createCalculator();
    }

    void executeSplit(List<Double> contribute){
        split.computeSplit();
        spliteCalculator.calulate(contribute);
    }
}

// ===============>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


class EqualSplitFactory implements SplitFactory{
    @Override
    public Split createSplit() {
        return new EqualSplit();
    }

    @Override
    public SpliteCalculator createCalculator() {
        return new EqualSplitCalculator();
    }
}
class ExertSplitFactory implements SplitFactory{

    @Override
    public Split createSplit() {
        return new ExertSplit();
    }

    @Override
    public SpliteCalculator createCalculator() {
        return new ExertSplitCalculator();
    }
}

class PercentageSplitFactory implements SplitFactory{
    @Override
    public Split createSplit() {
        return new PercentageSplit();
    }

    @Override
    public SpliteCalculator  createCalculator() {
        return new PercentageSplitCalculator();
    }
}


// ===========================>>>>>>>>>>

interface SplitFactory{
    Split createSplit();
    SpliteCalculator createCalculator();
}





// ===================>
// CONCRET PRODUCT


class EqualSplit implements Split {
    @Override
    public void computeSplit() {
        System.out.println("Splitting equally.");
    }
}

class EqualSplitCalculator implements SpliteCalculator {
    @Override
    public void calulate(List<Double> contributions) {
        System.out.println("Calculating equal splits...");
    }
}
class ExertSplit implements Split {
    @Override
    public void computeSplit() {
        System.out.println("Splitting with exact amounts.");
    }
}
class ExertSplitCalculator implements SpliteCalculator {

    @Override
    public void calulate(List<Double> contributions) {
        System.out.println("Calculating exact amount splits...");
    }
}
class PercentageSplit implements Split {
    @Override
    public void computeSplit() {
        System.out.println("Splitting with percentages.");
    }
}
class PercentageSplitCalculator implements SpliteCalculator {
    @Override
    public void calulate(List<Double> contributions) {
        System.out.println("Calculating percentage-based splits...");
    }
}



// ABSTRACT PRODUCT

interface Split {
    void computeSplit();
}

interface SpliteCalculator{
    void calulate(List<Double> contributions);
}