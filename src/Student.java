package src;
import java.util.ArrayList;
public class Student {
    private String name;
    private Resume Resume;
    private ArrayList<String> ExternalDocuments;
    private ArrayList<Job>  SubmittedApplications;
    private ArrayList<Integer> Ratings;
    public Student(String Name, Resume resume, ArrayList<String> externalDocuments){

    }
    public String getName(Account currentUser){
        return "null";
    }
    public void/*change return type to Resume*/ getResume(Account currentUser){

    }
    public void setResume(Account currentUser, Resume resume){

    }
    public void setName(Account currentUser, String name){

    }
    public void addExternalDocument(Account currentUser, String document){

    }
    public void removeExternalDocument(Account currentUser, String document){

    }
    public ArrayList<String> getExternalDocuments(Account currentUser){
        ArrayList<String> placeholder = new ArrayList<String>();
        return placeholder;
    }

    public ArrayList<Jobs> getSubmittedApplications(Account currentUser){
         ArrayList<Jobs> placeholder = new ArrayList<Jobs>();
         return placeholder;
    }

    public void addRating(int rating){

    }
    public double getAvgRating(){
        return 0.0;
    }
}
