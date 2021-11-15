package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.util.UUID;
import java.util.ArrayList;

public class EmployerTest {
    
    @Test
    public void giveStudentRatingTest(){
        Employer e = new Employer();
        Student s = new Student();
        ArrayList<Double> ratings1 = e.getRatings();
        e.giveStudentRating(s ,2);

        ArrayList<Double> ratings2 = e.getRatings();

        assertEquals(ratings2.size(), ratings1.size()+1);
    }

    @Test
    public void addRatingTest(){
        Employer e = new Employer();
        ArrayList<Double> ratings1 = e.getRatings();
        double rating = 2;
        e.addRating(rating);

        ArrayList<Double> ratings2 = e.getRatings();

        assertEquals(ratings2.size(), ratings1.size()+1);
    }
}
