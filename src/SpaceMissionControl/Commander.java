package SpaceMissionControl;

public class Commander {

    Person person;

    private String licenceNumber;

    protected Commander ( Person person, String licenceNumber) {
        this.person = person;
        this.licenceNumber = licenceNumber;
    }

    public void updateComLicence(String licNum){
        if (licNum == null){
            person = null;
        }
        licenceNumber = licNum;

    }

}
