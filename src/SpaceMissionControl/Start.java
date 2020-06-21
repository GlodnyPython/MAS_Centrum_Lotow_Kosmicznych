package SpaceMissionControl;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Start  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    Launchpad launchpad;
    Mission mission;

    Date date;
    String status;

    /**
     * @param mission
     * @param lp
     * @param date
     */
    protected Start(Mission mission, Launchpad lp, Date date){
        launchpad = lp;
        this.date = date;
        status = "Planned";
        launchpad.addStart(this);
    }

    /**
     * Removes association from LaunchPad class and association to mission and launch pad
     */
    public void remove(){
        mission = null;
        launchpad = null;
        launchpad.removeStart(this);
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
                throw new NullPointerException("Only Cancelled, Completed or Failed can be type provided.");
            }
        }
    }



}
