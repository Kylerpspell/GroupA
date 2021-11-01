package src;
import java.util.ArrayList;
import java.util.UUID;

public class  Jobs {
	private static Jobs jobs;
	private ArrayList<Job> jobList;

	/**
	 *  initializes job list
	 */

	private Jobs() {
		jobList = DataLoader.getJobs();
	}

	/**
	 * if jobs is null, then it is initialized to new instance of jobs
	 * @return new instance of jobs
	 */

	public static Jobs getInstance() {
		if(jobs == null) {
			jobs = new Jobs();
		}
		
		return jobs;
	}

	/**
	 * looks for the job that is typed in parameter by examining title of each job in list
	 * @param JobTitle this is title of job being searched for
	 * @return returns true if job is found, false otherwise
	 */

	public boolean haveJob(String JobTitle) {
		for(Job job : jobList) {
			if(job.getJobTitle().equals(JobTitle)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * retrieves the list of jobs to be displayed
	 * @return the arraylist of jobs
	 */

	public ArrayList<Job> getJobList() {
		return jobList;
	}

	/**
	 * looks at each job in arraylist to match one with what is in parameter, and if found returns said job
	 * @param JobTitle title of job being searched for
	 * @return if job is found, it is returned, otherwise return is null
	 */

	public Job getJob(String JobTitle) {
		for(Job job : jobList) {
			if(job.getJobTitle().equals(JobTitle)) {
				return job;
			}
		}
		return null;
	}

	/**
	 * retrieves array list of jobs
	 * @return returns array list of jobs
	 */

	public ArrayList<Job> getJobs() {
		return jobList;
	}

	/**
	 * adds specified job to list
	 * @param job the job to be added
	 * @return
	 */

	public boolean addJob(Job job) {
		if(haveJob(job.getJobTitle())){
			return false;
		}
		jobList.add(job);
		return true;
	}

	/**
	 * if specified job id is found in list of jobs, that job associated with id will be removed
	 * @param jobID id number of job to be removed
	 * @return returns true if job was found and removed, otherwise false
	 */

	public boolean removeJob(UUID jobID) {
		for(Job job : jobList) {
			if(job.getID().equals(jobID)) {
				jobList.remove(job);
				return true;
			}
		}
		return false;
	}

	/**
	 * accesses datawriter to save jobs
	 */

	public void saveJobs() {
		DataWriter.saveJobs();
	}
}