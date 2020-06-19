package SpaceMissionControl;

public abstract class ServiceModule {

    String serialNumber;
    int ownMass;

    public ServiceModule(String serialNumber, int ownMass){
        if(serialNumber == null){throw new NullPointerException("Serial number not given.");}
        this.serialNumber = serialNumber;
        if(ownMass == 0){throw new NullPointerException("Own mass not given.");}
        this.ownMass = ownMass;
    }

    public int getOwnMass() {
        return ownMass;
    }
}
