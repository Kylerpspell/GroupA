package src;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

public class DatabaseManagerTest {
    
    DatabaseManager dm = DatabaseManager.getInstance();
    Student student = new Student();
    Job job = new Job(UUID.randomUUID(), "New job", "new Job", new Employer(), new ArrayList<Student>(), true, true);
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
    public void testAddAccount() {
        int size = dm.getAccounts().getAccounts().size();
        dm.addAccount(student);
        int size2 = dm.getAccounts().getAccounts().size();
        assertNotEquals(size, size2);
    }

    @Test 
    public void testAddJobs() {
        int size = dm.getJobs().getJobs().size();
        dm.addJob(job);
        int size2 = dm.getJobs().getJobs().size();
        assertNotEquals(size, size2);
    }

    @Test
    public void testRemoveAccount() {
        int size = dm.getAccounts().getAccounts().size();
        dm.removeAccount(student);
        int size2 = dm.getAccounts().getAccounts().size();
        assertNotEquals(size, size2);
    }

    @Test 
    public void testRemoveJobs() {
        int size = dm.getJobs().getJobs().size();
        dm.removeJob(job);
        int size2 = dm.getJobs().getJobs().size();
        assertNotEquals(size, size2);
    }

    @Test
    public void testChangePassword() {
        dm.changePassword(student, "ValidPassword");
        assertNotNull(student.getPassword());
        dm.changePassword(student, null);
        assertNull(student.getPassword());
    }

    @Test
    public void testUpdateAvailability() {
        dm.updateAvailability(job, false);
        assertFalse(job.checkAvailability());
        dm.updateAvailability(job, true);
        assertTrue(job.checkAvailability());
    }

    @Test
    public void testUpdateVisibility() {
        dm.updateVisibility(job, false);
        assertFalse(job.checkVisibility());
        dm.updateVisibility(job, true);
        assertTrue(job.checkVisibility());
    }

}
