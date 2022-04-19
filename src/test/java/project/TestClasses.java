package project;

import org.junit.jupiter.api.Test;
import project.classes.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestClasses {

    @Test
    void AgencyExists(){
        Agency agency = new Agency("test");
        assertNotNull(agency);
    }

    @Test
    void ActivityExists(){
        Activity activity = new Activity("test","test");
        Destination dest = new Destination("test");
        activity.setDestination(dest);
        activity.setName("test2");
        activity.setDescription("test3");
        assertNotNull(activity);
        assertNotNull(activity.getName());
        assertNotNull(activity.getDescription());
        assertNotNull(activity.getDestination());
    }

    @Test
    void FlyExists(){
        Fly fly = new Fly("Test_company",FlyClass.FIRST);
        assertNotNull(fly);
        assertNotNull(fly.getFlyClass());
        assertNotNull(fly.getCompagnyName());
        assertNotNull(fly.toString());
    }

    @Test
    void HotelExists(){
        Hotel hotel = new Hotel("test_hotel");
        hotel.addAmenities("test_amenities");
        assertNotNull(hotel);
        assertNotNull(hotel.getAmenities());
        assertNotNull(hotel.getName());
    }

    @Test
    void PackageDealExists(){
        Fly fly = new Fly("Test_company",FlyClass.FIRST);
        Hotel hotel = new Hotel("test_hotel");
        PackageDeal pack = new PackageDeal(10,"test_date", fly, hotel);
        assertNotNull(pack);
        assertNotNull(pack.getPrice());
        assertNotNull(pack.getDate());
        assertNotNull(pack.getFly());
        assertNotNull(pack.getHotel());
        assertNotNull(pack.toString());
    }

    @Test
    void ReviewExists(){
        String date = "2022/01/01";
        Stars star = Stars.FIVE;
        Review review = new Review("test_review","test_comment",star,date);
        assertNotNull(star.toString());
        assertNotNull(review);
        assertNotNull(review.getDate());
        assertNotNull(review.getComment());
        assertNotNull(review.getUsername());
        assertNotNull(review.getRatingValue());
        Hotel hotel = new Hotel("test_hotel");
        review.setHotel(hotel);
        assertNotNull(review.getHotel());
        assertTrue(review.isValidDate(date));
        assertFalse(review.isValidDate("date_non_valide"));
        assertNotNull(review.getTodayDate());
    }
}
