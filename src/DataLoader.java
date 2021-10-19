package src;
import java.io.FileReader;
import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{

	public static ArrayList<Account> getAccounts() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try {
			FileReader reader = new FileReader(ACCOUNTS_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray accountsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < accountsJSON.size(); i++) {
				JSONObject accountJSON = (JSONObject)accountsJSON.get(i);
				UUID id = UUID.fromString((String)accountJSON.get(ACCOUNT_UUID));
				String email = (String)accountJSON.get(USER_EMAIL);
				String password = (String)accountJSON.get(USER_PASSWORD);
				UUID resumeUuid = UUID.fromString((String)accountJSON.get(USER_RESUME_UUID));
				AccountType userAccountType = AccountType.valueOf((String)accountJSON.get(USER_ACCOUNT_TYPE));
				
				accounts.add(new Account(password, email, userAccountType));
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
			JSONParser parser = new JSONParser();	
			JSONArray resumesJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < resumesJSON.size(); i++) {
				JSONObject resumeJSON = (JSONObject)resumesJSON.get(i);
				UUID id = UUID.fromString((String)resumeJSON.get(ACCOUNT_UUID));
				String name = (String)resumeJSON.get(RESUME_NAME);
				Date graduationDate = (Date)resumeJSON.get(RESUME_GRADUATION_DATE);
				Majors major = Majors.valueOf((String)resumeJSON.get(RESUME_MAJOR));
				double gpa = (double)resumeJSON.get(RESUME_GPA);
				ArrayList<String> skills = (ArrayList<String>)resumeJSON.get(RESUME_SKILLS);
				ArrayList<String> experience = (ArrayList<String>)resumeJSON.get(RESUME_EXPERIENCE);


				resumes.add(new Resume(name, graduationDate, major, gpa, experience, skills));
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
			JSONParser parser = new JSONParser();	
			JSONArray jobsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < jobsJSON.size(); i++) {
				JSONObject jobJSON = (JSONObject)jobsJSON.get(i);
				UUID id = UUID.fromString((String)jobJSON.get(JOB_UUID));
				String name = (String)jobJSON.get(JOB_NAME);
				String description = (String)jobJSON.get(JOB_DESCRIPTION);
				Account postingEmployer = (Account)jobJSON.get(JOB_POSTING_EMPLOYER);
				Boolean avalibility = (Boolean)jobJSON.get(JOB_AVAILIBILITY);
				Boolean visibility = (Boolean)jobJSON.get(JOB_VISIBILITY);
				ArrayList<Account> applicants = (ArrayList<Account>)jobJSON.get(JOB_APPLICANTS);

				jobs.add(new Job(name, description, postingEmployer, applicants, avalibility, visibility));
			}
			return jobs;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}