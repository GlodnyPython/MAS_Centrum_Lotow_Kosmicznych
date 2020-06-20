package SpaceMissionControl;

import java.util.ArrayList;

public class MissionSpecialist  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<MissionSpecialist> missionSpecialists = new ArrayList<>();

    private Person person;
    ArrayList<String> specialization = new ArrayList<>();
    ArrayList<Crew> assignments = new ArrayList<>();


    private MissionSpecialist(Person person){
        this.person = person;
    }
    protected MissionSpecialist(Person person, String spec){
        this.person = person;
        addSpecialization(spec);
        missionSpecialists.add(this);
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

    public void remove(){
        person = null;
        missionSpecialists.remove(this);
    };

    public int specCount(){
        return specialization.size();
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
