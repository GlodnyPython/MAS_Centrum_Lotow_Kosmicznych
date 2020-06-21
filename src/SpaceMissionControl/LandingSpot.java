package SpaceMissionControl;

import java.util.ArrayList;

public class LandingSpot  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<LandingSpot> landingSpots = new ArrayList<>();

    String type;
    String name;

    ArrayList<Landing> landings = new ArrayList<>();

    public LandingSpot(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * @param type
     * @param name
     */
    public static void createLaningSpot(String type, String name){
        landingSpots.add(new LandingSpot(type, name));
    }

    /**
     * @param landing
     *
     * Adds new landing. Called from Landing class
     */
    public void addLanding(Landing landing){
        if(landing == null){throw new NullPointerException("Landing cannot be empty.");}
        landings.add(landing);
    }

    /**
     * @param landing
     *
     * Removes landing. Called from Landing class
     */
    public void removeLanding(Landing landing){
            if(landing == null){throw new NullPointerException("Landing cannot be empty.");}
        landings.remove(landing);
}


}
