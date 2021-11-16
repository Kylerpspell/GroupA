package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.util.UUID;
import java.util.ArrayList;

public class EmployerTest {
    
    @Test
    public void giveStudentRatingTest(){
        //This calls the addRating method, covered by the addRatingTest method below
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
