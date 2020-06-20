package SpaceMissionControl;

import java.util.ArrayList;

public class SpaceCraft  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<SpaceCraft> spaceCraftsList = new ArrayList<>();

    String type;
    String name;
    String serialNumber;
    int ownMass;
    int crewAmount = 0;
    int maxOwnCargoMass;
    int maxOperationalFuel;

    private int serviceModulesOwnMass;
    private int serviceModulesMaxFuel;
    private int liftRocketsOwnMass;
    private int totalOwnMass;
    private int totalMaxCargoMass;
    private int maxLaunchMass;
    private int launchFuelLoad;


    ArrayList<LandingModule> landingModules = new ArrayList<>();
    ArrayList<CargoModule> cargoModules = new ArrayList<>();
    ArrayList<LiftRocket> liftRockets = new ArrayList<>();

    ArrayList<Mission> missions = new ArrayList<>();

    private SpaceCraft(String type, String name, String serialNumber, int ownMass, int crewAmount, int maxOwnCargoMass, int maxOperationalFuel, LiftRocket liftRocket){
        if(type == null){throw new NullPointerException("Type not provided.");}
        this.type = type;
        if(name == null){throw new NullPointerException("Name not provided.");}
        this.name = name;
        if(serialNumber == null){throw new NullPointerException("Serial number not provided.");}
        this.serialNumber = serialNumber;
        if(ownMass == 0){throw new NullPointerException("Own mass not provided.");}
        this.ownMass = ownMass;
        this.crewAmount = crewAmount;
        this.maxOwnCargoMass = maxOwnCargoMass;
        if(maxOperationalFuel == 0){throw new NullPointerException("Operational fuel not provided.");}
        this.maxOperationalFuel = maxOperationalFuel;
        if(liftRocket == null){throw new NullPointerException("Lift Rocket not assigned.");}
        addLiftRocket(liftRocket);
    }

    public static void createSpaceCraft(String type, String name, String serialNumber, int ownMass, int crewAmount, int maxOwnCargoMass, int maxOperationalFuel, LiftRocket liftRocket){
        spaceCraftsList.add(new SpaceCraft(type,name, serialNumber, ownMass, crewAmount, maxOwnCargoMass, maxOperationalFuel, liftRocket));

    }

    public static void createSpaceCraft(String type, String name, String serialNumber, int ownMass, int maxOwnCargoMass, int maxOperationalFuel, LiftRocket liftRocket){
        spaceCraftsList.add(new SpaceCraft(type,name, serialNumber, ownMass, 0, maxOwnCargoMass, maxOperationalFuel, liftRocket));
    }

    //ADDERS

    public void addLandingModule(LandingModule lm){
        landingModules.add(lm);
        lm.assignToSpacecraft(this);

        calcServiceModulesMaxFuel();
        calcServiceModulesOwnMass();
        calcTotalMaxCargoMass();
        calcTotalOwnMass();
    }

    public void addCargoModule(CargoModule cm){
        cargoModules.add(cm);
        cm.assignToSpacecraft(this);

        calcServiceModulesMaxFuel();
        calcServiceModulesOwnMass();
        calcTotalMaxCargoMass();
        calcTotalOwnMass();
    }

    public void addLiftRocket(LiftRocket lr){
        liftRockets.add(lr);
        lr.assignToSpacecraft(this);

        calcLaunchFuelLoad();
        calcLiftRocketsOwnMass();
        calcMaxLunchMass();
        calcTotalOwnMass();
    }

    //CALCULATORS

    public void calcServiceModulesOwnMass(){
        int smom = 0;

        for (LandingModule lm : landingModules){
            smom += lm.getOwnMass();
        }
        for (CargoModule cm : cargoModules){
            smom += cm.getOwnMass();
        }

        serviceModulesOwnMass = smom;
    }

    public void calcServiceModulesMaxFuel(){
        int ssmf= 0;

        for (LandingModule lm : landingModules){
            ssmf += lm.getMaxFuel();
        }
        for (CargoModule cm : cargoModules){
            ssmf += cm.getMaxFuel();
        }

        serviceModulesMaxFuel = ssmf;
    }


    public void calcLiftRocketsOwnMass(){
        int lrm = 0;

        lrm += launchFuelLoad;

        for (LiftRocket lr : liftRockets){
            lrm += lr.getOwnMass();
        }

        liftRocketsOwnMass = lrm;
    }

    public void calcTotalMaxCargoMass(){
        int tmcm = 0;

        tmcm += maxOwnCargoMass;
        for (LandingModule lm : landingModules){
            tmcm += lm.getMaxCargoMass();
        }
        for (CargoModule cm : cargoModules){
            tmcm += cm.getMaxCargoMass();
        }

        totalMaxCargoMass = tmcm;
    }

    public void calcMaxLunchMass(){
        int mlm = 0;

        for (LiftRocket lr : liftRockets){
            mlm += lr.getLiftMass();
        }

        maxLaunchMass = mlm;
    }

    public void calcLaunchFuelLoad(){
        int lfl = 0;

        for (LiftRocket lr : liftRockets){
            lfl += lr.getLunchFuelMass();
        }

        launchFuelLoad += lfl;
    }

    public void calcTotalOwnMass(){
        int tom = 0;

        tom += ownMass;
        tom += serviceModulesOwnMass;
        tom += liftRocketsOwnMass;

        totalOwnMass = tom;
    }

    //GETTERS

    public int getOwnMass(){
        return ownMass;
    }

    public int getTotalOwnMass() {
        return totalOwnMass;
    }

    public int getMaxOperationalFuelMass() {
        return maxOperationalFuel;
    }

    public int getServiceModulesFuelMass() {
        return serviceModulesMaxFuel;
    }

    public int getLiftFuelMass() {
        return launchFuelLoad;
    }

    public int getMaxLiftMass() {
        return maxLaunchMass;
    }

    public int getTotalMaxCargoMass() {
        return totalMaxCargoMass;
    }

    //ASSIGNER

    public void assignToMission(Mission mission){
        missions.add(mission);
    }

    public String toString(){
        String string = null;
        if (crewAmount > 0) {
            string = "Crew space craft: " + name +
                    "\n type: " + type +
                    "\n Serial Number: " + serialNumber +
                    "\n Crew: " + crewAmount;
        }else{
            string = " Space craft: " + name +
                    "\n type: " + type +
                    "\n Serial Number: " + serialNumber;
        }

        return string;
    }
}
