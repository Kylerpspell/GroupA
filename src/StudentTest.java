package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;

public class StudentTest {

    @Test
    public void addExternalDocumentTest(){

    }

    @Test
    public void removeExternalDocumentTest(){

    }

    @Test
    public void addRating(){
        Employer e = new Employer();
        Student s = new Student();
        ArrayList<Double> ratings1 = e.getRatings();
        s.addRating(2, e);

        ArrayList<Double> ratings2 = e.getRatings();

        assertEquals(ratings2.size(), ratings1.size()+1);
    }

    @Test
    public void getAvgRating(){
        
    }
}