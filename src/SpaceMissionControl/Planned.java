package SpaceMissionControl;

import java.util.Date;

public class Planned  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    Mission mission;

    Date plannedStartDate;

    public Planned(Mission misja, Date plannedStartDate){
        this.mission = misja;
        this.plannedStartDate = plannedStartDate;
    }

    /**
     * @return Mission status. Called from Mision class
     */
    public String getMissionStatus(){
        return "Planowana";
    }

    /**
     * @return Mission reportt. Called from Mision class
     */
    public String getMissionReport(){
        return mission.toString()
                + "\n Status: " + getMissionStatus()
                + "\n Planowana data startu: " + plannedStartDate.toString();
    }

    /**
     * Removes connection to mission
     */
    public void remove(){
        mission = null;
    }




}
