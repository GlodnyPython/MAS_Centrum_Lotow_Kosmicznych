package SpaceMissionControl;

import java.util.ArrayList;

public class Commander {

    static ArrayList<Commander> commanders = new ArrayList<>();
    ArrayList<Crew> assignments = new ArrayList<>();

    Person person;

    private String licenceNumber;

    protected Commander ( Person person, String licenceNumber) {
        this.person = person;
        this.licenceNumber = licenceNumber;
        commanders.add(this);
    }

    public void updateComLicence(String licNum){
        if (licNum == null){
            person = null;
            commanders.remove(this);
        }
        licenceNumber = licNum;

    }

    public Person getPerson(){
        return person;
    }

    public void addAssignment(Crew crew){
        assignments.add(crew);
    }

    public void deleteAssignment(Crew crew){
        assignments.remove(crew);
    }

}
