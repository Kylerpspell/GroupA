package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

public class InterfaceManagerTest {
    
    InterfaceManager im = InterfaceManager.getInstance(DatabaseManager.getInstance());
   
    @AfterEach
	public void setup() {
		im.logout();
	}
    @Test
    public void TestLogin() {
        im.login("RyanTheStockGuy@gmail.com", "GottaMakeStocks");
        assertNotNull(im.getCurrentUser());
        im.logout();

        im.login("Incorrect email", "Incorrect password");
        assertNull(im.getCurrentUser());
    }

    @Test
    public void TestLogout() {
        im.login("RyanTheStockGuy@gmail.com", "GottaMakeStocks");
        im.logout();
        assertNull(im.getCurrentUser());
    }


}
