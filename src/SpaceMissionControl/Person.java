package SpaceMissionControl;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Person {

    private static ArrayList<Person> personsList = new ArrayList<>();
    String name;
    String surname;
    Timestamp dateOfBirth;
    int mass;

    //TODO Commander
    //TODO Pilot
    //TODO Mission Specialist
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

    //TODO implementacja dziedziczenia

    public void addSpecialization (String spec){
        if (ms != null){
            ms = new MissionSpecialist(this, spec);
            //TODO @ here
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
