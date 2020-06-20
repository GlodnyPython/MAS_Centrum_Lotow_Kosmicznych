package SpaceMissionControl;

import java.util.ArrayList;

public class Launchpad {
    static ArrayList<Launchpad> launchpads = new ArrayList<>();

    String loaction;
    String number;

    ArrayList<Start> starts = new ArrayList<>();

    private Launchpad(String loaction, String number){
        if(loaction == null){throw new NullPointerException("Location not provided.");}
        this.loaction = loaction;
        if(number == null){throw new NullPointerException("Number not provided.");}
        this.number = number;
    }

    public static void createLaunchpad(String loaction, String number){
        launchpads.add(new Launchpad(loaction, number));
    }

    public void addStart(Start s){
        starts.add(s);
    }

    public void removeStart(Start s){
        starts.remove(s);
    }

}
