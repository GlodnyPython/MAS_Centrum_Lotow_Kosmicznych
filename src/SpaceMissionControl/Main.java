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

        Program.addProgram("Space Launch System", "SLS", "Podstawowy program kosmiczny");

        //Program.programs.get("SLS").newMission();


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
