package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;

public class StudentTest {

    @Test
    public void addExternalDocumentTest(){
        Student s = new Student();
        ArrayList<String> eD1 = s.getExternalDocuments();
        String doc = "data/Documents/test";

        s.addExternalDocument(doc);

        ArrayList<String> eD2 = s.getExternalDocuments();

        assertEquals(eD2.size(), eD1.size()+1);
    }

    @Test
    public void removeExternalDocumentTest(){
        Student s = new Student();
        String doc = "data/Documents/test";
        s.addExternalDocument(doc);
        ArrayList<String> eD1 = s.getExternalDocuments();

        s.removeExternalDocument(doc);

        ArrayList<String> eD2 = s.getExternalDocuments();

        assertEquals(eD2.size(), eD1.size()-1);
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
}