package src;
import java.util.ArrayList;
public class Student extends Account{
    private String name;
    private Resume Resume;
    private ArrayList<String> ExternalDocuments;
    private ArrayList<Jobs>  SubmittedApplications;
    private ArrayList<Double> Ratings;
    public Student(String Name){
        this.setName(Name);
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
        }
    }
    public void setName(String name){
            this.name = name;

        }

    public void addExternalDocument(String document) {
        ExternalDocuments.add(document);
        
    }
    public void removeExternalDocument(String document){
        ExternalDocuments.remove(document);
    }
	
    public ArrayList<String> getExternalDocuments(){
        return ExternalDocuments;
        
    }

    public ArrayList<Jobs> getSubmittedApplications(){
         return SubmittedApplications;
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
	public void addSubmittedApplication(Jobs job){
		SubmittedApplications.add(job);
	}
	public void removeSubmittedApplication(Jobs job){
		SubmittedApplications.remove(job);
	}
	public void removeRating(double rating, Employer employerAccount){
		Ratings.remove(rating);
	}
	public void addRating(double rating){
		Ratings.add(rating);
	}
	public void removeRating(double rating){
		Ratings.remove(rating);
	}
	public void setSubmittedApplications(ArrayList<Jobs> submittedApplications){
		SubmittedApplications = submittedApplications;
	}
	public void setRatings(ArrayList<Double> ratings){
		Ratings = ratings;
	}
	public void setExternalDocuments(ArrayList<String> externalDocuments){
		ExternalDocuments = externalDocuments;
	}
}
