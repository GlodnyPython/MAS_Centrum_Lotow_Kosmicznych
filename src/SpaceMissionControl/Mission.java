package SpaceMissionControl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Mission {

    Program program;

    int missionNumber;
    String description;
    int cargoMass;
    int operationalFuelMass;
    int cargoModulesFuelMass;
    int planetEscapeFuelMass;
    int totalMass;
    boolean isMissionCorrect;

    Start start;
    Landing landing;
    Crew crew;
    SpaceCraft spaceCraft;

    int massFuelRatio;

    public Mission (Program program, int missionNumber, String description, SpaceCraft spaceCraft, Launchpad launchpad, Date plannedStartDate, int cargoMass, int operationalFuelMass, int cargoModulesFuelMass, int planetEscapeFuelMass,){
        if(program == null){throw new NullPointerException("Program not provided.");}
        this.program = program;
        this.missionNumber = missionNumber;
        if(description == null){throw new NullPointerException("Description not provided.");}
        this.description = description;
        if(spaceCraft == null){throw new NullPointerException("Space craft not provided.");}
        this.spaceCraft = spaceCraft;
        if(launchpad == null){throw new NullPointerException("Launch pad not provided.");}
        updateLaunchpad(launchpad, plannedStartDate);

        this.cargoMass = cargoMass;
        this.operationalFuelMass = operationalFuelMass;
        this.cargoModulesFuelMass = cargoModulesFuelMass;
        this.planetEscapeFuelMass = planetEscapeFuelMass;
    }

    public String getMissionCode(){
        return program.getShortName() + " " + missionNumber;
    }

    public void updateLaunchpad (Launchpad lp, Date date){
        if (start == null) {
            start = new Start(this, lp, date);
        }else{
            start.remove();
            start = new Start(this, lp, date);
        }
    }
    updateLaningSpot(){

    }
    public void addCargo(int cargo){ //przypisanie ładunku cargo
        cargoMass = cargo;
    }

    public void calcTotalMass(){
        int tm = 0;
        tm += spaceCraft.getTotalOwnMass();
        if (crew != null) {
            tm += crew.getCrewMass();
        }
        tm += operationalFuelMass;
        tm += cargoModulesFuelMass;
        tm += planetEscapeFuelMass;
        tm += cargoMass;

        totalMass = tm;
    }
    calcAvailableCargoMass()

    public int checkMassFuelRatio(){
        int availabeMass = spaceCraft.getMaxLiftMass() - totalMass;
        int availableCargo = spaceCraft.getTotalMaxCargoMass() - cargoMass;

        if (availabeMass < availableCargo){
            return availabeMass;
        }else{
            return availableCargo;
        }
    }

    public void checkMissionCorrectness(){
        calcTotalMass();
        if (totalMass <= spaceCraft.getMaxLiftMass()){
            isMissionCorrect = true;
        }else{
            isMissionCorrect = false;
            System.out.println("Misja przekroczyła dopuszczalną masę startową");
        }

    }
    launchMission()
    abortMission()
    completeMission()
    getMissionStatus()
    toString()
    getMissionRaport()

}
