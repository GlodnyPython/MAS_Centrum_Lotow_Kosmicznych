package SpaceMissionControl;

import java.util.ArrayList;

public class Pilot  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<Pilot> pilots = new ArrayList<>();

    Person person;
    private String licenceNumber;
    ArrayList<Crew> assignments = new ArrayList<>();

    /**
     * @param person
     * @param licenceNumber
     */
   protected Pilot ( Person person, String licenceNumber) {
       this.person = person;
       this.licenceNumber = licenceNumber;
       pilots.add(this);
   }

    /**
     * @param licNum
     *
     * Updtaes pilot licence or makes this person not a pilot. Called from Person class
     */
   public void updatePilLicence(String licNum){
       if (licNum == null){
           person = null;
           pilots.remove(this);
       }
       licenceNumber = licNum;

   }

    /**
     * @return Person this pilot is
     */
   public Person getPerson(){
       return person;
   }

    /**
     * @param crew
     *
     * Adds crew assignment
     */
   public void addAssignment(Crew crew){
       assignments.add(crew);
   }

    /**
     * @param crew Removes mission assignment
     */
   public void deleteAssignment(Crew crew){
       assignments.remove(crew);
   }

}
