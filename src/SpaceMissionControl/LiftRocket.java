package SpaceMissionControl;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.ArrayList;

public class LiftRocket {

    static ArrayList<LiftRocket> liftRcketsList = new ArrayList<>();

    String type;
    int ownMass;
    int lunchFuelMass;
    int liftMass;

    int totalMass = 0;

    ArrayList<SpaceCraft> spaceCrafts = new ArrayList<>();

    private LiftRocket(String type, int ownMass, int lunchFuelMass, int liftMass){
        if(type == null){throw new NullPointerException("Type not provided.");}
        this.type = type;
        if(ownMass == 0){throw new NullPointerException("Own mass not provided.");}
        this.ownMass = ownMass;
        this.lunchFuelMass = lunchFuelMass;
        this.liftMass = liftMass;

        calculateTotalMass();
    }

    public static void createLiftRocket(String type, int ownMass, int lunchFuelMass, int liftMass){
            liftRcketsList.add(new LiftRocket(type, ownMass, lunchFuelMass, liftMass));
    }

    public void calculateTotalMass(){
        totalMass = ownMass + lunchFuelMass;
    }

    public int getTotalMass(){
        return totalMass;
    }

    public int getLiftMass() {
        return liftMass;
    }

    public int getOwnMass() {
        return ownMass;
    }

    public int getLunchFuelMass() {
        return lunchFuelMass;
    }

    public void assignToSpacecraft(SpaceCraft sc){
        spaceCrafts.add(sc);
    }

    public void unassignFromSpacecraft(SpaceCraft sc){
        spaceCrafts.remove(sc);
    }
}
