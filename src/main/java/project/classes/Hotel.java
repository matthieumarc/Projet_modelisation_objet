package project.classes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Les informations d'un Hôtel ou l'on veut séjourner
 */
public class Hotel {

    private String name;
    /**
     * Liste des reviews unique que l'Hôtel à reçue par des clients
     */
    public HashSet<Review> listReview;
    private ArrayList<String> listAmenities;
    /**
     * Destination ou se situe cette Hôtel
     */
    public  Destination destination;
    /**
     * Liste des Forfait offer pour cette Hôtel
     */
    public HashSet<PackageDeal> listPackageDeal;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**Constructeur par défaut
     * @param name Le nom de l'Hotel
     */
    public Hotel(String name){
        this.name = name;
        this.listReview = new HashSet<Review>();
        this.listAmenities = new ArrayList<String>();
        this.listPackageDeal = new HashSet<PackageDeal>();
    }

    /**
     * @param anAmenities Service offert dans l'hotel
     */
    public void addAmenities(String anAmenities)
    {
        this.listAmenities.add(anAmenities);
    }

    /**
     * @return La liste de tous les services présent
     */
    public ArrayList<String> getAmenities()
    {
        return this.listAmenities;
    }

    /**
     * @return La liste de tous les review reçus
     */
    public HashSet<Review> getReviews()
    {
        return this.listReview;
    }

    /**
     * @return Le nom de l'Hotel
     */
    public String getName() {
        return name;
    }

    /**
     * @return  La moyenne des notes reçu par tous ses reviews
     */
    public float getAverageRating() {
        float total = 0.0f;
        int size = listReview.size();
        for (Review rev : listReview) {
            total += rev.getRatingValue();
        }

        if (size == 0){
            return total;
        }

        return total/size;
    }

    @Override
    public String toString() {

        StringBuilder strbuilder = new StringBuilder("Hotel => ");
        strbuilder.append(this.getName()).append(System.lineSeparator());
        strbuilder.append(" Avg.Rating: ").append(df.format(this.getAverageRating())).append(" From ").append(this.listReview.size()).append(" review").append(System.lineSeparator());
        strbuilder.append(" Amenities: ").append(this.listAmenities).append(System.lineSeparator());
        strbuilder.append(" Destination: ").append(this.destination.name).append(System.lineSeparator());
        strbuilder.append(" Current Deal: ").append(this.listPackageDeal.size()).append(" total");
        return strbuilder.toString();
    }
}
