package src;
import java.util.ArrayList;
public class Student extends Account{
    private String name;
    private Resume Resume;
    private ArrayList<String> ExternalDocuments;
    private ArrayList<Jobs>  SubmittedApplications;
    private ArrayList<Integer> Ratings;
    public Student(String Name){
        this.setName(Name);
    }
    public String getName(Account currentUser ){
        if(currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT ) {
            return this.name;
        }
    }
    public Resume getResume(Account currentUser) {
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT) {
            return this.Resume;
        }
    }
    public void setResume(Account currentUser, Resume resume){
        if(currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT){
            this.Resume = resume;
        }
    }
    public void setName(String name){
            this.name = name;

        }

    public void addExternalDocument(Account currentUser, String document) {
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT) {
            ExternalDocuments.add(document);
        }
    }
    public void removeExternalDocument(Account currentUser, String document){
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT) {
            ExternalDocuments.remove(document);
        }

    }
    public ArrayList<String> getExternalDocuments(Account currentUser){
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT) {
            return ExternalDocuments;
        }
    }

    public ArrayList<Jobs> getSubmittedApplications(Account currentUser){
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT)
         return SubmittedApplications;
    }

    public void addRating(double rating, Employer employerAccount){
           
    }
    public double getAvgRating(){
         return
    }
}
