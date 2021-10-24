package src;
import java.util.ArrayList;
import java.util.UUID;

import src.Account;

public class Job {
	private UUID id;
	private Account PostingEmployeer;
	private ArrayList<String> Applicants;
	private Boolean isAvailible;
	private Boolean isVisible;
	private String JobTitle;
	private String JobDescription;

	public Job(String JobTitle, String JobDescription, Account PostingEmployeer,ArrayList<String> applicants, Boolean isAvailible, Boolean isVisible) {
		this.id = UUID.randomUUID();
		this.PostingEmployeer = PostingEmployeer;
		this.JobTitle = JobTitle;
		this.JobDescription = JobDescription;
		this.Applicants = applicants;
		this.isAvailible = isAvailible;
		this.isVisible = isVisible;
	}

	public ArrayList<Account> getApplicants() {
		return Applicants;
	}

	public Boolean checkAvailability(Account currentUser) {
		return isAvailible;
	}

	public Boolean checkVisibility(Account currentUser) {
		return isVisible;
	}

	public void setAvailability(Boolean isAvailible) {
		this.isAvailible = isAvailible;
	}

	public void setVisibility(Boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void addApplicant(Account applicant) {
		Applicants.add(applicant);
	}

	public void removeApplicant(Account applicant) {
		Applicants.remove(applicant);
	}

	public UUID getPostingEmployer() {
		return PostingEmployeer;
	}

	public String getJobTitle(Account currentUser) {
		return JobTitle;
	}

	public String getJobDescription(Account currentUser) {
		return JobDescription;
	}

	public UUID getID(Account currentUser) {
		return id;
	}
}
