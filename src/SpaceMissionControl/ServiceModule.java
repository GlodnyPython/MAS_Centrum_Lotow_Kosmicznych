package SpaceMissionControl;

import java.util.ArrayList;

public abstract class ServiceModule  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    String serialNumber;
    int ownMass;

    ArrayList<SpaceCraft> spaceCrafts = new ArrayList<>();

    /**
     * @param serialNumber
     * @param ownMass
     */
    public ServiceModule(String serialNumber, int ownMass){
        if(serialNumber == null){throw new NullPointerException("Serial number not given.");}
        this.serialNumber = serialNumber;
        if(ownMass == 0){throw new NullPointerException("Own mass not given.");}
        this.ownMass = ownMass;
    }

    /**
     * @return Return module's mass without cargo and fuel
     */
    public int getOwnMass() {
        return ownMass;
    }

    /**
     * @param sc
     *
     * Assigns to spacecraft.
     */
    public void assignToSpacecraft(SpaceCraft sc){
        spaceCrafts.add(sc);
    }

    /**
     * @param sc Removes spacecraft assignment
     */
    public void unassignFromSpacecraft(SpaceCraft sc){
        spaceCrafts.remove(sc);
    }
}
