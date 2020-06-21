package SpaceMissionControl;

import java.util.ArrayList;

public class MissionSpecialist  extends ObjectPlus{

    private static final long serialVersionUID = 1L;

    static ArrayList<MissionSpecialist> missionSpecialists = new ArrayList<>();

    private Person person;
    ArrayList<String> specialization = new ArrayList<>();
    ArrayList<Crew> assignments = new ArrayList<>();


    /**
     * @param person Makes person without specialization mission specialist
     */
    private MissionSpecialist(Person person){
        this.person = person;
    }

    /**
     * @param person
     * @param spec
     *
     * Makes person mission specialist
     */
    protected MissionSpecialist(Person person, String spec){
        this.person = person;
        addSpecialization(spec);
        missionSpecialists.add(this);
    }

    /**
     * @param spec
     *
     * Adds specialization
     */
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

    /**
     * @param spec
     *
     * Removes specialization
     */
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

    /**
     * Removes assignment to mission. Called from Crew class
     */
    public void remove(){
        person = null;
        missionSpecialists.remove(this);
    };

    /**
     * @return Number of specializations
     */
    public int specCount(){
        return specialization.size();
    }

    /**
     * @return person who this mission specialist is
     */
    public Person getPerson(){
        return person;
    }

    /**
     * @param crew
     *
     * Assigns to crew. Called form Crew class
     */
    public void addAssignment(Crew crew){
        assignments.add(crew);
    }

    /**
     * @param crew Removes crew assignment. Called form Crew class
     */
    public void deleteAssignment(Crew crew){
        assignments.remove(crew);
    }

}
