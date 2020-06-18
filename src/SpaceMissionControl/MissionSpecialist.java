package SpaceMissionControl;

import java.util.ArrayList;

public class MissionSpecialist {

    private Person person;

    ArrayList<String> specialization = new ArrayList<>();


    private MissionSpecialist(Person person){
        this.person = person;
    }
    protected MissionSpecialist(Person person, String spec){
        this.person = person;

        addSpecialization(spec);
    }

    public void addSpecialization(String spec){

        boolean append = false;

        for ( String s : this.specialization){
            if (s == spec){
                append = true;
                throw new NullPointerException("Specialization " + spec + " is already assigned");
            }
        }
        if (append == false){
            this.specialization.add(spec);
        }
    }

    public void removeSpecialization(String spec){

        boolean append = false;

        for ( String s : this.specialization){
            if (s == spec){
                append = true;
                this.specialization.remove(s);
            }
        }
        if (append == false){
            throw new NullPointerException("Specialization " + spec + " was not assigned to " + person.name + " " + person.surname);
        }
    }

    public int specCount(){
        return specialization.size();
    }

}
