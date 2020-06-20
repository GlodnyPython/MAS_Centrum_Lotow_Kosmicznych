package SpaceMissionControl;

import java.util.*;

public class Program {

    static Map<String, Program> programs = new TreeMap<>();

    String name;
    private String shortName;
    String description;

    public Map<Integer, Mission> missionMap = new TreeMap<>();

    private Program(String name, String shortName, String description){
        if(name == null){throw new NullPointerException("Name not provided.");}
        this.name = name;
        if(shortName == null){throw new NullPointerException("Short name not provided.");}
        this.shortName = shortName;
        if(description == null){throw new NullPointerException("description not provided.");}
        this.description = description;
    }

    static public void addProgram(String name, String shortName, String description){
        programs.put(shortName, new Program(name, shortName, description));
    }

    public String getShortName() {
        return shortName;

    }

    public void newMission(int missionNumber, String description, SpaceCraft spaceCraft, Launchpad launchpad, Date plannedStartDate, int cargoMass, int operationalFuelMass, int cargoModulesFuelMass, int planetEscapeFuelMass){
        missionMap.put(missionNumber, new Mission(this, missionNumber, description, spaceCraft, launchpad, plannedStartDate, cargoMass, operationalFuelMass, cargoModulesFuelMass, planetEscapeFuelMass));
    }

}
