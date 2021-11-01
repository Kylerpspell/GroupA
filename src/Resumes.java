package src;
import java.util.ArrayList;
import java.util.UUID;

public class Resumes {
	private static Resumes resumes;
	private ArrayList<Resume> resumeList;

	/**
	 * initializes resume list
	 */

	private Resumes() {
		resumeList = DataLoader.getResumes();
	}

	/**
	 * creates resume instance if not already populated
	 * @return returns the resume objects
	 */

	public static Resumes getInstance() {
		if(resumes == null) {
			resumes = new Resumes();
		}
		
		return resumes;
	}

	public ArrayList<Resume> getResumeList() {
		return resumeList;
	}

	/**
	 * checks to verify the user's id is assoicated with a resume
	 * @param resIDU the number id for user's account
	 * @return returns either true or false
	 */

	public boolean haveResume(UUID resIDU) {
		for(Resume resume : resumeList) {
			if(resume.getId().equals(resIDU)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * looks at every resume in resume list until a matching name is found
	 * @param resumeName variable for resume name
	 * @return returns the resume with matching name or null
	 */

	public Resume getResume(String resumeName) {
		for(Resume resume : resumeList) {
			if(resume.getName().equals(resumeName)) {
				return resume;
			}
		}
		return null;
	}

	/**
	 * retrieves the list of resumes
	 * @return an arraylist of resumes
	 */

	public ArrayList<Resume> getResumes() {
		return resumeList;
	}

	/**
	 * adds specified resume to list if not already added
	 * @param resume the specified resume to be added
	 * @return true or false
	 */
	public boolean addResume(Resume resume) {
		if(haveResume(resume.getId())){
			return false;
		}
		resumeList.add(resume);
		return true;
	}
	

	/**
	 * access datawriter to save resume
	 */

	public void saveResumes() {
		DataWriter.saveResumes();
	}
}