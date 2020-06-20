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

    private Planned planned;
    private Active active;
    private Completed completed;
    private Failed failed;

    public Mission (Program program, int missionNumber, String description, SpaceCraft spaceCraft, Launchpad launchpad, Date plannedStartDate, int cargoMass, int operationalFuelMass, int cargoModulesFuelMass, int planetEscapeFuelMass){
        if(program == null){throw new NullPointerException("Program not provided.");}
        this.program = program;
        this.missionNumber = missionNumber;
        if(description == null){throw new NullPointerException("Description not provided.");}
        this.description = description;
        if(spaceCraft == null){throw new NullPointerException("Space craft not provided.");}
        this.spaceCraft = spaceCraft;
        if(launchpad == null){throw new NullPointerException("Launch pad not provided.");}
        updateLaunchpad(launchpad, plannedStartDate);

        planned = new Planned(this, plannedStartDate);

        this.cargoMass = cargoMass;
        this.operationalFuelMass = operationalFuelMass;
        this.cargoModulesFuelMass = cargoModulesFuelMass;
        this.planetEscapeFuelMass = planetEscapeFuelMass;
    }

    public String getMissionCode(){
        return program.getShortName() + " " + missionNumber;
    }

    public void updateLaunchpad(Launchpad lp, Date date){
        if (start != null) {
            start.remove();
        }
        start = new Start(this, lp, date);
    }
    public void updateLaningSpot(LandingSpot ls, Date date){
        if (landing != null) {
            landing.remove();
        }
        landing = new Landing(this, ls, date);

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
    public int calcAvailableCargoMass(){
        int availabeMass = spaceCraft.getMaxLiftMass() - totalMass;
        int availableCargo = spaceCraft.getTotalMaxCargoMass() - cargoMass;

        if (availabeMass < availableCargo){
            return availabeMass;
        }else{
            return availableCargo;
        }
    }

    public int checkMassFuelRatio(){
        int availableMass = spaceCraft.getMaxLiftMass() - totalMass;
        return availableMass;
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
    public void launchMission(Date startDate, Date estimatedLandingDate){
        checkMissionCorrectness();
        if (isMissionCorrect ==true) {
            if (startDate == null) {
                throw new NullPointerException("Start date not provided.");
            }
            if (estimatedLandingDate == null) {
                throw new NullPointerException("Estimated landing date not provided.");
            }
            planned = null;
            active = new Active(this, startDate, estimatedLandingDate);
            start.changeStatus("Completed");
        }else{throw new NullPointerException("Mission not correct");

        }
    }
    public void abortMission(Date failDate, String failDesc){
        if (planned != null){
            failed = new Failed(this, planned.plannedStartDate, null, null, failDate, failDesc);
            planned = null;
            landing.changeStatus("Cancelled");
            start.changeStatus("Failed");
        }
        if (active != null){
            failed = new Failed(this, null, active.startDate, null, failDate, failDesc);
            active = null;
            landing.changeStatus("Failed");
        }
        if ( completed != null){
            failed = new Failed(this, null, completed.startDate, completed.landingDate, failDate, failDesc);
            completed = null;
            landing.changeStatus("Failed");
        }


    }
    public void completeMission(Date landingDate, Date missionEndDate, String missionEndDescription){
        if(active != null){
            completed = new Completed(this, active.startDate, landingDate, missionEndDate, missionEndDescription);
            active=null;
            landing.changeStatus("Completed");
        }
    }
    public void getMissionStatus(){
        if (planned != null){
            planned.getMissionStatus();
        }
        if (active != null){
            active.getMissionStatus();
        }
        if ( completed != null){
            completed.getMissionStatus();
        }
        if ( failed != null){
            failed.getMissionStatus();
        }
    }
    public String toString(){
        return "Mission " + getMissionCode() + " Space craft: " + spaceCraft.name;
    }
    public void getMissionRaport(){
        if (planned != null){
            planned.getMissionReport();
        }
        if (active != null){
            active.getMissionReport();
        }
        if ( completed != null){
            completed.getMissionReport();
        }
        if ( failed != null){
            failed.getMissionReport();
        }
    }

}
