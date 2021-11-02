package src;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

	/**
	 * saves accounts, jobs and resumes
	 */

	public static void writeAll() {
		saveAccounts();
		saveJobs();
		saveResumes();
	}

	/**
	 * Retrieves current instance of accounts and saves them by writing them to json array
	 */

	public static void saveAccounts() {
		Accounts accounts = Accounts.getInstance();
		ArrayList<Account> accountList = accounts.getAccountList();

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

	/**
	 * Retrieves current instance of jobs and saves them by writing them to json array
	 */

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

	/**
	 * Retrieves current instance of resumes and saves them by writing them to json array
	 */

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

	/**
	 * Creates and saves account portfolio based on several attributes
	 * @param account the account to be used
	 * @return returns json account and its info
	 */

	public static JSONObject getAccountJSON(Account account) {	
		JSONObject accountDetails = new JSONObject();
		accountDetails.put(USER_ACCOUNT_TYPE, account.getAccountType().toString());
		accountDetails.put(USER_EMAIL, account.getEmail());
		accountDetails.put(USER_PASSWORD, account.getPassword());
		accountDetails.put(ACCOUNT_UUID, account.getId().toString());
		if(account.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT) {
			Student accountStudent = account.getStudent();
			accountDetails.put(USER_RESUME_UUID, accountStudent.getResume().getId().toString());
			
			JSONArray jsonRatings = new JSONArray();
			for(int i=0; i<accountStudent.getRatings().size(); i++) {
				jsonRatings.add(accountStudent.getRatings().get(i));
			}
			accountDetails.put(STUDENT_RATINGS, jsonRatings);

			accountDetails.put(USER_NAME, accountStudent.getResume().getName());
			
			JSONArray jsonExternalDocs = new JSONArray();
			for(int i=0; i<accountStudent.getExternalDocuments().size(); i++) {
				jsonExternalDocs.add(accountStudent.getExternalDocuments().get(i));
			}
			accountDetails.put(USER_EXTERNAL_DOCUMENTS, jsonExternalDocs);
		}
		if(account.getAccountType() == AccountType.ACCOUNT_TYPE_EMPLOYER) {
			Employer accountEmployer = account.getEmployer();
			accountDetails.put(COMPANY_NAME, accountEmployer.getCompanyName());
			accountDetails.put(COMPANY_DESCRIPTION, accountEmployer.getCompanyDescription());
			accountDetails.put(COMPANY_WEBSITE, accountEmployer.getCompanyWebsite());

			JSONArray ratings = new JSONArray();
			for(int i=0; i<accountEmployer.getRatings().size(); i++) {
				ratings.add(accountEmployer.getRatings().get(i));
			}
			accountDetails.put(EMPLOYER_RATINGS, ratings);
		}
        return accountDetails;
	}

	/**
	 * Creates and saves resume portfolio based on several attributes
	 * @param resume the resume to be used
	 * @return returns json resume and its info
	 */

	public static JSONObject getResumeJSON(Resume resume) {
		JSONObject resumeDetails = new JSONObject();
		//resumeDetails.put(RESUME_UUID, resume.getUUID(WRITER_ACCOUNT));
		resumeDetails.put(RESUME_NAME, resume.getName());
		resumeDetails.put(RESUME_GRADUATION_DATE, resume.getGraduationDate());
		resumeDetails.put(RESUME_MAJOR, resume.getMajor().toString());
		resumeDetails.put(RESUME_GPA, resume.getGPA());
		resumeDetails.put(RESUME_EXPERIENCE, resume.getExperiences());
		resumeDetails.put(RESUME_SKILLS, resume.getSkills());
		resumeDetails.put(RESUME_UUID, resume.getId().toString());
		
		return resumeDetails;
	}

	/**
	 * Creates and saves job based on several attributes
	 * @param job the job to be used
	 * @return returns json job and its info
	 */
	public static JSONObject getJobJSON(Job job) {
		JSONObject jobDetails = new JSONObject();
		jobDetails.put(JOB_UUID, job.getID().toString());
		jobDetails.put(JOB_NAME, job.getJobTitle());
		jobDetails.put(JOB_DESCRIPTION, job.getJobDescription());
		jobDetails.put(JOB_AVAILIBILITY, Boolean.toString(job.checkAvailability()));
		jobDetails.put(JOB_VISIBILITY, Boolean.toString(job.checkVisibility()));
		JSONArray applicantIDs = new JSONArray();
		for(Account applicant : job.getApplicants()){
			applicantIDs.add(applicant.getId().toString());
		}
		String peUUID = job.getPostingEmployer().getId().toString();
		jobDetails.put(JOB_POSTING_EMPLOYER, peUUID);
		jobDetails.put(JOB_APPLICANTS, applicantIDs);
		
		return jobDetails;
	}
}