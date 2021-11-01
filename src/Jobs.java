package src;
import java.util.ArrayList;
import java.util.UUID;

public class Jobs {
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
			if(job.getJobTitle().equals(JobTitle)) {
				return true;
			}
		}
		
		return false;
	}
	
	public ArrayList<Job> getJobList() {
		return jobList;
	}

	public Job getJob(String JobTitle) {
		for(Job job : jobList) {
			if(job.getJobTitle().equals(JobTitle)) {
				return job;
			}
		}
		return null;
	}
	
	public ArrayList<Job> getJobs() {
		return jobList;
	}
	
	public boolean addJob(Job job) {
		if(haveJob(job.getJobTitle())){
			return false;
		}
		jobList.add(job);
		return true;
	}
	
	public boolean removeJob(UUID jobID) {
		for(Job job : jobList) {
			if(job.getID().equals(jobID)) {
				jobList.remove(job);
				return true;
			}
		}
		return false;
	}
	public void saveJobs() {
		DataWriter.saveJobs();
	}
}