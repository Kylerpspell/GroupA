package src;
public abstract class DataConstants {
	// File Names
	protected static final String JOBS_FILE_NAME = "data/Jobs.json";
	protected static final String ACCOUNTS_FILE_NAME = "data/Accounts.json";
	protected static final String RESUMES_FILE_NAME = "data/Resumes.json";
	// UUIDs
	protected static final String JOB_UUID = "id";
	protected static final String ACCOUNT_UUID = "id";
	protected static final String RESUME_UUID = "id";

	// Job
	protected static final String JOB_NAME = "JobID";
	protected static final String JOB_DESCRIPTION = "Job Description";
	protected static final String JOB_POSTING_EMPLOYER = "Posting employer";
	protected static final String JOB_AVAILIBILITY = "isAvailible";
	protected static final String JOB_VISIBILITY = "isVisible";
	protected static final String JOB_APPLICANTS = "Applicants";

	// Account
	protected static final String USER_EMAIL = "Email";
	protected static final String USER_PASSWORD = "Password";
	protected static final String USER_ACCOUNT_TYPE = "AccountType";
	protected static final String USER_RESUME_UUID = "Resume UUID";
	protected static final String USER_JOB_UUID = "Job UUID";
	protected static final String USER_NAME = "Name";
	protected static final String USER_EXTERNAL_DOCUMENTS = "External Documents";

	// Resume
	protected static final String RESUME_NAME = "name";
	protected static final String RESUME_GRADUATION_DATE = "Graduation Date";
	protected static final String RESUME_MAJOR = "Major";
	protected static final String RESUME_GPA = "GPA";
	protected static final String RESUME_EXPERIENCE = "Experiences";
	protected static final String RESUME_SKILLS = "Skills";
}