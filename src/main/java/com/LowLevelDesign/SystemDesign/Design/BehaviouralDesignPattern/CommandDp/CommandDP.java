package com.LowLevelDesign.SystemDesign.Design.BehaviouralDesignPattern.CommandDp;

public class CommandDP {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        MyRemoteControl myRemoteControl = new MyRemoteControl();

        myRemoteControl.setiCommand(new TurnAcOnCommand(airConditioner));
        myRemoteControl.pressButton();
    }
}

class MyRemoteControl {
    ICommand iCommand;

    MyRemoteControl() {
    }

    public void setiCommand(ICommand iCommand) {
        this.iCommand = iCommand;
    }

    public void pressButton() {
        iCommand.execute();
    }
}

interface ICommand {
    public void execute();
}

class TurnAcOnCommand implements ICommand {
    AirConditioner airConditioner;

    TurnAcOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOnAc();
    }
}

class TurnOffOnCommand implements ICommand {

    AirConditioner airConditioner;
    TurnOffOnCommand(AirConditioner airConditioner){
        this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {
        airConditioner.turnOffAc();
    }
}

class AirConditioner {
    boolean isOn;
    int temperature;

    public void turnOnAc() {
        isOn = true;
        System.out.println("Ac is On");
    }

    public void turnOffAc() {
        isOn = false;
        System.out.println("Ac is On");
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Temperature changed to : " + temperature);
    }
}
