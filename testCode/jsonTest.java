package testCode;
import java.util.ArrayList;
import src.*;
public class jsonTest {
	public static void main(String[] args) {
		ArrayList<Account> accounts = DataLoader.getAccounts();
		for(Account a : accounts) {
			System.out.println(a);
		}
		ArrayList<Job> jobs = DataLoader.getJobs();
		for(Job j : jobs) {
			System.out.println(j);
		}		
		ArrayList<Resume> resumes = DataLoader.getResumes();
		for(Resume r : resumes) {
			System.out.println(r);
		}

	}
}
