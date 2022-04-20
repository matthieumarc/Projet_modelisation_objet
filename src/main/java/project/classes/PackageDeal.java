package project.classes;

/**
 * Forfait permettant de contenir une exclusivité d'une Agence sur une de ses Hotels
 */
public class PackageDeal {

    private float price;
    private String date;
    private Fly fly;
    private Hotel hotel;

    /**
     * Quelle Agence appartient ce forfait
     */
    public Agency myAgency;

    /** Constructeur de base acceuillant les éléments d'un Forfait
     * @param price le prix en dollard
     * @param date la date de départ
     * @param fly les information du vol
     * @param hotel l'Hôtel ou le voyage se fera
     */
    public PackageDeal(float price, String date, Fly fly, Hotel hotel){

        this.price = price;
        this.date = date;
        this.fly = fly;
        this.hotel = hotel;
    }

    /**
     * @return le prix du forfait
     */
    public float getPrice() {
        return price;
    }

    /**
     * @return la date du départdu forfait
     */
    public String getDate() {
        return date;
    }

    /**
     * @return l'information du Vol pour le voyage
     */
    public Fly getFly() {
        return fly;
    }

    /**
     * @return l'Hotel oû le séjour du forfait aura lieu
     */
    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public String toString() {

        StringBuilder strbuilder = new StringBuilder("Deal ->");
        strbuilder.append(" Price:").append(this.getPrice()).append("$");
        strbuilder.append(" Date:").append(this.getDate());
        strbuilder.append(" Fly:").append(this.getFly());
        strbuilder.append(" Hotel:").append(this.getHotel().getName());
        return strbuilder.toString();
    }
}
