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

    public String getName(Account currentUser){
		return this.name;
    }
    public Resume getResume() {
        return this.Resume;
        
    }
    public void setResume(Account currentUser, Resume resume){
            this.Resume = resume;
    }

    public void setName(String name){
            this.name = name;
    }

    public void addExternalDocument(String document) {
        if(document.startsWith("data/Documents/")){
			this.ExternalDocuments.add(document);
		}
	}
			
    public void removeExternalDocument(String document){
        for(int i = 0; i < this.ExternalDocuments.size(); i++){
			if(this.ExternalDocuments.get(i).equals(document)){
				this.ExternalDocuments.remove(i);
			}
		}
    }
	
    public ArrayList<String> getExternalDocuments(){
		ArrayList<String> exportExternalDocuments = this.ExternalDocuments;
		return exportExternalDocuments;
    }

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

    public void addRating(double rating, Employer employerAccount){
		if(rating > 0 && rating <= 5){
			employerAccount.addRating(rating);
		}
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

