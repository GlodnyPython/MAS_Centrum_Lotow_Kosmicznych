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

    public String getMissionStatus(){
        return "Planowana";
    }

    public String getMissionReport(){
        return mission.toString()
                + "\n Status: " + getMissionStatus()
                + "\n Planowana data startu: " + plannedStartDate.toString();
    }




}
