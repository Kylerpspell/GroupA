package src;
import java.util.ArrayList;
import java.util.UUID;

public class Job {
	private UUID id;
	private Account PostingEmployeer;
	private ArrayList<Student> Applicants;
	private Boolean isAvailible;
	private Boolean isVisible;
	private String JobTitle;
	private String JobDescription;

	/**
	 * Job parameterized constructor
	 * @param id UUID for job
	 * @param JobTitle  String title of job
	 * @param JobDescription String description for the job
	 * @param PostingEmployeer Employer that Posted the job
	 * @param applicants  array list of Students who have applied to the job
	 * @param isAvailible boolean that is true when job is available and false otherwise 
	 * @param isVisible boolean that is true when job is visible and false otherwise
	 */
	public Job(UUID id, String JobTitle, String JobDescription, Account PostingEmployeer,ArrayList<Student> applicants, Boolean isAvailible, Boolean isVisible) {
		this.id = id;
		this.PostingEmployeer = PostingEmployeer;
		this.JobTitle = JobTitle;
		this.JobDescription = JobDescription;
		this.Applicants = applicants;
		this.isAvailible = isAvailible;
		this.isVisible = isVisible;
	}

	/**
	 * Accessor method for applicants arraylist 
	 * @return Arraylist with all of the applicants for the job
	 */
	public ArrayList<Student> getApplicants() {
		return Applicants;
	}

	/**
	 * Accessor for job Availability 
	 * @return boolean that is true when job is available and false otherwise
	 */
	public Boolean checkAvailability() {
		return isAvailible;
	}

	/**
	 * Accessor for job visibility 
	 * @return boolean that is true when job is visible and false otherwise
	 */
	public Boolean checkVisibility() {
		return isVisible;
	}

	/**
	 * Mutator for job availability
	 * @param isVisible sets availability to boolean value, true when job is available false otherwise
	 */
	public void setAvailability(Boolean isAvailible) {
		this.isAvailible = isAvailible;
	}

	/**
	 * Mutator for job visibility
	 * @param isVisible sets visibility to boolean value, true when job is visible false otherwise
	 */
	public void setVisibility(Boolean isVisible) {
		this.isVisible = isVisible;
	}


	/**
	 * Adds an applicant from a Jobs applicant array list
	 * @param applicant applicant to be added
	 */
	public void addApplicant(Student applicant) {
		Applicants.add(applicant);
	}

	/**
	 * Removes an applicant from a Jobs applicant array list
	 * @param applicant applicant to be removed
	 */
	public void removeApplicant(Student applicant) {
		Applicants.remove(applicant);
	}

	/**
	 * Accessor for Posting Employee
	 * @return job Description
	 */
	public Account getPostingEmployer() {
		return PostingEmployeer;
	}

	/**
	 * Accessor for job title
	 * @return job Title
	 */
	public String getJobTitle() {
		return JobTitle;
	}

	/**
	 * Accessor for job description
	 * @return job Description
	 */
	public String getJobDescription() {
		return JobDescription;
	}

	/**
	 * Accessor for job ID
	 * @return job UUID
	 */
	public UUID getID() {
		return id;
	}

	/**
	 * Searches title and description for a word or phrase 
	 * @param word  to be searched for in job title and description.
	 * @return True if the phrase is found in the job description and title, false otherwise;
	 */
	public boolean containsWord(String word) {
		if (getJobDescription().contains(word) || getJobTitle().contains(word)) {
			return true;
		}
		return false;
	}
	/**
	 * ToString method to print out Job title, description, and availability
	 * @return String with above information
	 */
	public String toString() {
		return "Job Title: " + this.getJobTitle() + "\nJob Description: " + this.getJobDescription() + "\nAvailable: " + this.checkAvailability()+"\n\n";
	}
}
