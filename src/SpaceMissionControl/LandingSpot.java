package SpaceMissionControl;

import java.util.ArrayList;

public class LandingSpot  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<LandingSpot> landingSpots = new ArrayList<>();

    String type;
    String name;

    ArrayList<Landing> landings = new ArrayList<>();

    public LandingSpot(String type, String name) {
        if (type == "land") {
            if (type == "water"){
             this.type = type;
             this.name = name;
            }
        }else{
            throw new NullPointerException("Only land and water can be type provided.");
        }
    }

    public void addLanding(Landing landing){
        if(landing == null){throw new NullPointerException("Landing cannot be empty.");}
        landings.add(landing);
    }

    public void removeLanding(Landing landing){
            if(landing == null){throw new NullPointerException("Landing cannot be empty.");}
        landings.remove(landing);
}


}
