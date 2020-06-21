package SpaceMissionControl;

import java.util.ArrayList;

public class Commander  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<Commander> commanders = new ArrayList<>();
    ArrayList<Crew> assignments = new ArrayList<>();

    Person person;

    private String licenceNumber;

    /**
     * @param person
     * @param licenceNumber
     */
    protected Commander ( Person person, String licenceNumber) {
        this.person = person;
        this.licenceNumber = licenceNumber;
        commanders.add(this);
    }

    /**
     * @param licNum
     *
     * is called by person to create association
     */
    public void updateComLicence(String licNum){
        if (licNum == null){
            person = null;
            commanders.remove(this);
        }
        licenceNumber = licNum;

    }

    /**
     * @return person who this commander is
     */
    public Person getPerson(){
        return person;
    }

    /**
     * @param crew
     *
     * Assigns commander to mission
     */
    public void addAssignment(Crew crew){
        assignments.add(crew);
    }

    /**
     * @param crew
     *
     * removes mission assignment
     */
    public void deleteAssignment(Crew crew){
        assignments.remove(crew);
    }

}
