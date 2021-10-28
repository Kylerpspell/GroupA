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

	public Job(UUID id, String JobTitle, String JobDescription, Account PostingEmployeer,ArrayList<Student> applicants, Boolean isAvailible, Boolean isVisible) {
		this.id = id;
		this.PostingEmployeer = PostingEmployeer;
		this.JobTitle = JobTitle;
		this.JobDescription = JobDescription;
		this.Applicants = applicants;
		this.isAvailible = isAvailible;
		this.isVisible = isVisible;
	}

	public ArrayList<Student> getApplicants() {
		return Applicants;
	}

	public Boolean checkAvailability() {
		return isAvailible;
	}

	public Boolean checkVisibility() {
		return isVisible;
	}

	public void setAvailability(Boolean isAvailible) {
		this.isAvailible = isAvailible;
	}

	public void setVisibility(Boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void addApplicant(Student applicant) {
		Applicants.add(applicant);
	}

	public void removeApplicant(Student applicant) {
		Applicants.remove(applicant);
	}

	public Account getPostingEmployer() {
		return PostingEmployeer;
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public String getJobDescription() {
		return JobDescription;
	}

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

	public String toString() {
		return "Job Title: " + this.getJobTitle() + "\nJob Description: " + this.getJobDescription() + "\nAvailable: " + this.checkAvailability();
	}
}
