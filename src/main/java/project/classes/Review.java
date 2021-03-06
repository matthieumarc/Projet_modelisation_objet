package project.classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Entité permettant de donner son appréciation à un Hotel.
 */
public class Review {

    private String date;
    private String comment;
    private String username;
    private Stars rating;
    private  Hotel myHotel;


    /**
     * @param username le surnom de l'utilisateur ayant rempli la review
     * @param comment Le commentaire décrivant sa review
     * @param star Quel niveau d'appréciation l'utilisateur a-t-il
     * @param date La date qu'a été faite la review
     */
    public Review(String username, String comment, Stars star, String date){

        this.username = username;
        this.comment = comment;
        this.rating = star;
        this.date = date;
    }

    /**
     * @return date of the review
     */
    public String getDate() {
        return this.date;
    }

    /**
     * @return the comment describing the review
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * @return the username of the person who did the review
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return the number of stars the review get / his score ( 1 poorly ... 5 excellent)
     */
    public int getRatingValue() {
        return this.rating.getValue();
    }

    /**
     * @param hotel hotel that have this review
     */
    public void setHotel(Hotel hotel)
    {
        this.myHotel = hotel;
    }


    /**
     * @return Hotel who belong this review
     */
    public Hotel getHotel()
    {
        return this.myHotel;
    }

    /**valid the string is valid date in format yyyy/MM/dd
     * @param date the string date value to validate
     * @return boolean telling if the date his in a valid format
     */
    public static boolean isValidDate(String date)  {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        format.setLenient(false);
        try {
            format.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * @return a string of today date in the form of "yyyy/MM/dd"
     */
    public static String getTodayDate()  {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(new Date());
    }
}
