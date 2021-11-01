package src;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{

	public static ArrayList<Account> getAccounts() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try {
			FileReader reader = new FileReader(ACCOUNTS_FILE_NAME);
			JSONArray accountsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < accountsJSON.size(); i++) {
				JSONObject accountJSON = (JSONObject)accountsJSON.get(i);
				UUID id = UUID.fromString((String)accountJSON.get(ACCOUNT_UUID));
				String email = (String)accountJSON.get(USER_EMAIL);
				String password = (String)accountJSON.get(USER_PASSWORD);
				AccountType userAccountType = AccountType.valueOf((String)accountJSON.get(USER_ACCOUNT_TYPE));
				
				if(userAccountType == AccountType.ACCOUNT_TYPE_ADMIN) {
					accounts.add(new Admin(id, email, password));
					
				} else if(userAccountType == AccountType.ACCOUNT_TYPE_STUDENT) {
					String name = (String)accountJSON.get(USER_NAME);
					UUID resumeID = UUID.fromString((String)accountJSON.get(USER_RESUME_UUID));
					
					JSONArray externalDocs = (JSONArray)accountJSON.get(USER_EXTERNAL_DOCUMENTS);
					ArrayList<String> externalDocuments = new ArrayList<String>();
					for(int j=0; j < externalDocs.size(); j++) {
						externalDocuments.add((String)externalDocs.get(j));
					}

					JSONArray Ratings = (JSONArray)accountJSON.get(STUDENT_RATINGS);
					ArrayList<Double> ratings = new ArrayList<Double>();
					for(int j=0; j < Ratings.size(); j++) {
						ratings.add((Double)Ratings.get(j));
					}
					
					ArrayList<Resume> resumes = getResumes();
					for(Resume resume : resumes) {
						if(resume.getId().equals(resumeID)) {
							accounts.add(new Student(id, name, email, password, resume, externalDocuments, ratings));
						}
					}
				} else if(userAccountType == AccountType.ACCOUNT_TYPE_EMPLOYER) {
					String companyName = (String)accountJSON.get(COMPANY_NAME);
					String companyWebsite = (String)accountJSON.get(COMPANY_WEBSITE);
					String companyDescription = (String)accountJSON.get(COMPANY_DESCRIPTION);
					JSONArray compnayRatings = (JSONArray)accountJSON.get(EMPLOYER_RATINGS);
					ArrayList<Double> ratings = new ArrayList<Double>();
					for(int j=0; j < compnayRatings.size(); j++) {
						ratings.add((Double)compnayRatings.get(j));
					}
					
					accounts.add(new Employer(email, password, id, companyName, companyWebsite, companyDescription, ratings));
				
				}
				else {
					throw new Exception("Invalid account type");
				}
			}
			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static ArrayList<Resume> getResumes() {
		ArrayList<Resume> resumes = new ArrayList<Resume>();
		
		try {
			FileReader reader = new FileReader(RESUMES_FILE_NAME);
			JSONArray resumesJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < resumesJSON.size(); i++) {
				JSONObject resumeJSON = (JSONObject)resumesJSON.get(i);
				UUID id = UUID.fromString((String)resumeJSON.get(RESUME_UUID));
				String name = (String)resumeJSON.get(RESUME_NAME);
				String graduationDate = (String)resumeJSON.get(RESUME_GRADUATION_DATE);
				Majors major = Majors.valueOf((String)resumeJSON.get(RESUME_MAJOR));
				double gpa = (double)resumeJSON.get(RESUME_GPA);
				
				ArrayList<String> skills = new ArrayList<String>();
				JSONArray skillsJSON = (JSONArray)resumeJSON.get(RESUME_SKILLS);
				for(int j = 0; j<skillsJSON.size(); j++) {
					skills.add((String)skillsJSON.get(j));
				}
				
				ArrayList<String> experience = new ArrayList<String>();
				JSONArray experienceJSON = (JSONArray)resumeJSON.get(RESUME_EXPERIENCE);

				for(int j = 0; j<experienceJSON.size(); j++) {
					experience.add((String)experienceJSON.get(j));
				}
				
				resumes.add(new Resume(id, name, graduationDate, major, gpa, experience, skills));
			}
			return resumes;

		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Job> getJobs() {
		ArrayList<Job> jobs = new ArrayList<Job>();
		
		try {
			FileReader reader = new FileReader(JOBS_FILE_NAME);
			JSONArray jobsJSON = (JSONArray)new JSONParser().parse(reader);
			ArrayList<Account> existingUsers = getAccounts();
			ArrayList<Student> existingStudents = new ArrayList<Student>();
			for(Account account : existingUsers) {
				if(account.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT) {
					existingStudents.add((Student)account);
				}
			}
			ArrayList<Employer> existingEmployers = new ArrayList<Employer>();
			for(Account account : existingUsers) {
				if(account.getAccountType() == AccountType.ACCOUNT_TYPE_EMPLOYER) {
					existingEmployers.add((Employer)account);
				}
			}

			for(int i=0; i < jobsJSON.size(); i++) {
				JSONObject jobJSON = (JSONObject)jobsJSON.get(i);
				UUID id = UUID.fromString((String)jobJSON.get(JOB_UUID));
				String name = (String)jobJSON.get(JOB_NAME);
				String description = (String)jobJSON.get(JOB_DESCRIPTION);
				Boolean avalibility = Boolean.parseBoolean((String)jobJSON.get(JOB_AVAILIBILITY));
				Boolean visibility = Boolean.parseBoolean((String)jobJSON.get(JOB_VISIBILITY));
				
				UUID postingEmployerUUID = UUID.fromString((String)jobJSON.get(JOB_POSTING_EMPLOYER));
				Account postingEmployer = null;
				for(Employer employer : existingEmployers) {
					if(employer.getId().equals(postingEmployerUUID)) {
						postingEmployer = employer;
					}
				}
				
				ArrayList<String> applicantIDs = (ArrayList<String>)jobJSON.get(JOB_APPLICANTS);
				ArrayList<Student> applicants = new ArrayList<Student>();
				for(String applicantID : applicantIDs) {
					for(Student student : existingStudents){
						if(student.getId().equals(UUID.fromString(applicantID))) {
							applicants.add(student);
						}
					}
				}

				jobs.add(new Job(id, name, description, postingEmployer, applicants, avalibility, visibility));
			}
			return jobs;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}