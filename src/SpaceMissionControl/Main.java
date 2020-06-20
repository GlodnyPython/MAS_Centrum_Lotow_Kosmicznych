package SpaceMissionControl;

public class Main {

    public static void main(String[] args) {


        Program.addProgram("Space Launch System", "SLS", "Podstawowy program kosmiczny");

        Program.programs.get("SLS").newMission(1,"Pierwsza Misja", 200, 100, 50,0);

    }
}
