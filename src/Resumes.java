package src;
import java.util.ArrayList;
import java.util.UUID;

public class Resumes {
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

	public boolean haveResume(UUID resIDU) {
		for(Resume resume : resumeList) {
			if(resume.getId().equals(resIDU)) {
				return true;
			}
		}
		return false;
	}
	
	public Resume getResume(String resumeName) {
		for(Resume resume : resumeList) {
			if(resume.getName().equals(resumeName)) {
				return resume;
			}
		}
		return null;
	}
	
	public ArrayList<Resume> getResumes() {
		return resumeList;
	}
	
	public boolean addResume(Resume resume) {
		if(haveResume(resume.getId())){
			return false;
		}
		resumeList.add(resume);
		return true;
	}
	
	public void saveResumes() {
		DataWriter.saveResumes();
	}
}