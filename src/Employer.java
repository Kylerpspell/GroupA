package src;
public class Employer {
    Resume resume;
    Job job;

    Employer(){
        this.resume = null;
        this.job = null;
    }

    Employer(Resume resume, Job job){
        this.resume = resume;
        this.job = job;
    }

    public Resume getResume(){
        return this.resume;
    }

    public Job getJob(){
        return this.job;
    }

    public void logIn(Account currentUser){

    }

    public void createJob(Job job){

    }

    public void editJob(Job job){
        Job setAvailability;
        Job setVisibility;
        Job setJobTitle;
        Job setJobDescription;
        Job setPostingEmployee;
    }

    public void removeJobListing(Job job){

    }

    public void acceptResume(Account currentUser, Resume resume, Student student){

    }

    public void denyResume(Account currentUser, Resume resume, Student student){

    }

    
}
