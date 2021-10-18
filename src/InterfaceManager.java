
public class InterfaceManager {
    
    private DatabaseManager database;
    private Account currentUser;

    public InterfaceManager(DatabaseManager database) {
        this.database = database;
    }
    public void login(String email, String password) {

    }
    public void logout() {

    }
    public Account createAccount(String email, String password, String accountType) {
        return new Account();
    }
    public Job createJob(Account currentUser, Account postingEmployer, boolean isAvailable, boolean isVisible) {
        return new Job(currentUser, "", "");
    }
    public void viewJobs(Account currentUser) {

    }
    public void viewApplicants(Account currentUser, Job job) {

    }
    public void viewResume(Account currentUser, Account applicant) {

    }
    public void sortJobs(Account currentUser, Job job) {

    }
    public void sortApplicants(Account currentUser, Job job) {

    }
 }
