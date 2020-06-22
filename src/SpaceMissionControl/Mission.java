package SpaceMissionControl;

import java.util.Date;

public class Mission  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

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

    /**
     * @param program
     * @param missionNumber
     * @param description
     * @param spaceCraft
     * @param launchpad
     * @param plannedStartDate
     * @param cargoMass
     * @param operationalFuelMass
     * @param cargoModulesFuelMass
     * @param planetEscapeFuelMass
     */
    public Mission (Program program, int missionNumber, String description, SpaceCraft spaceCraft, Launchpad launchpad, Date plannedStartDate, int cargoMass, int operationalFuelMass, int cargoModulesFuelMass, int planetEscapeFuelMass){
        if(program == null){throw new NullPointerException("Program not provided.");}
        this.program = program;
        this.missionNumber = missionNumber;
        if(description == null){throw new NullPointerException("Description not provided.");}
        this.description = description;
        if(spaceCraft == null){throw new NullPointerException("Space craft not provided.");}
        this.spaceCraft = spaceCraft;
        spaceCraft.assignToMission(this);
        if(launchpad == null){throw new NullPointerException("Launch pad not provided.");}
        updateLaunchpad(launchpad, plannedStartDate);

        planned = new Planned(this, plannedStartDate);

        this.cargoMass = cargoMass;
        this.operationalFuelMass = operationalFuelMass;
        this.cargoModulesFuelMass = cargoModulesFuelMass;
        this.planetEscapeFuelMass = planetEscapeFuelMass;
    }

    /**
     * @return Mission code based on progarm name and mission numer
     */
    public String getMissionCode(){
        return program.getShortName() + " " + missionNumber;
    }

    /**
     * Adds new crew and removes old one (if exists)
     */
    public void addCrew(){
        if (crew != null){
            crew.remove();
        }
        crew = Crew.createCrew(this);
    }

    /**
     * @param lp
     * @param date
     *
     * Updated launch information
     */
    public void updateLaunchpad(Launchpad lp, Date date){
        if (start != null) {
            start.remove();
        }
        start = new Start(this, lp, date);
    }

    /**
     * @param ls
     * @param date
     *
     * Updates landing information
     */
    public void updateLaningSpot(LandingSpot ls, Date date){
        if (landing != null) {
            landing.remove();
        }
        landing = new Landing(this, ls, date);

    }

    /**
     * @param cargo
     *
     * Sets new cargo value
     */
    public void addCargo(int cargo){ //przypisanie ładunku cargo
        cargoMass = cargo;
    }

    /**
     * Calculates and saves total mission mass
     */
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

    /**
     * @return
     *
     * Calculates and saves availavle cargo left to carry
     */
    public int calcAvailableCargoMass(){
        int availabeMass = spaceCraft.getMaxLiftMass() - totalMass;
        int availableCargo = spaceCraft.getTotalMaxCargoMass() - cargoMass;

        if (availabeMass < availableCargo){
            return availabeMass;
        }else{
            return availableCargo;
        }
    }

    /**
     * @return
     *
     * Checks and saves mass to fuel ratio
     */
    public int checkMassFuelRatio(){
        int availableMass = spaceCraft.getMaxLiftMass() - totalMass;
        return availableMass;
    }

    /**
     * Checks and saves info if mission is ready to launch
     */
    public void checkMissionCorrectness(){
        calcTotalMass();
        if (totalMass <= spaceCraft.getMaxLiftMass()){
            isMissionCorrect = true;
        }else{
            isMissionCorrect = false;
            System.out.println("Misja przekroczyła dopuszczalną masę startową");
        }

        int crewCount;
        if (crew == null){
            crewCount = 0;
        }else{
            crewCount = 2 + crew.missionSpecialists.size();
        }
        if (crewCount > spaceCraft.getCrewAmount()){
            System.out.println("Misja zawiera więcej załogi niż statek jest w stanie pomieścić");
        }


    }

    /**
     * @param startDate
     * @param estimatedLandingDate
     *
     * Changes mission status to active and updates mission information with start details
     */
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

    /**
     * @param failDate
     * @param failDesc
     *
     * Changes mission status to failed and updates mission information with fail details
     */
    public void abortMission(Date failDate, String failDesc){
        if (planned != null){
            failed = new Failed(this, planned.plannedStartDate, null, null, failDate, failDesc);
            planned.remove();
            planned = null;
            landing.changeStatus("Cancelled");
            start.changeStatus("Failed");
        }
        if (active != null){
            failed = new Failed(this, null, active.startDate, null, failDate, failDesc);
            active.remove();
            active = null;
            landing.changeStatus("Failed");
        }
        if ( completed != null){
            failed = new Failed(this, null, completed.startDate, completed.landingDate, failDate, failDesc);
            active.remove();
            completed = null;
            landing.changeStatus("Failed");
        }


    }

    /**
     * @param landingDate
     * @param missionEndDate
     * @param missionEndDescription
     *
     * Changes mission status to completed and updates mission information with competition's details
     */
    public void completeMission(Date landingDate, Date missionEndDate, String missionEndDescription){
        if(active != null){
            completed = new Completed(this, active.startDate, landingDate, missionEndDate, missionEndDescription);
            active.remove();
            active=null;
            if(landing != null) {
                landing.changeStatus("Completed");
            }
        }
    }

    /**
     * Return current mission status obtained from current state class
     */
    public String getMissionStatus(){
        if (planned != null){
            return planned.getMissionStatus();
        }
        if (active != null){
            return active.getMissionStatus();
        }
        if ( completed != null){
            return completed.getMissionStatus();
        }
        if ( failed != null){
            return failed.getMissionStatus();
        }
        return null;
    }

    public Date getMissionDate(){
        if (planned != null){
            return planned.plannedStartDate;
        }
        if (active != null){
            return active.startDate;
        }
        if ( completed != null){
            return completed.missionEndDate;
        }
        if ( failed != null){
            return failed.failDate;
        }
        return null;
    }

    /**
     * @return Basic mission information
     */
    public String toString(){
        return "Mission " + getMissionCode() + " Satek: " + spaceCraft.name;
    }

    /**
     * @return Detailed mission report obtained from current state class
     */
    public String getMissionRaport(){
        if (planned != null){
            return planned.getMissionReport();
        }
        if (active != null){
            return active.getMissionReport();
        }
        if ( completed != null){
            return completed.getMissionReport();
        }
        if ( failed != null){
            return failed.getMissionReport();
        }
        return null;
    }

}
