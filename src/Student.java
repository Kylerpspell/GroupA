package src;
import java.util.ArrayList;
import java.util.Random;

public class Student extends Account{
    private String name;
    private Resume Resume;
    private ArrayList<String> ExternalDocuments;
    private ArrayList<Job>  SubmittedApplications;
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
        ArrayList<Job> temp = new ArrayList<Job>();
        for(int i=0; i < SubmittedApplications.size();i++){
             temp.add(SubmittedApplications.get(i));
             /*
        returns full list of submitted applications
         */
        }
        //TEMP
        return temp;

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
	public void addSubmittedApplication(Job job){
		SubmittedApplications.add(job);
		/*
		adds job to array list of submitted applications
		 */
	}
	public void removeSubmittedApplication(Job job){
		SubmittedApplications.remove(job);
		/*
		removes job from array list of submitted applications
		 */
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
	public void setSubmittedApplications(ArrayList<Job> submittedApplications) {
        for (int i = 0; i < submittedApplications.size(); i++) {

            SubmittedApplications.set(i, submittedApplications.get(i));
		/*
		sets the list of submitted applications in parameter to current list of submitted applications
		 */
        }
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
	}

