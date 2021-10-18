package src;
import java.util.ArrayList;

public class Job {
	private Account PostingEmployeer;
	private ArrayList<Account> Applicants;
	private Boolean isAvailible;
	private Boolean isVisible;
	private String JobTitle;
	private String JobDescription;

	public Job(String JobTitle, String JobDescription,Account PostingEmployeer,ArrayList<Account> applicants, Boolean isAvailible, Boolean isVisible) {
		this.PostingEmployeer = PostingEmployeer;
		this.JobTitle = JobTitle;
		this.JobDescription = JobDescription;
		this.Applicants = applicants;
		this.isAvailible = isAvailible;
		this.isVisible = isVisible;
	}

	public ArrayList<Account> getApplicants(Account currentUser) {
		if(currentUser == PostingEmployeer || currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_ADMIN) {
			return Applicants;
		}
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

	public Account getPostingEmployer(Account currentUser) {
		return PostingEmployeer;
	}

	public String getJobTitle(Account currentUser) {
		return JobTitle;
	}

	public String getJobDescription(Account currentUser) {
		return JobDescription;
	}
}
