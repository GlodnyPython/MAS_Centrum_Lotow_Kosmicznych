package SpaceMissionControl;

import java.util.ArrayList;

public class Launchpad  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<Launchpad> launchpads = new ArrayList<>();

    String loaction;
    String number;

    ArrayList<Start> starts = new ArrayList<>();

    /**
     * @param loaction
     * @param number
     */
    private Launchpad(String loaction, String number){
        if(loaction == null){throw new NullPointerException("Location not provided.");}
        this.loaction = loaction;
        if(number == null){throw new NullPointerException("Number not provided.");}
        this.number = number;
    }

    /**
     * @param loaction
     * @param number
     *
     * Creates new launch pad
     */
    public static void createLaunchpad(String loaction, String number){
        launchpads.add(new Launchpad(loaction, number));
    }

    /**
     * @param s
     *
     * Adds new start. Called from Start class
     */
    public void addStart(Start s){
        starts.add(s);
    }

    /**
     * @param s
     *
     * Removes start. Called from Start class
     */
    public void removeStart(Start s){
        starts.remove(s);
    }

}
