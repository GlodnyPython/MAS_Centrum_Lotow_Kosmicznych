package SpaceMissionControl;

import java.util.Date;

public class Completed  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    Mission mission;

    Date startDate;
    Date landingDate;
    Date missionEndDate;
    String missionEndDescription;

    /**
     * @param mission
     * @param startDate
     * @param landingDate
     * @param missionEndDate
     * @param missionEndDescription
     */
    public Completed(Mission mission, Date startDate, Date landingDate, Date missionEndDate, String missionEndDescription){
        if(mission == null){throw new NullPointerException("Mission not provided.");}
        this.mission = mission;
        if(startDate == null){throw new NullPointerException("Mission start date not provided.");}
        this.startDate = startDate;
        this.landingDate = landingDate;
        if(missionEndDate == null){throw new NullPointerException("Mission end date not provided.");}
        this.missionEndDate = missionEndDate;
        if(missionEndDescription == null){throw new NullPointerException("Fail cause not provided.");}
        this.missionEndDescription = missionEndDescription;
    }


    /**
     * @return Current miision status (is called by class mission)
     *
     */
    public String getMissionStatus(){
        return "Completed";
    }

    /**
     * @return Detailed mission report with dated (is called by class mission)
     */
    public String getMissionReport(){
        String startDateStr = null;
        String landingDateStr = null;
        String missionEndDateStr = null;

        if (startDate != null) {startDateStr =  "\n Data startu: " + startDate.toString();}
        if (landingDate != null) {landingDateStr = "\n Data lądowania: " + landingDate.toString();}
        if (missionEndDate != null) {missionEndDateStr = "\n Data zakończenia misji: " + missionEndDate.toString();}

        return mission.toString() +
                "\n Status: " + getMissionStatus()
                +"\n Przyczyna: " + missionEndDescription
                +startDateStr
                +landingDateStr
                +missionEndDateStr;
    }


    /**
     *
     */
    public void remove(){
        mission = null;
    }


}
