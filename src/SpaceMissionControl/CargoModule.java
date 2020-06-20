package SpaceMissionControl;

import java.util.ArrayList;

public class CargoModule extends ServiceModule {

    private static final long serialVersionUID = 1L;

    static ArrayList<CargoModule> cargoModulesList = new ArrayList<>();



    int maxCargoMass;
    int maxFuel;

    private CargoModule(String serialNumber, int ownMass, int maxCargoMass, int maxFuel) {
        super(serialNumber, ownMass);
        this.maxCargoMass = maxCargoMass;
        this.maxFuel = maxFuel;
    }

    public static void createCargoModule(String serialNumber, int ownMass, int maxCargoMass, int maxFuel){
        cargoModulesList.add(new CargoModule(serialNumber, ownMass, maxCargoMass,maxFuel));
    }

    public int getMaxCargoMass(){
        return maxCargoMass;
    }

    public int getMaxFuel(){
        return maxFuel;
    }

}

