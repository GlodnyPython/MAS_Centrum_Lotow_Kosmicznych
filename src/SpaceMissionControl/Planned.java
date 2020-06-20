package SpaceMissionControl;

import java.util.Date;

public class Planned {

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
                + "Planowana data startu: " + plannedStartDate.toString();
    }




}
