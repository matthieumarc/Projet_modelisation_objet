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
    }

    @Test
    void TestAddHotelToDestination(){
        Hotel hotel = new Hotel("test_hotel");
        Destination dest = new Destination("test");
        MainController main = new MainController();
        main.addHotelToDestination(hotel, dest);
        assertEquals("test_hotel",hotel.getName());
        assertEquals("test",dest.getName());
    }

    @Test
    void TestAddDestinationToAgency(){
        Agency agency = new Agency("test");
        Destination dest = new Destination("test");
        MainController main = new MainController();
        main.addDestinationToAgency(dest, agency);
        assertEquals("test",dest.getName());
        assertEquals("test",agency.getName());
    }

    @Test
    void TestAddPackageDealToAgency(){
        Agency agency = new Agency("test");
        Fly fly = new Fly("Test_company",FlyClass.FIRST);
        Hotel hotel = new Hotel("test_hotel");
        PackageDeal pack = new PackageDeal(10,"test_date", fly, hotel);
        MainController main = new MainController();
        main.addPackageDealToAgency(pack,agency);
        assertEquals(10,pack.getPrice());
        assertEquals("test_date",pack.getDate());
        assertEquals(fly,pack.getFly());
        assertEquals(hotel,pack.getHotel());
    }

    @Test
    void TestAddReviewToHotel(){
        Hotel hotel = new Hotel("test_hotel");
        String date = "2022/01/01";
        Stars star = Stars.FIVE;
        int value = star.getValue();
        Review review = new Review("test_review","test_comment",star,date);
        MainController main = new MainController();
        main.addReviewToHotel(review, hotel);
        assertEquals("test_hotel",hotel.getName());
        assertEquals(date,review.getDate());
        assertEquals("test_review",review.getUsername());
        assertEquals("test_comment",review.getComment());
        assertEquals(value,review.getRatingValue());
    }

    @Test
    void TestShowAllReviewFromHotel(){
        MainController main = new MainController();
        Hotel hotel = new Hotel("test_hotel");
        String date = "2022/01/01";
        Stars star = Stars.FIVE;
        Review review = new Review("test_review","test_comment",star,date);
        main.addReviewToHotel(review, hotel);
        main.showAllReviewFromHotel(hotel);
    }

    @Test
    void TestShowAllHotelFromAgency(){
        MainController main = new MainController();
        Agency agency = new Agency("test");
        Destination dest = new Destination("test");
        Hotel hotel = new Hotel("test_hotel");
        main.addDestinationToAgency(dest, agency);
        main.addHotelToDestination(hotel, dest);

        main.showAllHotelFromAgency(agency);
    }

    @Test
    void TestShowAllPackageDealFromAgency(){
        MainController main = new MainController();
        Agency agency = new Agency("Agence_test");
        Destination dest = new Destination("test_dest");
        Fly fly = new Fly("Test_company",FlyClass.FIRST);
        Hotel hotel = new Hotel("test_hotel");
        PackageDeal pack = new PackageDeal(10,"test_date", fly, hotel);
        main.addHotelToDestination(hotel, dest);
        main.addDestinationToAgency(dest, agency);
        main.addPackageDealToAgency(pack,agency);

        main.showAllPackageDealFromAgency(agency);
    }

    @Test
    void TestRemoveReviewFromHotel(){
        MainController main = new MainController();
        Hotel hotel = new Hotel("test_hotel");
        String date = "2022/01/01";
        Stars star = Stars.FIVE;
        Review review = new Review("test_review","test_comment",star,date);
        main.removeReviewFromHotel(review, hotel);
        assertNull(review.getHotel());
    }

    @Test
    void TestAddActivityToDestination(){
        MainController main = new MainController();
        Activity activity = new Activity("test_name","test_desc");
        Destination dest = new Destination("test");
        main.addActivityToDestination(activity, dest);
        assertEquals("test_name",activity.getName());
        assertEquals("test_desc",activity.getDescription());
        assertEquals(dest,activity.getDestination());
    }

    @Test
    void TestRemoveActivityFromDestination(){
        MainController main = new MainController();
        Activity activity = new Activity("test_name","test_desc");
        Destination dest = new Destination("test");
        main.removeActivityFromDestination(activity, dest);
        assertNull(activity.getDestination());
    }
}
