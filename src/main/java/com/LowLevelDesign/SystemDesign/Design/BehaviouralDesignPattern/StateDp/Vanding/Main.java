package com.LowLevelDesign.SystemDesign.Design.BehaviouralDesignPattern.StateDp.Vanding;

/*
        Vending Machine Example with the State Pattern:**

        Problem:

        We want to model a **Vending Machine**. It can be in different states, such as:

        Idle : Waiting for a user to insert money.
        HasMoney: Money has been inserted, and it’s waiting for a selection.
        Sold**: A product is dispensed, and the machine resets to idle.

*/

interface VendingMachineState{
    void insertMoney();
    void selectProduct();
    void dispenseProduct();
}

// Concret Class

class IdleState implements VendingMachineState{

    VendingMachine vendingMachine;

    IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Money inserted");
        vendingMachine.setState(vendingMachine.getHasMoneyState());
    }

    @Override
    public void selectProduct() {
        System.out.println("Insert money first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Insert money and select a product first");
    }
}


class HasMoneyState implements VendingMachineState{

    VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertMoney() {
        System.out.println("Money already insert");
    }

    @Override
    public void selectProduct() {
        System.out.println("Product selected");
        vendingMachine.setState(vendingMachine.getSoldState());

    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select a product first.");
    }
}

class SoldState implements VendingMachineState{
    VendingMachine vendingMachine;

    public SoldState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertMoney() {
        System.out.println("Please wait, we're dispensing the product.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Please wait, we're dispensing the product.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Dispensing product...");
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}


class VendingMachine{
    private VendingMachineState idleState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState soldState;

    private VendingMachineState currentState;

    public VendingMachine(){
        idleState = new IdleState(this);
        hasMoneyState = new HasMoneyState(this);
        soldState = new SoldState(this);

        currentState = idleState;
    }

    public void setState(VendingMachineState state){
        this.currentState = state;
    }
    public void insertMoney(){
        currentState.insertMoney();
    }
    public void selectProduct(){
        currentState.selectProduct();
    }
    public void dispenseProduct(){
        currentState.dispenseProduct();
    }

    public VendingMachineState getIdleState() {
        return  idleState;
    }
    public VendingMachineState getHasMoneyState() {
        return hasMoneyState;
    }

    public VendingMachineState getSoldState() {
        return  soldState;
    }

}



public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.insertMoney();
        vendingMachine.selectProduct();
        vendingMachine.dispenseProduct();
    }
}

