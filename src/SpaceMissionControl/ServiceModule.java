package SpaceMissionControl;

import java.util.ArrayList;

public abstract class ServiceModule {

    String serialNumber;
    int ownMass;

    ArrayList<SpaceCraft> spaceCrafts = new ArrayList<>();

    public ServiceModule(String serialNumber, int ownMass){
        if(serialNumber == null){throw new NullPointerException("Serial number not given.");}
        this.serialNumber = serialNumber;
        if(ownMass == 0){throw new NullPointerException("Own mass not given.");}
        this.ownMass = ownMass;
    }

    public int getOwnMass() {
        return ownMass;
    }

    public void assignToSpacecraft(SpaceCraft sc){
        spaceCrafts.add(sc);
    }

    public void unassignFromSpacecraft(SpaceCraft sc){
        spaceCrafts.remove(sc);
    }
}
