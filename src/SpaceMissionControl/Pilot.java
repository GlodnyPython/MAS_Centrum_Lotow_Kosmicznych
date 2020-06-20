package SpaceMissionControl;

import java.util.ArrayList;

public class Pilot  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<Pilot> pilots = new ArrayList<>();

    Person person;
    private String licenceNumber;
    ArrayList<Crew> assignments = new ArrayList<>();

   protected Pilot ( Person person, String licenceNumber) {
       this.person = person;
       this.licenceNumber = licenceNumber;
       pilots.add(this);
   }

   public void updatePilLicence(String licNum){
       if (licNum == null){
           person = null;
           pilots.remove(this);
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
