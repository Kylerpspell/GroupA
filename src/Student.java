package src;
import java.util.ArrayList;
import java.util.UUID;

public class Student implements Account{
	private UUID id;
	private String password;
	private String email;
	private AccountType UserAccountType;
	private String name;
    private Resume Resume;
    private ArrayList<String> ExternalDocuments;
    private ArrayList<Double> Ratings;

	/**
	 * constructs student and sets the instance variables to default values
	 */

	public Student(){
		this.id = UUID.randomUUID();
		this.password = null;
		this.email = null;
		this.UserAccountType = AccountType.ACCOUNT_TYPE_STUDENT;
		this.name = null;
		this.Resume = null;
		this.ExternalDocuments = null;
		this.Ratings = null;
	}

	/**
	 * parametized constructor for student that sets instance variables to speciied values
	 * @param id id number for student
	 * @param name name of student
	 * @param password password of student
	 * @param email email of student
	 * @param resume resume of student
	 * @param externalDocuments external docs of student
	 * @param ratings ratings of student
	 */
	public Student(UUID id, String name, String password, String email, Resume resume, ArrayList<String> externalDocuments, ArrayList<Double> ratings) {
        this.id = id;
		this.password = password;
		this.email = email;
		this.UserAccountType = AccountType.ACCOUNT_TYPE_STUDENT;
		this.name = name;
		this.Resume = resume;
		this.ExternalDocuments = externalDocuments;
		this.Ratings = ratings;
    }

	/**
	 * uses parameter to access name of student
	 * @param currentUser account of student
	 * @return name string
	 */
    public String getName(Account currentUser){
		return this.name;
    }

	/**
	 * accesses resume of student
	 * @return resume object
	 */

	public Resume getResume() {
        return this.Resume;
        
    }

	/**
	 * sets resume of student to specified value
	 * @param currentUser current account of student
	 * @param resume resume to be retrieved
	 */

    public void setResume(Account currentUser, Resume resume){
            this.Resume = resume;
    }

	/**
	 * sets name of student to specified value
	 * @param name name of student
	 */
	public void setName(String name){
            this.name = name;
    }

	/**
	 * adds external docs to list of strings
	 * @param document specified doc to be added
	 */

	public void addExternalDocument(String document) {
        if(document.startsWith("data/Documents/")){
			this.ExternalDocuments.add(document);
		}
	}

	/**
	 * removes doc from list of strings
	 * @param document specified doc to be removed
	 */

    public void removeExternalDocument(String document){
        for(int i = 0; i < this.ExternalDocuments.size(); i++){
			if(this.ExternalDocuments.get(i).equals(document)){
				this.ExternalDocuments.remove(i);
			}
		}
    }

	/**
	 * accesses and retrieves external docs of student
	 * @return export of external docs
	 */

	public ArrayList<String> getExternalDocuments(){
		ArrayList<String> exportExternalDocuments = this.ExternalDocuments;
		return exportExternalDocuments;
    }

	/**
	 * looks at arraylist of job applicants and sees if any jobs contain matching info and if so, it is added to array
	 * list of
	 * submitted applications
	 * @return arraylist submitted applications
	 */

	public ArrayList<Job> getSubmittedApplications(){
        ArrayList<Job> submittedApplications = new ArrayList<Job>();
		
		ArrayList<Job> allJobs = DataLoader.getJobs();
		for(Job job : allJobs){
			if(job.getApplicants().contains(this)){
				submittedApplications.add(job);
			}
		}

		return submittedApplications;
    }

	/**
	 *if rating is valid, it is added to employer's account
	 * @param rating rating to be added
	 * @param employerAccount locates employer's account
	 */

    public void addRating(double rating, Employer employerAccount){
		if(rating > 0 && rating <= 5){
			employerAccount.addRating(rating);
		}
    }

	/**
	 * goes through array list of ratings to sum, divide and calulate average rating
	 * @return returns the average of all ratings in list
	 */

	public double getAvgRating(){
        int ratingSum = 0;
				for(int i = 0; i < Ratings.size(); i++){
			ratingSum += Ratings.get(i);
		}
		return ratingSum / Ratings.size();
	}

	/**
	 * removes rating from list
	 * @param rating the rating to be removed
	 * @param employerAccount uses to locate employer's account
	 */

	public void removeRating(double rating, Employer employerAccount){
		Ratings.remove(rating);

	}

	/**
	 * adds rating to list
	 * @param rating sepcified rating to be added
	 */

	public void addRating(double rating){
		Ratings.add(rating);
	}
	//TODO javadoc
	public ArrayList<Double> getRatings(){
		return this.Ratings;
	}

	/**
	 * sets the list of ratings in parameter to current list of ratings
	 * @param ratings the value that the ratings will be set to
	 */

	public void setRatings(ArrayList<Double> ratings){
        for (int i = 0; i < ratings.size(); i++) {

            Ratings.set(i, ratings.get(i));
        }
    }

	/**
	 * sets the list of external documents in parameter to current list of external documents
	 * @param externalDocuments the value that the external documents will be set to
	 */

	public void setExternalDocuments(ArrayList<String> externalDocuments){
        for (int i = 0; i < externalDocuments.size(); i++) {

            ExternalDocuments.set(i, externalDocuments.get(i));
        }
	}

	/**
	 * retrieves password string
	 * @return returns password string
	 */

	public String getPassword() {
		return password;
	}


	/**
	 * sets password to parameter
	 * @param password specified password to be set
	 */

	public void setPassword(String password) {
			this.password = password;
	}

	/**
	 * retrieves email
	 * @return string email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * sets email to parameter
	 * @param email email to be set
	 */

	public void setEmail(String email) {
			this.email = email;
	}

	/**
	 * retrieves account type
	 * @return returns the account type of current user
	 */

	public AccountType getAccountType() {
		return UserAccountType;
	}

	/**
	 * retrieves id
	 * @return identification number
	 */

	public UUID getId() {
		return id;
	}

	/**
	 * Appends student info to make string representation of student
	 * @return the compiled string 
	 */

	//TODO Format this better
	@Override
	public String toString() {
		return "Student [id=" + id + ", password=" + password + ", email=" + email + ", UserAccountType="
				+ UserAccountType + "]";
	}

	@Override
	public Employer getEmployer() {
		return null;
	}

	@Override
	public Student getStudent() {
		return this;
	}

	@Override
	public Admin getAdmin() {
		return null;
	}
}

