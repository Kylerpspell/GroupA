package src;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	static final Account WRITER_ACCOUNT = new Account("password","admin@email.sc.edu",AccountType.ACCOUNT_TYPE_ADMIN);
	public static void saveAccounts() {
		Accounts accounts = Accounts.getInstance();
		ArrayList<Account> accountList = accounts.getAccounts();

		JSONArray jsonAccounts = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< accountList.size(); i++) {
			jsonAccounts.add(getAccountJSON(accountList.get(i)));
		}

		
		//Write JSON file
        try (FileWriter file = new FileWriter(ACCOUNTS_FILE_NAME)) {
 
            file.write(jsonAccounts.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void saveJobs() {
		Jobs jobs = Jobs.getInstance();
		ArrayList<Job> jobList = jobs.getJobs();

		JSONArray jsonJobs = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< jobList.size(); i++) {
			jsonJobs.add(getJobJSON(jobList.get(i)));
		}

		
		//Write JSON file
		try (FileWriter file = new FileWriter(JOBS_FILE_NAME)) {
 
			file.write(jsonJobs.toJSONString());
			file.flush();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveResumes(){
		Resumes resumes = Resumes.getInstance();
		ArrayList<Resume> resumeList = resumes.getResumes();

		JSONArray jsonResumes = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< resumeList.size(); i++) {
			jsonResumes.add(getResumeJSON(resumeList.get(i)));
		}

		
		//Write JSON file
		try (FileWriter file = new FileWriter(RESUMES_FILE_NAME)) {
 
			file.write(jsonResumes.toJSONString());
			file.flush();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JSONObject getAccountJSON(Account account) {	
		JSONObject accountDetails = new JSONObject();
		accountDetails.put(USER_ACCOUNT_TYPE, account.getAccountType());
		accountDetails.put(USER_EMAIL, account.getEmail(WRITER_ACCOUNT));
		accountDetails.put(USER_PASSWORD, account.getPassword(WRITER_ACCOUNT));
		if(account.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT) {
			//THESE ARE THE STUDENT FIELDS NEED STUDENT CLASS
			//accountDetails.put(USER_SUBMITTED_APPLICATIONS, account.getSubmittedApplications());
			//accountDetails.put(USER_RESUME_UUID, account.getResumeUUID());
			//accountDetails.put(USER_EXTERNAL_DOCUMENTS, account.getExternalDocuments());
		}
		if(account.getAccountType() == AccountType.ACCOUNT_TYPE_EMPLOYER) {
			//THESE ARE THE EMPLOYER FIELDS NEED EMPLOYER CLASS
			//accountDetails.put(USER_JOB_UUID, account.getJobUUID());
		}
        return accountDetails;
	}

	public static JSONObject getResumeJSON(Resume resume) {
		JSONObject resumeDetails = new JSONObject();
		//resumeDetails.put(RESUME_UUID, resume.getUUID(WRITER_ACCOUNT));
		resumeDetails.put(RESUME_NAME, resume.getName(WRITER_ACCOUNT));
		resumeDetails.put(RESUME_GRADUATION_DATE, resume.getGraduationDate(WRITER_ACCOUNT));
		resumeDetails.put(RESUME_MAJOR, resume.getMajor(WRITER_ACCOUNT));
		resumeDetails.put(RESUME_GPA, resume.getGPA(WRITER_ACCOUNT));
		resumeDetails.put(RESUME_EXPERIENCE, resume.getExperiences(WRITER_ACCOUNT));
		resumeDetails.put(RESUME_SKILLS, resume.getSkills(WRITER_ACCOUNT));
		
		return resumeDetails;
	}

	public static JSONObject getJobJSON(Job job) {
		JSONObject jobDetails = new JSONObject();
		//jobDetails.put(JOB_UUID, job.getUUID(WRITER_ACCOUNT));
		jobDetails.put(JOB_NAME, job.getJobTitle(WRITER_ACCOUNT));
		jobDetails.put(JOB_DESCRIPTION, job.getJobDescription(WRITER_ACCOUNT));
		jobDetails.put(JOB_AVAILIBILITY, job.checkAvailability(WRITER_ACCOUNT));
		jobDetails.put(JOB_VISIBILITY, job.checkVisibility(WRITER_ACCOUNT));
		jobDetails.put(JOB_POSTING_EMPLOYER, job.getPostingEmployer(WRITER_ACCOUNT));
		jobDetails.put(JOB_APPLICANTS, job.getApplicants(WRITER_ACCOUNT));
		
		return jobDetails;
	}
}