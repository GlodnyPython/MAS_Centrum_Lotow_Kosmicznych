package SpaceMissionControl;

import java.util.Date;

public class Completed {

    Mission mission;

    Date startDate;
    Date landingDate;
    Date missionEndDate;
    String missionEndDescription;

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


    public String getMissionStatus(){
        return "Completed";
    }

    public String getMissionReport(){
        String startDateStr = null;
        String landingDateStr = null;
        String missionEndDateStr = null;

        if (startDate != null) {startDateStr =  "\nData startu: " + startDate.toString();}
        if (landingDate != null) {landingDateStr = "\nData lądowania: " + landingDate.toString();}
        if (missionEndDate != null) {missionEndDateStr = "\nData zakończenia misji: " + missionEndDate.toString();}

        return mission.toString() +
                "\nStatus: " + getMissionStatus()
                +"\nPrzyczyna: " + missionEndDescription
                +startDateStr
                +landingDateStr
                +missionEndDateStr;
    }


}
