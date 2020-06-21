package SpaceMissionControl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Person  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<Person> personsList = new ArrayList<>();
    String name;
    String surname;
    Date dateOfBirth;
    int mass;

    Commander com;
    Pilot pil;
    MissionSpecialist ms;

    /**
     * @param name
     * @param surname
     * @param dateOfBirth
     * @param mass
     */
    private Person (String name, String surname, Date dateOfBirth, int mass) {
        this.name        = name;
        this.surname     = surname;
        this.dateOfBirth = dateOfBirth;
        this.mass        = mass;

    }

    /**
     * @param name
     * @param surname
     * @param dateOfBirth
     * @param mass
     *
     * Adds new person
     */
    public static void addPerson (String name, String surname, Date dateOfBirth, int mass) {
        personsList.add(new Person(name, surname, dateOfBirth, mass));
    }

    /**
     * @param mass
     *
     * Updates person mass
     */
    public void updateMass(int mass){
        this.mass = mass;
    }


    /**
     * @param comLicNum Makes person Commander and updates licence or makes person not commander
     */
    public void updateCommanderLicence(String comLicNum){
        if (com == null){
            com = new Commander(this, comLicNum);
        }else{
            if (comLicNum == null){
                com.updateComLicence(comLicNum);
                com = null;
            }else {
                com.updateComLicence(comLicNum);
            }
        }
    }

    /**
     * @param pilLicNum
     *
     * Makes person Pilot and updates licence or makes person not pilot
     */
    public void updatePilotLicence(String pilLicNum){
        if (pil == null){
            pil = new Pilot(this, pilLicNum);
        }else{
            if (pilLicNum == null){
                pil.updatePilLicence(pilLicNum);
                pil = null;
            }else {
                pil.updatePilLicence(pilLicNum);
            }
        }
    }

    /**
     * @param spec
     *
     * Makes person mission Specialist with specialization or adds new specialization
     */
    public void addSpecialization (String spec){
        if (ms == null){
            ms = new MissionSpecialist(this, spec);
        }else{
            ms.addSpecialization(spec);
        }
    }

    /**
     * @param spec Removes specialization or makes person not a mission specialist
     */
    public void removeSpecialization(String spec){
        if (ms != null) {
            try {
                ms.removeSpecialization(spec);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ms.specCount() == 0){
                ms.remove();
                ms = null;
            }
        }else{
            System.out.println("This person is not mission specialist"); //To be changed to exception with gui implementation
        }
    }

    /**
     * @return Commnander class
     */
    public Commander getCom() {
        if(com == null){throw new NullPointerException("This person is not a commander.");}
        return com;
    }

    /**
     * @return Pilot class
     */
    public Pilot getPil() {
        if(pil == null){throw new NullPointerException("This person is not a pilot.");}
        return pil;
    }

    /**
     * @return Mission Specialist class
     */
    public MissionSpecialist getMs() {
        if(ms == null){throw new NullPointerException("This person is not a mission specialist.");}
        return ms;
    }

    /**
     * @return Person's mass
     */
    public int getMass() {
        return mass;
    }

    /**
     * @return Basic personal info
     */
    public String getInfo() { //TODO Dodać dziedziczenie
        String text = "Astronauta: \n" +
                   "Name: "          + name +
                "\n Surname: "       + surname +
                "\n Date of Birth: " + dateOfBirth.toString() +
                "\n Mass: "          + mass
                ;

        return text;
    }

}
