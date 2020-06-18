package SpaceMissionControl;

public class Pilot {

    Person person;

   private String licenceNumber;

   protected Pilot ( Person person, String licenceNumber) {
       this.person = person;
       this.licenceNumber = licenceNumber;
   }

   public void updatePilLicence(String licNum){
       if (licNum == null){
           person = null;
       }
       licenceNumber = licNum;

   }

}
