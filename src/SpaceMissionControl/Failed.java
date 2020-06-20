package SpaceMissionControl;

import java.util.Date;

public class Failed {

    Mission mission;

    Date plannedStartDate;
    Date startDate;
    Date landingDate;
    Date failDate;
    String failDescription;

    public Failed(Mission mission, Date plannedStartDate, Date startDate, Date landingDate, Date failDate, String failDecription){
        if(mission == null){throw new NullPointerException("Mission not provided.");}
        this.mission = mission;
        this.startDate = startDate;
        this.landingDate = landingDate;
        this.failDate = failDate;
        if(failDecription == null){throw new NullPointerException("Fail cause not provided.");}
        this.failDescription = failDecription;
    }


    public String getMissionStatus(){
        return "Failed";
    }

    public String getMissionReport(){
        String startDateStr = null;
        String plannedStartDateStr = null;
        String landingDateStr = null;
        String failDateStr = null;

        if (landingDate != null) {startDateStr =  "\nData startu: " + startDate.toString();}
        if (plannedStartDate != null) {plannedStartDateStr = "\nData planowanego startu: " + plannedStartDate.toString();}
        if (landingDate != null) {landingDateStr = "\nData lądowania: " + landingDate.toString();}
        if (failDate != null) {failDateStr = "\nData niepowodzenia: " + failDate.toString();}

        return mission.toString() +
                "\nStatus: " + getMissionStatus()
                +"\nPrzyczyna: " + failDescription
                +startDateStr
                +plannedStartDateStr
                +landingDateStr
                +failDateStr;
    }


}
