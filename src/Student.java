package src;
import java.util.ArrayList;
public class Student {
    private String name;
    private Resume Resume;
    private ArrayList<String> ExternalDocuments;
    private ArrayList<Jobs>  SubmittedApplications;
    private ArrayList<Integer> Ratings;
    public Student(String Name, Resume resume, ArrayList<String> externalDocuments){
    
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
    public void setName(Account currentUser, String name){
        if(currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT){
            this.name = name;

        }
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
         return SubmittedApplications;
    }

    public void addRating(int rating){

    }
    public double getAvgRating(){
        return
    }
}
