package SpaceMissionControl;

import java.util.Date;

public class Landing  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    Mission mission;
    LandingSpot landingSpot;

    Date date;
    String status;

    /**
     * @param mission
     * @param landingSpot
     * @param date
     */
    public Landing(Mission mission, LandingSpot landingSpot, Date date){
        this.landingSpot = landingSpot;
        this.date = date;
        status = "Planned";
        landingSpot.addLanding(this);
    }

    /**
     * Removes association from LandingSpot class and association to mission and landing spot
     */
    public void remove(){
        mission = null;
        landingSpot = null;
        landingSpot.removeLanding(this);
    }

    /**
     * @param status changes status based on current status from misiion class
     */
    public void changeStatus(String status){
        if (status == "Cancelled") {
            this.status = status;
        }else{
            if (status == "Completed"){
                this.status = status;
            }else{
                if(status == "Failed"){
                    this.status = status;
                }else{
                    throw new NullPointerException("Only Cancelled, Completed or Failed can be type provided.");
                }
            }
        }
    }

}
