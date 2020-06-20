package SpaceMissionControl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

    public class ObjectPlus implements Serializable {

        private static final long serialVersionUID = 1L;

        private static Hashtable<Class<? extends ObjectPlus>, Vector<ObjectPlus>> ekstensje = new Hashtable<Class<? extends ObjectPlus>, Vector<ObjectPlus>>();

        public ObjectPlus(){
            Vector<ObjectPlus> ekstensja = null;
            Class<? extends ObjectPlus> klasa = this.getClass();

            if(ekstensje.containsKey(klasa))
            {
                ekstensja = ekstensje.get(klasa);
            }
            else
            {
                ekstensja = new Vector<ObjectPlus>();
                ekstensje.put(klasa, ekstensja);
            }
            ekstensja.add(this);
        }

        public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException
        {
            stream.writeObject(ekstensje);
        }

        public static void odczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException
        {
            ekstensje = (Hashtable<Class<? extends ObjectPlus>, Vector<ObjectPlus>>) stream.readObject();
        }

        public static void pokazEkstensje(Class<? extends ObjectPlus> klasa) throws Exception
        {
            Vector<ObjectPlus> ekstensja = null;

            if(ekstensje.containsKey(klasa))
            {
                ekstensja = ekstensje.get(klasa);
            }
            else
            {
                throw new Exception("Unknown class " + klasa);
            }

            System.out.println("Ekstensja klasy: " + klasa.getSimpleName());

            for(Object obiekt : ekstensja)
            {
                System.out.println(obiekt + "\n");
            }
        }

        public static ArrayList<Class<? extends ObjectPlus>> odtworzEkstensje (Class<? extends ObjectPlus> klasa) throws Exception {

            Vector<ObjectPlus> ekstensja = null;

            ArrayList<Class<? extends ObjectPlus>> klasy = new ArrayList<Class<? extends ObjectPlus>>();

            if(ekstensje.containsKey(klasa))
            {
                ekstensja = ekstensje.get(klasa);
            }
            else
            {
                throw new Exception("Unknown class " + klasa);
            }

            System.out.println("Ekstensja klasy: " + klasa.getSimpleName());

            for(Object obiekt : ekstensja)
            {
                klasy.add((Class<? extends ObjectPlus>) obiekt);
            }

            return klasy;

        }

    }


