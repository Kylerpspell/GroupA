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
        int ed1 = s.getExternalDocuments().size();
        String doc = "data/Documents/test";

        s.addExternalDocument(doc);

        int ed2 = s.getExternalDocuments().size();

        assertEquals(ed2, ed1+1);
    }

    @Test
    public void removeExternalDocumentTest(){
        DatabaseManager db = DatabaseManager.getInstance();
        Student s = db.getAccounts().getAccountList().get(2).getStudent();

        String doc = "data/Documents/test";
        s.addExternalDocument(doc);
        int ed1 = s.getExternalDocuments().size();

        s.removeExternalDocument(doc);

        int ed2 = s.getExternalDocuments().size();;

        assertEquals(ed2, ed1-1);
    }

    @Test
    public void addRating(){
        DatabaseManager db = DatabaseManager.getInstance();
        Employer e = db.getAccounts().getAccountList().get(1).getEmployer();
        Student s = db.getAccounts().getAccountList().get(2).getStudent();
        int ed1 = s.getExternalDocuments().size();
        s.addRating(2, e);

        int ed2 = s.getExternalDocuments().size();

        assertEquals(ed2, ed1+1);
    }
}