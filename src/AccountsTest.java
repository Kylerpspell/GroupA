package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;

public class AccountsTest {

    @Test
    public void haveAccountTest(){
        DatabaseManager db = DatabaseManager.getInstance();
        Accounts nA = db.getAccounts();

        String email = "RyanTheStockGuy@gmail.com";

        assertTrue(nA.haveAccount(email));
    }

    @Test
    public void addAccountTest(){
        DatabaseManager db = DatabaseManager.getInstance();
        Accounts nA = db.getAccounts();
        int ac1 = nA.getAccountList().size();

        Account ac = new Admin(UUID.randomUUID(), "ee@test.email", "csce1113");
        nA.addAccount(ac);

        int ac2 = nA.getAccountList().size();

        assertEquals(ac2, ac1+1);
    }

    @Test
    public void removeAccountTest(){
        DatabaseManager db = DatabaseManager.getInstance();
        Accounts nA = db.getAccounts();

        Account ac = new Admin(UUID.randomUUID(), "ee@test.email", "csce1113");
        UUID id = ac.getId();
        int ac1 = nA.getAccountList().size();
        
        nA.removeAccount(id);

        int ac2 = nA.getAccountList().size();

        assertEquals(ac2, ac1-1);
    }

    @Test
    public void saveAccountTest(){
        // Calls the DataWriter method, which is already covered in DataWriter Test
    }
}