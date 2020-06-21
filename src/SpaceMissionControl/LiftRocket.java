package SpaceMissionControl;

import java.util.ArrayList;

public class LiftRocket  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<LiftRocket> liftRcketsList = new ArrayList<>();

    String type;
    int ownMass;
    int lunchFuelMass;
    int liftMass;

    int totalMass = 0;

    ArrayList<SpaceCraft> spaceCrafts = new ArrayList<>();

    /**
     * @param type
     * @param ownMass
     * @param lunchFuelMass
     * @param liftMass
     */
    private LiftRocket(String type, int ownMass, int lunchFuelMass, int liftMass){
        if(type == null){throw new NullPointerException("Type not provided.");}
        this.type = type;
        if(ownMass == 0){throw new NullPointerException("Own mass not provided.");}
        this.ownMass = ownMass;
        this.lunchFuelMass = lunchFuelMass;
        this.liftMass = liftMass;

        calculateTotalMass();
    }

    /**
     * @param type
     * @param ownMass
     * @param lunchFuelMass
     * @param liftMass
     *
     * Creates new lift rocket
     */
    public static void createLiftRocket(String type, int ownMass, int lunchFuelMass, int liftMass){
            liftRcketsList.add(new LiftRocket(type, ownMass, lunchFuelMass, liftMass));
    }

    /**
     * Calculates total mass of this rocket (rocket + fuel)
     */
    public void calculateTotalMass(){
        totalMass = ownMass + lunchFuelMass;
    }

    /**
     * @return Total rocket mass (rocket + fuel)
     */
    public int getTotalMass(){
        return totalMass;
    }

    /**
     * @return Mass this rocket is able to carry
     */
    public int getLiftMass() {
        return liftMass;
    }

    /**
     * @return Returns rocket mass without fuel
     */
    public int getOwnMass() {
        return ownMass;
    }

    /**
     * @return Only fuel mass
     */
    public int getLunchFuelMass() {
        return lunchFuelMass;
    }

    /**
     * @param sc
     *
     * Assigns to cpacecraft. Called from Spacecraft class
     */
    public void assignToSpacecraft(SpaceCraft sc){
        spaceCrafts.add(sc);
    }

    /**
     * @param sc
     *
     * Removes assignment to cpacecraft. Called from Spacecraft class
     */
    public void unassignFromSpacecraft(SpaceCraft sc){
        spaceCrafts.remove(sc);
    }
}
