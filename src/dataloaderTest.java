package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.util.UUID;
import java.util.ArrayList;



public class dataloaderTest {
	
	@Test
	public void TestAccountRead() {
		ArrayList<Account> accountList = DataLoader.getAccounts();
		Admin firstRead = (Admin) accountList.get(0);
		assertEquals("AdminMan@Internfinder.com",firstRead.getEmail());
		assertEquals("P455Word",firstRead.getPassword());
		assertEquals(UUID.fromString("476eb24d-5599-4739-b1d7-ce52acf0add8"),firstRead.getId());


		Employer secondRead = (Employer) accountList.get(5);
		assertEquals("testcompany@spamMail.com", secondRead.getEmail());
		assertEquals("passwordIsSecure", secondRead.getPassword());
		assertEquals(UUID.fromString("f576a1e1-9baa-4d62-89f5-0620df24f08f"), secondRead.getId());

		Student thirdRead = (Student) accountList.get(2);
		assertEquals("BobbyB@email.sc.edu", thirdRead.getEmail());
		assertEquals("556plussome", thirdRead.getPassword());
		
		assertEquals("docID1", thirdRead.getExternalDocuments().get(0));
		assertEquals("docID2", thirdRead.getExternalDocuments().get(1));
		
		assertEquals(UUID.fromString("b7781df9-a42a-4cc4-a685-7a72bc90c9b5"), thirdRead.getId());
		
		assertEquals(4.1, thirdRead.getRatings().get(0));
		assertEquals(4.3, thirdRead.getRatings().get(1));
		assertEquals(2.1, thirdRead.getRatings().get(2));
		assertEquals(3.4, thirdRead.getRatings().get(3));
	}

	@Test
	public void TestResumeRead() {
		ArrayList<Resume> resumeList = DataLoader.getResumes();
		Resume firstRead = resumeList.get(0);
		assertEquals(Majors.valueOf("BIOCHEMISTRY_AND_MOLECULAR_BIOLOGY"), firstRead.getMajor());
		
		assertEquals("Money Management", firstRead.getSkills().get(0));
		assertEquals("Stock Finding", firstRead.getSkills().get(1));

		assertEquals("Bobby Bobinson", firstRead.getName());
		
		assertEquals("ExperienceStock", firstRead.getExperiences().get(0));
		assertEquals("ExperienceMoney", firstRead.getExperiences().get(1));

		assertEquals(4.0, firstRead.getGPA());

		assertEquals("2019-01-01", firstRead.getGraduationDate());

		assertEquals(UUID.fromString("fe1e1262-b08c-4b23-9d95-8f8bcf0ac63d"), firstRead.getId());
	}

	@Test
	public void testJobRead() {
		ArrayList<Job> jobList = DataLoader.getJobs();
		Job firstRead = jobList.get(0);
		assertEquals("StockFinder", firstRead.getJobTitle());

		assertEquals(UUID.fromString("e6e23452-c4c6-421d-bac5-e8a9e185b2cd"), firstRead.getID());
		
		assertEquals("true", Boolean.toString(firstRead.checkAvailability()));
		assertEquals("true", Boolean.toString(firstRead.checkVisibility()));

		assertEquals(UUID.fromString("b7781df9-a42a-4cc4-a685-7a72bc90c9b5"), firstRead.getApplicants().get(0).getId());
		assertEquals(UUID.fromString("7b4bbacd-7d22-44f3-9467-8a80515ac17e"), firstRead.getApplicants().get(1).getId());

		assertEquals("This is a stock finding job, good luck with it!", firstRead.getJobDescription());

		assertEquals(UUID.fromString("fc0f8f1d-7528-4908-8b63-5d5a8f01ad58"), firstRead.getPostingEmployer().getId());
	}
}