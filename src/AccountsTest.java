package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;

public class AccountsTest {

    @Test
    public void haveAccountTest(){
        ArrayList<Account> s = DataLoader.getAccounts();
        String email = "";
        s.haveAccount(email);

        ArrayList<Double> ratings2 = e.getRatings();

        assertEquals(ratings2.size(), ratings1.size()+1);
    }

    @Test
    public void addAccountTest(){
        
    }

    @Test
    public void removeAccountTest(){
        
    }

    @Test
    public void saveAccountTest(){
        
    }
}