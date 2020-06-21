package SpaceMissionControl;

import java.util.*;

public class Program  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static Map<String, Program> programs = new TreeMap<>();

    String name;
    private String shortName;
    String description;

    public Map<Integer, Mission> missionMap = new TreeMap<>();

    /**
     * @param name
     * @param shortName
     * @param description
     */
    private Program(String name, String shortName, String description){
        if(name == null){throw new NullPointerException("Name not provided.");}
        this.name = name;
        if(shortName == null){throw new NullPointerException("Short name not provided.");}
        this.shortName = shortName;
        if(description == null){throw new NullPointerException("description not provided.");}
        this.description = description;
    }

    /**
     * @param name
     * @param shortName
     * @param description
     *
     * Creates new program
     */
    static public void addProgram(String name, String shortName, String description){
        programs.put(shortName, new Program(name, shortName, description));
    }

    /**
     * @return Program short name
     */
    public String getShortName() {
        return shortName;

    }

    /**
     * @param missionNumber
     * @param description
     * @param spaceCraft
     * @param launchpad
     * @param plannedStartDate
     * @param cargoMass
     * @param operationalFuelMass
     * @param cargoModulesFuelMass
     * @param planetEscapeFuelMass
     *
     * Creates new mission assigned to this program
     */
    public void newMission(int missionNumber, String description, SpaceCraft spaceCraft, Launchpad launchpad, Date plannedStartDate, int cargoMass, int operationalFuelMass, int cargoModulesFuelMass, int planetEscapeFuelMass){
        missionMap.put(missionNumber, new Mission(this, missionNumber, description, spaceCraft, launchpad, plannedStartDate, cargoMass, operationalFuelMass, cargoModulesFuelMass, planetEscapeFuelMass));
    }

}
