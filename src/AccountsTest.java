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
        ArrayList<Account> ac1 = nA.getAccountList();

        Account ac = new Admin(UUID.randomUUID(), "ee@test.email", "csce1113");
        nA.addAccount(ac);

        ArrayList<Account> ac2 = nA.getAccountList();

        assertEquals(ac2.size(), ac1.size()+1);
    }

    @Test
    public void removeAccountTest(){
        DatabaseManager db = DatabaseManager.getInstance();
        Accounts nA = db.getAccounts();

        Account ac = new Admin(UUID.randomUUID(), "ee@test.email", "csce1113");
        UUID id = ac.getId();
        ArrayList<Account> ac1 = nA.getAccountList();
        
        nA.removeAccount(id);

        ArrayList<Account> ac2 = nA.getAccountList();

        assertEquals(ac2.size(), ac1.size()-1);
    }

    @Test
    public void saveAccountTest(){
        // Calls the DataWriter method, which is already covered in DataWriter Test
    }
}