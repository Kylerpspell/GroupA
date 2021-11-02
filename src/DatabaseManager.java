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
	 * checks if database manager exists, and if not, then creates new instance of it
	 * @return  returns new instance of databse manager
	 */
	public static DatabaseManager getInstance() {
		if (databaseManager == null) {
			databaseManager = new DatabaseManager();
		}
		return databaseManager;
	}

	/**
	 *	retrieves accounts
	 * @return  shows accounts
	 */

	public Accounts getAccounts() {
		return accounts;
	}

	/**
	 * retrieves jobs
	 * @return shows jobs
	 */

	public Jobs getJobs() {
		return this.jobs;
	}

	/**
	 * retrieves resumes
	 * @return current resumes
	 */

	public Resumes getResumes() {
		return this.resumes;
	}

	/**
	 * adds account to arraylist of accounts
	 * @param accountToAdd the account thats needs to be added to list of accounts
	 */

	public void addAccount(Account accountToAdd) {
		accounts.addAccount(accountToAdd);
	}
	/**
	 * adds job to arraylist of jobs
	 * @param job the job thats needs to be added to list of jobs
	 */

	public void addJob(Job job) {
		this.jobs.addJob(job);
	}

	/**
	 * takes account from param and removes it
	 * @param account the account to be removed
	 */

	public void removeAccount(Account account) {
		this.accounts.removeAccount(account.getId());
	}

	/**
	 *  takes job from param and removes it
	 * @param job the job to be removed
	 */

	public void removeJob(Job job) {
		this.jobs.removeJob(job.getID());
	}

	/**
	 * takes job from param and changes its availability
	 * @param jobToChange job thats needs its availability changed
	 * @param availabiltiy decides whether job is available or not
	 */

	public void updateAvailability(Job jobToChange, boolean availabiltiy) {
		jobToChange.setAvailability(availabiltiy);
	}

	/**
	 * takes job from param and changes its visibility
	 * @param jobToChange job thats needs its visibility changed
	 * @param availabiltiy decides whether job is available or not
	 */

	public void updateVisibility(Job jobToChange, boolean availabiltiy) {
		jobToChange.setVisibility(availabiltiy);
	}

	/**
	 * takes account from param and sets it to password in param
	 * @param account account that needs password changed
	 * @param newPassword the new password
	 */

	public void changePassword(Account account, String newPassword) {
		account.setPassword(newPassword);
		
	}

	/**
	 * adds external docs to the specified student account
	 * @param studentAccount account to have external docs added
	 * @param document the document to add
	 */

	public void addExternalDocument(Student studentAccount, String document) {
		studentAccount.addExternalDocument(document);
	}

	/**
	 * removes external docs from the specified student account
	 * @param studentAccount account to have external docs removed
	 * @param document the document to remove
	 */

	public void removeExternalDocument(Student studentAccount, String document) {
			studentAccount.removeExternalDocument(document);
	}

	/**
	 * checks param string to see if it contains specified strings
	 * @param email email
	 * @return true if email contains specified strings, or false otherwise
	 */

	public static boolean validEmail(String email) {
		//TODO ODarius-I just added an else statement not sure if that fixes the issue or not
		if(email.contains("@") && email.contains("."))
			return true;
		else
			return false;
	}

	/**
	 *checks param password to see if it is valid based on if condition
	 * @param password password string
	 * @return true if password is greater or equal to 8 characters, false otherwise
	 */

	public static boolean validPassword(String password) {
		if(password.length() >= 8) {
			return true;
		}
		return false;
	}
}
