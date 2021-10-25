package src;

import java.util.ArrayList;

public class DatabaseManager {
    public static DatabaseManager databaseManager;
    private ArrayList<Account> accounts;
    private ArrayList<Job> jobs;
	private ArrayList<Resume> resumes;
	private Account currentAccount;
    
    private DatabaseManager() {
        accounts = DataLoader.getAccounts();
		jobs = DataLoader.getJobs();
		resumes = DataLoader.getResumes();
    }

    public static DatabaseManager getInstance() {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager();
        }

        return databaseManager;
    }

    public ArrayList<Account> getAccounts() {
        if(currentAccount.UserAccountType == AccountType.ACCOUNT_TYPE_ADMIN) {
			return accounts;
		}
		else {
			return null;
		}
    }

    public ArrayList<Job> getJobs() {
		return this.jobs;
    }

	public ArrayList<Resume> getResumes() {
		return this.resumes;
	}

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void addJob(Job job) {
		this.jobs.add(job);
    }

    public void removeAccount(Account account) {
        if(currentAccount.UserAccountType == AccountType.ACCOUNT_TYPE_ADMIN || currentAccount.getId() == account.getId()) {
			this.accounts.remove(account);
		}
    }

    public void removeJob(Job job) {
        if(currentAccount.UserAccountType == AccountType.ACCOUNT_TYPE_ADMIN || currentAccount.getId() == job.getPostingEmployer().getId()) {
			this.jobs.remove(job);
		}
    }

    public void updateAvailability(Job jobToChange, boolean availabiltiy) {
		jobToChange.setAvailability(availabiltiy);
    }

    public void updateVisibility(Job jobToChange, boolean availabiltiy) {
		jobToChange.setVisibility(availabiltiy);
    }

    public void changePassword(Account account, String newPassword) {
		if(currentAccount.UserAccountType == AccountType.ACCOUNT_TYPE_ADMIN || account.id == currentAccount.id) {
			account.setPassword(newPassword);
		}
    }
    public void addExternalDocument(Student studentAccount, String document) {
		if(currentAccount.UserAccountType == AccountType.ACCOUNT_TYPE_ADMIN || studentAccount.id == currentAccount.id) {
			studentAccount.addExternalDocument(document);
		}
    }

    public void removeExternalDocument(Student studentAccount, String document) {
		if(currentAccount.UserAccountType == AccountType.ACCOUNT_TYPE_ADMIN || studentAccount.id == currentAccount.id) {
			studentAccount.removeExternalDocument(document);
    	}
	}
}
