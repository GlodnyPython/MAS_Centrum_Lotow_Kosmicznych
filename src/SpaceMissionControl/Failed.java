package SpaceMissionControl;

import java.util.Date;

public class Failed  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    Mission mission;

    Date plannedStartDate;
    Date startDate;
    Date landingDate;
    Date failDate;
    String failDescription;

    /**
     * @param mission
     * @param plannedStartDate
     * @param startDate
     * @param landingDate
     * @param failDate
     * @param failDecription
     */
    public Failed(Mission mission, Date plannedStartDate, Date startDate, Date landingDate, Date failDate, String failDecription){
        if(mission == null){throw new NullPointerException("Mission not provided.");}
        this.mission = mission;
        this.startDate = startDate;
        this.landingDate = landingDate;
        this.failDate = failDate;
        if(failDecription == null){throw new NullPointerException("Fail cause not provided.");}
        this.failDescription = failDecription;
    }


    /**
     * @return Current miision status (is called by class mission)
     */
    public String getMissionStatus(){
        return "Failed";
    }

    /**
     * @return Detailed mission report with dated (is called by class mission)
     */
    public String getMissionReport(){
        String startDateStr = null;
        String plannedStartDateStr = null;
        String landingDateStr = null;
        String failDateStr = null;

        if (landingDate != null) {startDateStr =  "\n Data startu: " + startDate.toString();}
        if (plannedStartDate != null) {plannedStartDateStr = "\n Data planowanego startu: " + plannedStartDate.toString();}
        if (landingDate != null) {landingDateStr = "\n Data lądowania: " + landingDate.toString();}
        if (failDate != null) {failDateStr = "\n Data niepowodzenia: " + failDate.toString();}

        return mission.toString() +
                "\n Status: " + getMissionStatus()
                +"\n Przyczyna: " + failDescription
                +startDateStr
                +plannedStartDateStr
                +landingDateStr
                +failDateStr;
    }


}
