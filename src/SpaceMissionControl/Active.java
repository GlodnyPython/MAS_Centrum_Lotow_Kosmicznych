package SpaceMissionControl;

import java.util.Date;

public class Active  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    Mission mission;

    Date startDate;
    Date estimatedLandingDate;

    /**
     * @param misja
     * @param startDate
     * @param estimatedLandingDate
     */
    public Active(Mission misja, Date startDate, Date estimatedLandingDate){
        this.mission = misja;
        this.startDate = startDate;
        this.estimatedLandingDate = estimatedLandingDate;
    }

    /**
     * @param misja
     * @param startDate
     */
    public Active(Mission misja, Date startDate){
        this.mission = misja;
        this.startDate = startDate;
    }

    /**
     * @return Current miision status (is called by class mission)
     */
    public String getMissionStatus(){
        return "Aktywna";
    }

    /**
     * @return Detailed mission report with dated (is called by class mission)
     */
    public String getMissionReport(){
        if(estimatedLandingDate == null){
            return mission.toString()
                    + "\n Status: " + getMissionStatus()
                    + "Data startu: " + startDate.toString();
        }else{
            return mission.toString()
                + "\n Status: " + getMissionStatus()
                + "\n Data startu: " + startDate.toString()
                + "\n Przewidywana data lądowania: " + estimatedLandingDate.toString();
        }
    }

    /**
     *
     */
    public void remove(){
        mission = null;
    }

}
