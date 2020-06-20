package SpaceMissionControl;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;



public class Main {

    public static void main(String[] args) {

        if(new File("programDump").isFile())
        {
            try
            {
                FileInputStream fileInput = new FileInputStream("programDump");
                ObjectInputStream streamInput = new ObjectInputStream(fileInput);
                ObjectPlus.odczytajEkstensje(streamInput);
                streamInput.close();
                fileInput.close();
            }
            catch(IOException i){
                i.printStackTrace();
                return;
            }
            catch(ClassNotFoundException c){
                System.out.println("Nie znaleziono klasy.");
                c.printStackTrace();
                return;
            }
        }

        Person.addPerson("Adam", "Sobota", new Date(1987, 10, 22 ),85 );
        Person.addPerson("Marian", "Zioło", new Date(1977, 6, 4 ),89 );
        Person.addPerson("Karolina", "Nowak", new Date(1985, 1, 31 ),55 );

        Person.personsList.get(0).updateCommanderLicence("AA38667790");
        Person.personsList.get(1).updatePilotLicence("SB83876239486");
        Person.personsList.get(2).addSpecialization("Fizyk");

        Program.addProgram("SpaceX Dragon", "DRAGON", "Podstawowy program kosmiczny");

        LiftRocket.createLiftRocket("Falcon 9", 1000, 10000, 30000);

        SpaceCraft.createSpaceCraft("Capsule","Dragon 9", "111", 1000, 4, 200, 1000, LiftRocket.liftRcketsList.get(0) );

        Launchpad.createLaunchpad("Kennedy Space Center", "39A");
        LandingSpot.createLaningSpot("water", "Pacyfik");

        Program.programs.get("DRAGON").newMission(1, "Pierwszy lot programu Dragon", SpaceCraft.spaceCraftsList.get(0),Launchpad.launchpads.get(0),new Date(2020, 6,30), 100, 1000, 0, 0);

        Program.programs.get("DRAGON").missionMap.get(1).addCrew();
        Program.programs.get("DRAGON").missionMap.get(1).crew.addCommander(Person.personsList.get(0).getCom());
        Program.programs.get("DRAGON").missionMap.get(1).crew.addPilot(Person.personsList.get(1).getPil());
        Program.programs.get("DRAGON").missionMap.get(1).crew.addMissionSpecialist(Person.personsList.get(2).getMs());

        System.out.println("test");

        Program.programs.get("DRAGON").missionMap.get(1).launchMission(new Date(2020, 6, 30), new Date (2020,9,30));

        System.out.println(Program.programs.get("DRAGON").missionMap.get(1).getMissionRaport());

        Program.programs.get("DRAGON").missionMap.get(1).updateLaningSpot(LandingSpot.landingSpots.get(0), new Date(2020, 9,30,22,30));

        Program.programs.get("DRAGON").missionMap.get(1).completeMission(new Date(2020, 9,30,22,30,4 ), new Date(2020, 9,30,22,30,4 ),"Landed in ocean");

        System.out.println(Program.programs.get("DRAGON").missionMap.get(1).getMissionRaport());
        try
        {
            FileOutputStream fileOutput = new FileOutputStream("programDump");
            ObjectOutputStream StreamOutput = new ObjectOutputStream(fileOutput);
            ObjectPlus.zapiszEkstensje(StreamOutput);
            StreamOutput.close();
            fileOutput.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}
