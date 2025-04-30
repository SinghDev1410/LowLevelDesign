package com.LowLevelDesign.SystemDesign.Design.Structure_Design_Pattern.BrIdge_Dp;

public class Bridge_Dp {
    public static void main(String[] args) {

    }
}

abstract class LivingThings{
    BreatheeImplementor breatheeImplementor;

    LivingThings(BreatheeImplementor breatheeImplementor){
        this.breatheeImplementor = breatheeImplementor;
    }
    abstract public void breatheProcess();
}

class Dog extends LivingThings{

    public Dog(BreatheeImplementor breatheeImplementor) {
        super(breatheeImplementor);
    }

    @Override
    public void breatheProcess() {
        breatheeImplementor.breathe();
    }
}


interface BreatheeImplementor{
    public void breathe();
}

class LandBreathe implements BreatheeImplementor{

    @Override
    public void breathe() {

    }
}

class WaterBreathe implements BreatheeImplementor{

    @Override
    public void breathe() {

    }
}

class TreeBreathe implements BreatheeImplementor{

    @Override
    public void breathe() {

    }
}