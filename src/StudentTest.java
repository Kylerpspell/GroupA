package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;

public class StudentTest {

    @Test
    public void addExternalDocumentTest(){
        DatabaseManager db = DatabaseManager.getInstance();
        Student s = db.getAccounts().getAccountList().get(2).getStudent();
        ArrayList<String> eD1 = s.getExternalDocuments();
        String doc = "data/Documents/test";

        s.addExternalDocument(doc);

        ArrayList<String> eD2 = s.getExternalDocuments();

        assertEquals(eD2.size(), eD1.size()+1);
    }

    @Test
    public void removeExternalDocumentTest(){
        DatabaseManager db = DatabaseManager.getInstance();
        Student s = db.getAccounts().getAccountList().get(2).getStudent();

        String doc = "data/Documents/test";
        s.addExternalDocument(doc);
        ArrayList<String> eD1 = s.getExternalDocuments();

        s.removeExternalDocument(doc);

        ArrayList<String> eD2 = s.getExternalDocuments();

        assertEquals(eD2.size(), eD1.size()-1);
    }

    @Test
    public void addRating(){
        DatabaseManager db = DatabaseManager.getInstance();
        Employer e = db.getAccounts().getAccountList().get(1).getEmployer();
        Student s = db.getAccounts().getAccountList().get(2).getStudent();
        ArrayList<Double> ratings1 = e.getRatings();
        s.addRating(2, e);

        ArrayList<Double> ratings2 = e.getRatings();

        assertEquals(ratings2.size(), ratings1.size()+1);
    }
}