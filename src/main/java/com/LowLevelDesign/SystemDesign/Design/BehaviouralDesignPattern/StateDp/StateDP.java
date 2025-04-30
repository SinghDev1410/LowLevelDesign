//
//import java.util.List;
//
//public class StateDP {
//    public static void main(String[] args) {
//
//    }
//}
//
//interface State{
// public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
// public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;
// public void insertCoin(VendingMachine machine, Coin coin) throws Exception;
// public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;
// public int getChange(int returnChangeMoney) throws Exception;
// public void dispenseProduct(VendingMachine machine, int codeNumber) throws Exception;
// public List<Coin> refundFullMoney(VendingMachine machine) throws Exception;
// public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;
//
//}
//
//class SelectionState implements State{
//
//    public SelectionState() {
//        System.out.println("Currently Vending machine is in SelectionState");
//    }
//
//    @Override
//    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
//        throw new Exception("you can not click on insert coin button is Selection state");
//    }
//
//    @Override
//    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
//        return;
//    }
//
//    @Override
//    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
//        throw new Exception("you can not insert Coin Selection state");
//    }
//
//    @Override
//    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
//        // 1. get item of this codeNumber
//        Item item = machine.getInventory().getItem(codeNumber);
//
//        // 2. total amount paid by user
//        int paidbyUser = 0;
//        for(Coin coin : machine.getCoinList()){
//            paidByUser = paidbyUser + coin.value;
//        }
//
//        // #. Compare product price and amount paid by user
//        if(paidbyUser < item.getPrice()){
//            System.out.println("Insufficient Amount, Product you selection is for price " + item.getPrice() + "and you paid:" + paidbyUser);
//            refundFullMoney(machine);
//            throw new Exception("Insufficient amount");
//        }
//        else if (paidbyUser >= item.getPrice()){
//            if(paidbyUser > item.getPrice()){
//                getChange(paidbyUser-item.getPrice());
//            }
//            machine.setVendingMachineState(new DispenseState(machine,codeNumber));
//        }
//    }
//
//    @Override
//    public int getChange(int returnChangeMoney) throws Exception {
//        // actual logic should be to return COINs in the dispense tray, but for simplicity i am just returning the amount to be refunded
//        System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
//        return returnChangeMoney;
//    }
//
//    @Override
//    public void dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
//        throw new Exception("product can not be dispensed Selection state");
//    }
//
//    @Override
//    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
//        System.out.println("Returned the full amount back in the Coin Dispenser Tra");
//        machine.setVendingMachineState(new IdleState(machine));
//        return machine.getCoinList();
//    }
//
//    @Override
//    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
//        throw new Exception("Inventory can not be updated in selection state");
//    }
//}
//
//
//class DispenseState{}
//
//class HasMoneyState implements State{
//
//    public HasMoneyState() {
//        System.out.println("currently Vending machine is in HasMoneyState");
//    }
//
//    @Override
//    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
//        return;
//    }
//
//    @Override
//    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
//        machine.setVendingMachine(new SelectionState());
//    }
//
//    @Override
//    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
//        System.out.println("Accepted the coin");
//        machine.getCoinList().add(coin);
//    }
//
//    @Override
//    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
//        throw new Exception("you need to click on start product selection button first");
//    }
//
//    @Override
//    public int getChange(int returnChangeMoney) throws Exception {
//        throw new Exception("you can not get change in hasMoney State");
//    }
//
//    @Override
//    public void dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
//        throw new Exception("product can not be dispensed in hasMoney State");
//    }
//
//    @Override
//    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
//        System.out.println("Returned the full amount back in the Coin Dispense Tray");
//        machine.setVendingMachineState(new IdleState(machine));
//        return machine.getCoinList();
//    }
//
//    @Override
//    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
// throw new Exception("you can not update inventory in hasMoney state");
//    }
//}
//
//class IdleState implements State{
//
//    IdleState(){
//        System.out.println("Currently Vending machine is in IdleState");
//    }
//
//    @Override
//    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
//    }
//
//    @Override
//    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
//        throw new Exception("First you need to click on insert coin button");
//    }
//
//    @Override
//    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
//        throw new Exception("you can not choose Product in Idle state");
//    }
//
//    @Override
//    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
//        throw new Exception("you can not choose Product in Idle state");
//    }
//
//    @Override
//    public int getChange(int returnChangeMoney) throws Exception {
//        throw new Exception("you can not get change in Idle state");
//    }
//
//    @Override
//    public void dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
//        throw new Exception("product can not be dispensed Idle state");
//    }
//
//    @Override
//    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
//        throw new Exception("you can not refunde in Idle state");
//    }
//
//    @Override
//    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
//
//    }
//}
//
//class Coin{}
//class Inventory{}
//class Item{}
//class ItemShelf{}
//class ItemType{}
//class VendingMachine{}