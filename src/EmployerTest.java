package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.util.UUID;
import java.util.ArrayList;

public class EmployerTest {
    
    @Test
    public void giveStudentRatingTest(){
        DatabaseManager db = DatabaseManager.getInstance();
        Employer e = db.getAccounts().getAccountList().get(1).getEmployer();
        Student s = db.getAccounts().getAccountList().get(2).getStudent();
        int r1 = e.getRatings().size();
        e.giveStudentRating(s ,2);

        int r2 = e.getRatings().size();

        assertEquals(r2, r1+1);
    }

    @Test
    public void addRatingTest(){
        DatabaseManager db = DatabaseManager.getInstance();
        Employer e = db.getAccounts().getAccountList().get(1).getEmployer();
        int r1 = e.getRatings().size();
        
        double rating = 2;
        e.addRating(rating);

        int r2 = e.getRatings().size();

        assertEquals(r2, r1+1);
    }
}
