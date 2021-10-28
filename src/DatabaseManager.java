package src;

public class DatabaseManager {
	public static DatabaseManager databaseManager;
	private Resumes resumes;
	private Jobs jobs;
	private Accounts accounts;
	private Account currentAccount;

	/**
	 * @return creates and gets instances of required variables to complete database
	 */
	private DatabaseManager() {
		resumes = Resumes.getInstance();
		jobs = Jobs.getInstance();
		accounts = Accounts.getInstance();
	}

	/**
	 * @param user specificed name of account
	 * @return  takes user parameter to set the account of database instance
	 */
	public static DatabaseManager getInstance(Account user) {
		if (databaseManager == null) {
			databaseManager = new DatabaseManager();
		}
		databaseManager.currentAccount = user;
		return databaseManager;
	}

	/**
	 *
	 * @return  validates if current account is admin and if so, shows accounts
	 */

	public Accounts getAccounts() {
		if(currentAccount.getAccountType() == AccountType.ACCOUNT_TYPE_ADMIN) {
			return accounts;
		}
		else {
			return null;
		}
	}

	public Jobs getJobs() {
		return this.jobs;
	}


	public Resumes getResumes() {
		return this.resumes;
	}

	public void addAccount(Account accountToAdd) {
		accounts.addAccount(accountToAdd);
	}

	public void addJob(Job job) {
		this.jobs.addJob(job);
	}

	public void removeAccount(Account account) {
		if(currentAccount.getAccountType() == AccountType.ACCOUNT_TYPE_ADMIN || currentAccount.getId() == account.getId()) {
			this.accounts.removeAccount(account.getId());
		}
	}

	public void removeJob(Job job) {
		if(currentAccount.getAccountType() == AccountType.ACCOUNT_TYPE_ADMIN || currentAccount.getId() == job.getPostingEmployer().getId()) {
			this.jobs.removeJob(job.getID());
		}
	}

	public void updateAvailability(Job jobToChange, boolean availabiltiy) {
		jobToChange.setAvailability(availabiltiy);
	}

	public void updateVisibility(Job jobToChange, boolean availabiltiy) {
		jobToChange.setVisibility(availabiltiy);
	}

	public void changePassword(Account account, String newPassword) {
		if(currentAccount.getAccountType() == AccountType.ACCOUNT_TYPE_ADMIN || account.getId() == currentAccount.getId()) {
			account.setPassword(newPassword);
		}
	}
	public void addExternalDocument(Student studentAccount, String document) {
		if(currentAccount.getAccountType() == AccountType.ACCOUNT_TYPE_ADMIN || studentAccount.getId() == currentAccount.getId()) {
			studentAccount.addExternalDocument(document);
		}
	}

	public void removeExternalDocument(Student studentAccount, String document) {
		if(currentAccount.getAccountType() == AccountType.ACCOUNT_TYPE_ADMIN || studentAccount.getId() == currentAccount.getId()) {
			studentAccount.removeExternalDocument(document);
		}
	}

	public static boolean validEmail(String email) {
		if(email.contains("@") && email.contains(".")) {
			return true;
		}
		return false;
	}

	public static boolean validPassword(String password) {
		if(password.length() >= 8) {
			return true;
		}
		return false;
	}
}
