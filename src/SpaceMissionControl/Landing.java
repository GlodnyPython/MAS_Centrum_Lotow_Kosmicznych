package SpaceMissionControl;

import java.util.Date;

public class Landing {

    Mission mission;
    LandingSpot landingSpot;

    Date date;
    String status;

    public Landing(Mission mission, LandingSpot landingSpot, Date date){
        this.landingSpot = landingSpot;
        this.date = date;
        status = "Planned";
        landingSpot.addLanding(this);
    }

    public void remove(){
        mission = null;
        landingSpot = null;
        landingSpot.removeLanding(this);
    }

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
