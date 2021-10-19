package src;
import java.util.ArrayList;
import java.util.UUID;

public class Jobs {
	static final Account WRITER_ACCOUNT = new Account(UUID.randomUUID(), "password","admin@email.sc.edu",AccountType.ACCOUNT_TYPE_ADMIN);
	private static Jobs jobs;
	private ArrayList<Job> jobList;
	
	private Jobs() {
		jobList = DataLoader.getJobs();
	}
	
	public static Jobs getInstance() {
		if(jobs == null) {
			jobs = new Jobs();
		}
		
		return jobs;
	}

	public boolean haveJob(String JobTitle) {
		for(Job job : jobList) {
			if(job.getJobTitle(WRITER_ACCOUNT).equals(JobTitle)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Job getJob(String JobTitle) {
		for(Job job : jobList) {
			if(job.getJobTitle(WRITER_ACCOUNT).equals(JobTitle)) {
				return job;
			}
		}
		return null;
	}
	
	public ArrayList<Job> getJobs() {
		return jobList;
	}
	
	public boolean addJob(Job job) {
		if(haveJob(job.getJobTitle(WRITER_ACCOUNT))){
			return false;
		}
		jobList.add(job);
		return true;
	}
	
	public void saveJobs() {
		DataWriter.saveJobs();
	}
}