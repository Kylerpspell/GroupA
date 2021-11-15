package src;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

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

    @Test 
    public void TestAddAccount() {
        int size = dm.getAccounts().getAccounts().size();
        dm.addAccount(new Student());
        int size2 = dm.getAccounts().getAccounts().size();
        assertNotEquals(size, size2);
    }

    @Test 
    public void TestAddJobs() {
        int size = dm.getJobs().getJobs().size();
        dm.addJob(new Job(UUID.randomUUID(), "New job", "new Job", new Employer(), new ArrayList<Student>(), true, true));
        int size2 = dm.getJobs().getJobs().size();
        assertNotEquals(size, size2);
    }

    @Test
    public void TestRemoveAccount() {
        int size = dm.getAccounts().getAccounts().size();
        dm.removeAccount(new Student());
        int size2 = dm.getAccounts().getAccounts().size();
        assertNotEquals(size, size2);
    }

    @Test 
    public void TestRemoveJobs() {
        int size = dm.getJobs().getJobs().size();
        dm.removeJob(new Job(UUID.randomUUID(), "New job", "new Job", new Employer(), new ArrayList<Student>(), true, true));
        int size2 = dm.getJobs().getJobs().size();
        assertNotEquals(size, size2);
    }

}
