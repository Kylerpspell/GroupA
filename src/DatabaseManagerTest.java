package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

public class DatabaseManagerTest {
    
    DatabaseManager dm = DatabaseManager.getInstance();

    @Test
    public void TestValidEmail() {
        assertTrue(dm.validEmail("email@email.sc.edu"));
        assertFalse(dm.validEmail("notavalidemail"));
    }

    @Test
    public void TestValidPassword() {
        assertTrue(dm.validPassword("thisIsaValidPassword"));
        assertFalse(dm.validPassword("nonval"));
    }
}
