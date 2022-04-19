package project;

import org.junit.jupiter.api.Test;
import project.classes.*;
import project.controller.MainController;

import static org.junit.jupiter.api.Assertions.*;

public class TestController {

    @Test
    void TestMainController(){
        MainController main = new MainController();
        assertNotNull(main);
        Hotel hotel = new Hotel("test_hotel");
        Destination dest = new Destination("test");
        // Test addHotelToDestination
        main.addHotelToDestination(hotel, dest);
        assertEquals("test_hotel",hotel.getName());
        assertEquals("test",dest.getName());
        //Test addDestinationToAgency
        Agency agency = new Agency("test");
        main.addDestinationToAgency(dest, agency);
        assertEquals("test",dest.getName());
        assertEquals("test",agency.getName());
        // Test addPackageDealToAgency
        Fly fly = new Fly("Test_company",FlyClass.FIRST);
        PackageDeal pack = new PackageDeal(10,"test_date", fly, hotel);
        main.addPackageDealToAgency(pack,agency);
        assertEquals(10,pack.getPrice());
        assertEquals("test_date",pack.getDate());
        assertEquals(fly,pack.getFly());
        assertEquals(hotel,pack.getHotel());
        // Test addReviewToHotel
        String date = "2022/01/01";
        Stars star = Stars.FIVE;
        int value = star.getValue();
        Review review = new Review("test_review","test_comment",star,date);
        main.addReviewToHotel(review, hotel);
        assertEquals("test_hotel",hotel.getName());
        assertEquals(date,review.getDate());
        assertEquals("test_review",review.getUsername());
        assertEquals("test_comment",review.getComment());
        assertEquals(value,review.getRatingValue());
        // Test showAllReviewFromHotel
        main.showAllReviewFromHotel(hotel);
        // Test showAllHotelFromAgency
        main.showAllHotelFromAgency(agency);
        //Test showAllPackageDealFromAgency
        main.showAllPackageDealFromAgency(agency);
        // Test removeReviewFromHotel
        main.removeReviewFromHotel(review, hotel);
        assertNull(review.getHotel());
        // Test addActivityToDestination
        Activity activity = new Activity("test_name","test_desc");
        main.addActivityToDestination(activity, dest);
        assertEquals("test_name",activity.getName());
        assertEquals("test_desc",activity.getDescription());
        assertEquals(dest,activity.getDestination());
        // Test removeActivityFromDestination
        main.removeActivityFromDestination(activity, dest);
        assertNull(activity.getDestination());
    }
}
