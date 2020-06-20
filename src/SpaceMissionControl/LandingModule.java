package SpaceMissionControl;

import java.util.ArrayList;

public class LandingModule extends ServiceModule{

    private static final long serialVersionUID = 1L;

    static ArrayList<LandingModule> landingModulesList = new ArrayList<>();

    int landCrewAmound;
    int maxCargoMass;
    int maxFuel;

    private LandingModule (String serialNumber, int ownMass, int landCrewAmound, int maxCargoMass, int maxFuel){
        super(serialNumber,ownMass);

        this.landCrewAmound = landCrewAmound;
        this.maxCargoMass = maxCargoMass;
        if(maxFuel == 0){throw new NullPointerException("Max Fuel not given.");}
        this.maxFuel = maxFuel;
    }

    public static void createLandCrewAmound(String serialNumber, int ownMass, int landCrewAmound, int maxCargoMass, int maxFuel){
        landingModulesList.add(new LandingModule(serialNumber, ownMass, landCrewAmound, maxCargoMass, maxFuel));
    }

    public int getMaxCargoMass() {
        return maxCargoMass;
    }

    public int getMaxFuel() {
        return maxFuel;
    }
}
