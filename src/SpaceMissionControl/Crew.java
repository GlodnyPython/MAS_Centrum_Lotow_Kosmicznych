package SpaceMissionControl;

import java.util.ArrayList;

public class Crew  extends ObjectPlus{

    private static final long serialVersionUID = 1L;


    Commander com;
    Pilot pil;
    ArrayList<MissionSpecialist> missionSpecialists = new ArrayList<>();

    int crewMass;

    Mission mission;

    private Crew(Mission mission){
        if(mission == null){throw new NullPointerException("Missioon not provided.");}
        this.mission = mission;
    }

    /**
     * @param mission
     * @return creted crew to mission class
     */
    public static Crew createCrew(Mission mission){
        return new Crew(mission);
    }

    /**
     * Called by mission. Removes mission and connections to this mission from crew members
     */
    public void remove(){
        com.deleteAssignment(this);
        pil.deleteAssignment(this);
        for (MissionSpecialist  ms : missionSpecialists){
            ms.deleteAssignment(this);
        }
    }


    /**
     * @param com
     *
     * Assigns commander to this crew
     */
    public void addCommander(Commander com){
        this.com = com;
        this.com.addAssignment(this);
         calculateCrewMass();
    }

    /**
     * @param pil
     *
     * Assigns pilot to this crew
     */
    public void addPilot(Pilot pil){
        if (com.getPerson() != pil.getPerson()){

            boolean append = false;
            for (MissionSpecialist ms : missionSpecialists){
                if(ms.getPerson() == pil.getPerson()){
                    append = true;
                }
            }

            if (append){
                System.out.println("This person is Mission Specialist, cannot assign Pilot role");
            }else{
                if (pil == null){
                    System.out.println("Changed Pilot");
                    this.pil.deleteAssignment(this);
                }
                this.pil = pil;
                this.pil.addAssignment(this);
                calculateCrewMass();

            }

        }else{
            System.out.println("This person is Commander, cannot assign Pilot role");
        }
    }

    /**
     * @param ms
     *
     * Assings mission specialist to this crew
     */
    public void addMissionSpecialist(MissionSpecialist ms){
        if (com.getPerson() != ms.getPerson()){
            if (pil.getPerson() != ms.getPerson()){

                boolean append = false;
                for (MissionSpecialist m : missionSpecialists){
                    if(m.getPerson() == ms.getPerson()){
                        append = true;
                    }
                }

                if (append){
                    System.out.println("This person is mission specialist");
                }else{
                    missionSpecialists.add(ms);
                    ms.addAssignment(this);
                    calculateCrewMass();
                }

            }else{
                System.out.println("This person is Pilot, cannot assign Mission Specialist role");
            }
        }else{
            System.out.println("This person is Commander, cannot assign Mission Specialist role");
        }
    }

    /**
     * @param ms
     *
     * Removes mission specialist from this crew and removed connection to this crew
     */
    public void removeMissionSpecialist(MissionSpecialist ms){
        boolean append = false;
        for (MissionSpecialist m : missionSpecialists){
            if(m.getPerson() == ms.getPerson()){
                append = true;
            }
        }

        if (append){
            System.out.println("Removed mission specialist");
            missionSpecialists.remove(ms);
            ms.deleteAssignment(this);
            calculateCrewMass();
        }else{
            System.out.println("This person was not assigned to this mission");
        }
    }

    /**
     * Calculate and saves crew mass
     */
    public void calculateCrewMass(){
        int mass = 0;
        if(com != null){
        mass += com.getPerson().getMass();
        }
        if(pil != null) {
            mass += pil.getPerson().getMass();
        }

        if(missionSpecialists.size() > 0) {
            for (MissionSpecialist ms : missionSpecialists) {
                mass += ms.getPerson().getMass();
            }
        }

        crewMass = mass;
    }

    /**
     * @return crew mass calculated in calculateCrewMass method
     */
    public int getCrewMass(){
        calculateCrewMass();
        return crewMass;
    }

}
