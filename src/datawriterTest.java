package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.util.UUID;

public class datawriterTest {
	@Test
	public void saveAccountTest() {
		DatabaseManager db = DatabaseManager.getInstance();
		int oSize = db.getAccounts().getAccountList().size();
		Account testAdmin = new Admin(UUID.randomUUID(), "RandomAdminTest.email.sc.edu", "csce8675309");
		db.addAccount(testAdmin);
		DataWriter.saveAccounts();
		int nsize = db.getAccounts().getAccountList().size();
		
		assertEquals(nsize, oSize + 1);
		
		db.removeAccount(testAdmin);
		DataWriter.saveAccounts();
	}

	@Test
	public void saveJobsTest() {
		DatabaseManager db = DatabaseManager.getInstance();
		int oSize = db.getJobs().getJobList().size();
		Job tempJob = db.getJobs().getJobList().get(0);
		db.removeJob(tempJob);
		DataWriter.saveJobs();
		int nSize = db.getJobs().getJobList().size();
		assertEquals(nSize, oSize - 1);

		db.addJob(tempJob);
		DataWriter.saveJobs();
	}
}
