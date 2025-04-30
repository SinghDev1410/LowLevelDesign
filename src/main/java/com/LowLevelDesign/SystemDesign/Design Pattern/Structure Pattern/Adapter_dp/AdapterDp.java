package WopiHostApplication.File.Structure_Dp.Adapter_dp;

public class AdapterDp {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}

class WeightMachineForBabies implements WeightMachine{

    @Override
    public double getWeightInPound() {
        return 28;
    }
}

interface WeightMachineAdapter{
    public double getWeightInKg();
}

interface WeightMachine {
    public double getWeightInPound();
}


class WeightMachineAdapterImpl implements WeightMachineAdapter{

    WeightMachine weightMachine;
    WeightMachineAdapterImpl(WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {

        double weightInPound = weightMachine.getWeightInPound();
        // Convert it
        double weightInKg = weightInPound * .45;
        return weightInKg;
    }


}









































