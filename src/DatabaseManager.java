package src;

import java.util.ArrayList;

public class DatabaseManager {
    public static DatabaseManager databaseManager;
    private ArrayList<Account> accounts;
    private ArrayList<Job> jobs;
    
    public DatabaseManager() {
        this.accounts = new ArrayList<Account>();
        this.jobs = new ArrayList<Job>();
    }
    public static DatabaseManager getInstance() {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager();
        }
        return databaseManager;
    }

    public ArrayList<Account> getAccounts(Account currentUser) {
        return this.accounts;
    }

    public ArrayList<Job> getJobs(Account currentUser) {
        return this.jobs;
    }

    public void addAccount(Account account, Account currentUser) {
        this.accounts.add(account);
    }

    public void addJob(Job job, Account currentUser) {
        this.jobs.add(job);
    }

    public void removeAccount(Account account, Account currentUser) {
        this.accounts.remove(account);
    }

    public void removeJob(Job job, Account currentUser) {
        this.jobs.remove(job);
    }

    public void updateAvailability(Account currentUser, Job jobToChange, boolean availabiltiy) {

    }

    public void updateVisibility(Account currentUser, Job jobToChange, boolean availabiltiy) {

    }

    public void changePassword(Account currentUser, Account account, String newPassword) {

    }
    public void addExternalDocument(Account currentUser, String documents) {

    }
    public void removeExternalDocument(Account currentUser, String documents) {

    }
}
