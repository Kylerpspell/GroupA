package src;

public class DatabaseManager {
	public static DatabaseManager databaseManager;
	private Resumes resumes;
	private Jobs jobs;
	private Accounts accounts;

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
	public static DatabaseManager getInstance() {
		if (databaseManager == null) {
			databaseManager = new DatabaseManager();
		}
		return databaseManager;
	}

	/**
	 *
	 * @return  validates if current account is admin and if so, shows accounts
	 */
	public Accounts getAccounts() {
		return accounts;
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
		this.accounts.removeAccount(account.getId());
	}

	public void removeJob(Job job) {
		this.jobs.removeJob(job.getID());
	}

	public void updateAvailability(Job jobToChange, boolean availabiltiy) {
		jobToChange.setAvailability(availabiltiy);
	}

	public void updateVisibility(Job jobToChange, boolean availabiltiy) {
		jobToChange.setVisibility(availabiltiy);
	}

	public void changePassword(Account account, String newPassword) {
		account.setPassword(newPassword);
		
	}
	public void addExternalDocument(Student studentAccount, String document) {
		studentAccount.addExternalDocument(document);
	}

	public void removeExternalDocument(Student studentAccount, String document) {
			studentAccount.removeExternalDocument(document);
	}

	public static boolean validEmail(String email) {
		//TODO was throwing error, need to fix
		return true;
	}

	public static boolean validPassword(String password) {
		if(password.length() >= 8) {
			return true;
		}
		return false;
	}
}
