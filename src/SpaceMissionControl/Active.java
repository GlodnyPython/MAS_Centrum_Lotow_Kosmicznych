package SpaceMissionControl;

import java.util.Date;

public class Active {

    Mission mission;

    Date startDate;
    Date estimatedLandingDate;

    public Active(Mission misja, Date startDate, Date estimatedLandingDate){
        this.mission = misja;
        this.startDate = startDate;
        this.estimatedLandingDate = estimatedLandingDate;
    }

    public Active(Mission misja, Date startDate){
        this.mission = misja;
        this.startDate = startDate;
    }

    public String getMissionStatus(){
        return "Aktywna";
    }

    public String getMissionReport(){
        if(estimatedLandingDate == null){
            return mission.toString()
                    + "\n Status: " + getMissionStatus()
                    + "Data startu: " + startDate.toString();
        }else{
            return mission.toString()
                + "\n Status: " + getMissionStatus()
                + "Data startu: " + startDate.toString()
                + "Przewidywana data lądowania: " + estimatedLandingDate.toString();
        }
    }

}
