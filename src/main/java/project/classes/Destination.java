package project.classes;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Une Destination permet de rassemblé des activités commune et la liste des Hotels se trouvant dans cet endroit.
 */
public class Destination {

    /**
     * Nom de la Destination pour la différencier
     */
    public String name;
    /**
     *  La liste d'Activité unique que l'on peut faire
     */
    public  HashSet<Activity> listActivity;
    /**
     * La liste des Hotels unique présent à cette Destination
     */
    public  HashSet<Hotel> listHotel;
    /**
     * A quel Agence cette Destination fait tel partie
     */
    public Agency myAgency;

    /**Constructeur de base de l'objet
     * @param name Nom pour l'identifier
     */
    public Destination(String name){
        this.name = name;
        this.listActivity = new HashSet<Activity>();
        this.listHotel = new HashSet<Hotel>();
    }

    /**
     * @return la liste de tous les Hotels
     */
    public ArrayList<Hotel> getHotelList()
    {
        return new ArrayList<Hotel>(listHotel);
    }

    /**
     * @return le nom de la Destination
     */
    public String getName(){return name;}
}
