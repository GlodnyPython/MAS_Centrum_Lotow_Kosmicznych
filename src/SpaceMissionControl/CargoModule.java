package SpaceMissionControl;

import java.util.ArrayList;

public class CargoModule extends ServiceModule {

    private static final long serialVersionUID = 1L;

    static ArrayList<CargoModule> cargoModulesList = new ArrayList<>();



    int maxCargoMass;
    int maxFuel;

    /**
     * @param serialNumber
     * @param ownMass
     * @param maxCargoMass
     * @param maxFuel
     */
    private CargoModule(String serialNumber, int ownMass, int maxCargoMass, int maxFuel) {
        super(serialNumber, ownMass);
        this.maxCargoMass = maxCargoMass;
        this.maxFuel = maxFuel;
    }

    /**
     * @param serialNumber
     * @param ownMass
     * @param maxCargoMass
     * @param maxFuel
     */
    public static void createCargoModule(String serialNumber, int ownMass, int maxCargoMass, int maxFuel){
        cargoModulesList.add(new CargoModule(serialNumber, ownMass, maxCargoMass,maxFuel));
    }

    /**
     * @return Max cargo mass for this module
     */
    public int getMaxCargoMass(){
        return maxCargoMass;
    }

    /**
     * @return Max fuel mass carried by this module
     */
    public int getMaxFuel(){
        return maxFuel;
    }

}

