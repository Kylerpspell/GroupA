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
        ArrayList<Double> ratings1 = e.getRatings();
        e.giveStudentRating(s ,2);

        ArrayList<Double> ratings2 = e.getRatings();

        assertEquals(ratings2.size(), ratings1.size()+1);
    }

    @Test
    public void addRatingTest(){
        DatabaseManager db = DatabaseManager.getInstance();
        Employer e = db.getAccounts().getAccountList().get(1).getEmployer();
        ArrayList<Double> ratings1 = e.getRatings();
        
        double rating = 2;
        e.addRating(rating);

        ArrayList<Double> ratings2 = e.getRatings();

        assertEquals(ratings2.size(), ratings1.size()+1);
    }
}
