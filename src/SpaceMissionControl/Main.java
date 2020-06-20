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

        Program.programs.get("DRAGON").newMission(1, "Pierwszy lot programu Dragon", SpaceCraft.spaceCraftsList.get(0),Launchpad.launchpads.get(0),new Date(2020, 06,30), 100, 1000, 0, 0);

        System.out.println("test");

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
