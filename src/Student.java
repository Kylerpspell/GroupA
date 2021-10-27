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
	
	public Student(UUID id, String name, String password, String email, Resume resume, ArrayList<String> externalDocuments, ArrayList<Double> ratings) {
        this.id = UUID.randomUUID();
		this.password = null;
		this.email = null;
		this.UserAccountType = AccountType.ACCOUNT_TYPE_STUDENT;
		this.name = name;
		this.Resume = resume;
		this.ExternalDocuments = externalDocuments;
		this.Ratings = ratings;
    }

    public String getName(Account currentUser ){
		return this.name;
    }
    public Resume getResume() {
        return this.Resume;
        
    }
    public void setResume(Account currentUser, Resume resume){
        if(currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT){
            this.Resume = resume;
            /*
            takes given resume in parameter and sets it to current resume
             */
        }
    }
    public void setName(String name){
            this.name = name;
                        /*
            takes given name in parameter and sets it to current name
             */
        }

    public void addExternalDocument(String document) {
        ExternalDocuments.add(document);
        /*
        takes in document and adds it to array list of external documents
         */
    }
    public void removeExternalDocument(String document){
        ExternalDocuments.remove(document);
                /*
        takes in document and removes it from array list of external documents
         */
    }
	
    public String getExternalDocuments(){
        for(int i=0; i < ExternalDocuments.size();i++){
            return ExternalDocuments.get(i);
        }
        /*
        returns full list of external documents
         */

        //TEMP
        return "";
    }

    public ArrayList<Job> getSubmittedApplications(){
        ArrayList<Job> submittedApplications = new ArrayList<Job>();
		/*
		//TODO - implement this method
		returns list of jobs that the student has submitted an application to
		 */
		return submittedApplications;
    }

    public void addRating(double rating, Employer employerAccount){

    }
    public double getAvgRating(){
        int ratingSum = 0;
				for(int i = 0; i < Ratings.size(); i++){
			ratingSum += Ratings.get(i);
		}
		return ratingSum / Ratings.size();
	}

	public void removeRating(double rating, Employer employerAccount){
		Ratings.remove(rating);
		/*
		removes rating from list
		 */
	}
	public void addRating(double rating){
		Ratings.add(rating);
		/*
		adds rating to list
		 */
	}

	public void setRatings(ArrayList<Double> ratings){
        for (int i = 0; i < ratings.size(); i++) {

            Ratings.set(i, ratings.get(i));
		/*
		sets the list of ratings in parameter to current list of ratings
		 */
        }
    }

	public void setExternalDocuments(ArrayList<String> externalDocuments){
        for (int i = 0; i < externalDocuments.size(); i++) {

            ExternalDocuments.set(i, externalDocuments.get(i));
		/*
		sets the list of external documents in parameter to current list of external documents
		 */
        }
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
			this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
			this.email = email;
	}

	public AccountType getAccountType() {
		return UserAccountType;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", password=" + password + ", email=" + email + ", UserAccountType="
				+ UserAccountType + "]";
	}

}

