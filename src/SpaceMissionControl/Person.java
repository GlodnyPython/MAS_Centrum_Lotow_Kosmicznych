package SpaceMissionControl;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Person {

    private static ArrayList<Person> personsList = new ArrayList<>();
    String name;
    String surname;
    Timestamp dateOfBirth;
    int mass;

    Commander com;
    Pilot pil;
    MissionSpecialist ms;

    protected Person (String name, String surname, Timestamp dateOfBirth, int mass) {
        this.name        = name;
        this.surname     = surname;
        this.dateOfBirth = dateOfBirth;
        this.mass        = mass;

    }

    public static void addPerson (String name, String surname, Timestamp dateOfBirth, int mass) {
        personsList.add(new Person(name, surname, dateOfBirth, mass));
    }

    public void updateMass(int mass){
        this.mass = mass;
    }


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

    public void addSpecialization (String spec){
        if (ms == null){
            ms = new MissionSpecialist(this, spec);
        }else{
            ms.addSpecialization(spec);
        }
    }

    public void removeSpecialization(String spec){
        if (ms != null) {
            try {
                ms.removeSpecialization(spec);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ms.specCount() == 0){
                ms = null;
            }
        }else{
            System.out.println("This person is not mission specialist"); //To be changed to exception with gui implementation
        }
    }


    public int getMass() {
        return mass;
    }

    public String getInfo() {
        String text = "Astronauta: \n" +
                   "Name: "          + name +
                "\n Surname: "       + surname +
                "\n Date of Birth: " + dateOfBirth +
                "\n Mass: "          + mass
                ;

        return text;
    }

}
