package project.controller;

import project.classes.*;

import java.util.ArrayList;

/**
 * Controller principale permettant la gestion de tous les entités pour une Agence de Voyage.
 * Les Stocker , les assigner entre eux et appeler certain affichage.
 */
public class MainController {

    /**
     * La liste de tous les Agences que l'on veut gérer
     */
    public ArrayList<Agency> allAgency;
    /**
     * La liste de tous les Destination que l'on veut gérer avec les Agences
     */
    public ArrayList<Destination> allDestination;
    /**
     * La liste de tous les Forfait que l'on veut pouvoir associé
     */
    public ArrayList<PackageDeal> allPackageDeal;
    /**
     * La liste de tous les Hôtels qui seront présent dans les Agences, Destination et associé au Forfait
     */
    public ArrayList<Hotel> allHotel;
    /**
     * La liste de toutes les Activités qui seront présent pour des Destination unique
     */
    public ArrayList<Activity> allActivity;
    /**
     * La liste de tous les Reviews que les Hôtels auront des clients
     */
    public ArrayList<Review> allReview;
    /**
     * La liste de tous les Vol disponible pour les Forfaits
     */
    public ArrayList<Fly> allFly;

    private DestinationController destinationController = new DestinationController();
    private HotelController hotelController = new HotelController();
    private AgencyController agencyController = new AgencyController();
    private PackageDealController packageDealController = new PackageDealController();


    /**
     * Instancie toutes les listes utile à la gestion de ce Contrôller
     */
    public MainController()
    {
        allAgency = new ArrayList<Agency>();
        allDestination = new ArrayList<Destination>();
        allPackageDeal = new ArrayList<PackageDeal>();
        allHotel = new ArrayList<Hotel>();
        allActivity = new ArrayList<Activity>();
        allReview = new ArrayList<Review>();
        allFly = new ArrayList<Fly>();
    }

    /**Permet l'ajout d'un Hotel à une Destination
     * @param hotel L'hotel que l'on désire ajouter
     * @param destination La Destination qui recevra l'Hotel
     */
    public void addHotelToDestination(Hotel hotel, Destination destination)
    {
        destinationController.setDestination(destination);
        destinationController.addHotel(hotel);

        hotelController.setHotel(hotel);
        hotelController.setDestination(destination);
    }

    /**Permet l'ajout d'une Destination à une Agence
     * @param destination La destination que l'on désire ajouter
     * @param agency L'agence qui recvra la destination
     */
    public void addDestinationToAgency(Destination destination, Agency agency)
    {
        destinationController.setDestination(destination);
        destinationController.setAgency(agency);

        agencyController.setAgency(agency);
        try {
            agencyController.addDestination(destination);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** Permet l'ajout d'un Forfait à une Agence , valide seulement si l'Hotel du Forfait est dans l'Agence aussi.
     * @param packageDeal Forfait que l'on veut lié à l'Agence
     * @param agency L'Agence qui recevra le forfait d'une de ses Hotels
     */
    public void addPackageDealToAgency(PackageDeal packageDeal, Agency agency)
    {
        agencyController.setAgency(agency);
        packageDealController.setPackageDeal(packageDeal);

        try {
            agencyController.addPackageDeal(packageDeal);
            packageDealController.setAgency(agency);

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**permet l'Ajout d'un Review à un Hôtel
     * @param review la Review qu'un client a fait sur l'Hôtel
     * @param hotel L'hôtel qui reçois la review
     */
    public void addReviewToHotel(Review review, Hotel hotel) {
        Hotel oldHotel = review.getHotel();

        if (!hotel.equals(oldHotel))
        {
            hotelController.setHotel(hotel);
            hotelController.addReview(review);

            /*Oui il peut être null s'il n'a jamais été setté*/
            if(oldHotel != null)
            {
                this.removeReviewFromHotel(review,oldHotel);
            }

            review.setHotel(hotel);
        }
    }


    /**Permet d'enlever un review d'un Hôtel
     * @param review LA review spécifique que l'on veut retirer
     * @param hotel l'hôtel qui se fera retirer son review
     */
    public void removeReviewFromHotel(Review review, Hotel hotel)
    {
        hotelController.setHotel(hotel);
        hotelController.removeReview(review);
        review.setHotel(null);
    }

    /**Permet l'ajout d'une activité à une Destination et gère le changement de Destination si cela se produit
     * @param activity l'activité à ajouter dans la Destination
     * @param destination La destination que recevra la nouvelle activité
     */
    public void addActivityToDestination(Activity activity, Destination destination) {
        Destination oldDestination = activity.getDestination();

        if (!destination.equals(oldDestination))
        {
            destinationController.setDestination(destination);
            destinationController.addActivity(activity);

            /*Oui il peut être null s'il n'a jamais été setté*/
            if(oldDestination != null)
            {
                this.removeActivityFromDestination(activity,oldDestination);
            }

            activity.setDestination(destination);
        }
    }

    /**Permet d'enlever une ativité d'une destination
     * @param activity l'activité à enlver d'une destination
     * @param destination la destination qui se fera enlever l'activité
     */
    public void removeActivityFromDestination(Activity activity, Destination destination)
    {
        destinationController.setDestination(destination);
        destinationController.removeActivity(activity);
        activity.setDestination(null);
    }

    /**Permet d'Afficher tous les review que l'Hôtel à reçu
     * @param hotel l'hôtel ciblé par les reviews
     */
    public void showAllReviewFromHotel(Hotel hotel)
    {
        hotelController.setHotel(hotel);
        System.out.println(hotelController.getViewAllReview());
    }

    /**Permet d'Afficher tous les Forfait disponible présentement dans l'Agence pour les Hôtels qui y sont
     * @param agency L'Agence ciblé pour l'Affichage
     */
    public void showAllPackageDealFromAgency(Agency agency)
    {
        agencyController.setAgency(agency);
        System.out.println(agencyController.getViewAllPackageDeal());
    }

    /** Permet d'Afficher la liste de tous les détails des Hôtel d'une Agence.
     * @param agency L'agence ou l'on veut afficher les hôtels info
     */
    public void showAllHotelFromAgency(Agency agency)
    {
        agencyController.setAgency(agency);
        System.out.println(agencyController.getViewAllHotel());
    }
}
