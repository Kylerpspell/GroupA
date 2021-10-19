package src;
import java.util.ArrayList;
import java.util.UUID;

public class Resumes {
	static final Account WRITER_ACCOUNT = new Account(UUID.randomUUID(), "password", "admin@email.sc.edu", AccountType.ACCOUNT_TYPE_ADMIN);
	private static Resumes resumes;
	private ArrayList<Resume> resumeList;
	
	private Resumes() {
		resumeList = DataLoader.getResumes();
	}
	
	public static Resumes getInstance() {
		if(resumes == null) {
			resumes = new Resumes();
		}
		
		return resumes;
	}

	public boolean haveResume(String resumeName) {
		for(Resume resume : resumeList) {
			if(resume.getName(WRITER_ACCOUNT).equals(resumeName)) {
				return true;
			}
		}
		return false;
	}
	
	public Resume getResume(String resumeName) {
		for(Resume resume : resumeList) {
			if(resume.getName(WRITER_ACCOUNT).equals(resumeName)) {
				return resume;
			}
		}
		return null;
	}
	
	public ArrayList<Resume> getResumes() {
		return resumeList;
	}
	
	public boolean addResume(Resume resume) {
		if(haveResume(resume.getName(WRITER_ACCOUNT))){
			return false;
		}
		resumeList.add(resume);
		return true;
	}
	
	public void saveResumes() {
		DataWriter.saveResumes();
	}
}