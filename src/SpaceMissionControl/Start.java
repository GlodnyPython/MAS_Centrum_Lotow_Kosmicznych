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

    protected Start(Mission mission, Launchpad lp, Date date){
        launchpad = lp;
        this.date = date;
        status = "Planned";
        launchpad.addStart(this);
    }

    public void remove(){
        mission = null;
        launchpad = null;
        launchpad.removeStart(this);
    }

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
