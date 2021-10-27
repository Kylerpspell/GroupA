package src;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
public class InterfaceManager {
    
    public static InterfaceManager interfaceManager;
    private DatabaseManager database;
    private Account currentUser;

    public InterfaceManager(DatabaseManager database) {
        this.database = database;
    }
    public static InterfaceManager getInstance(DatabaseManager database) {
        if (interfaceManager == null) {
            interfaceManager = new InterfaceManager(database);
        }
        return interfaceManager;
    }
    public void login(String email, String password) {
        Scanner key = new Scanner(System.in);
        boolean login = true;
        while(!login) {
            System.out.println("Please enter the email for the account.");
            if (email.equalsIgnoreCase(key.nextLine())) {
                System.out.println("Please enter the Password for the account.");
                if (email.equalsIgnoreCase(key.nextLine())) {
                    login = true;
                    System.out.println("Successful login");
                }
                else{
                    System.out.println("Password incorrect. Please re-enter login information.");
                    login = false;
                }
            }
            else {
                System.out.println("Email incorrect. Please re-enter login information.");
                login = false;
            }
        }

    }
    public void logout() {
        
    }
    public Account createAccount() {
        Scanner key = new Scanner(System.in);
        AccountType accountType = null;
        System.out.println("What type of account would you like to create?  \nEnter the appropriate number for your selection. \n1. Student \n2. Employer \n3. Application Administrator");
        switch (key.nextInt()) {
            case 1: 
                accountType = AccountType.ACCOUNT_TYPE_STUDENT;
                break;
            case 2:
                accountType = AccountType.ACCOUNT_TYPE_EMPLOYER;
                break;
            case 3:
                accountType = AccountType.ACCOUNT_TYPE_ADMIN;
                break;
        }
        boolean validEmail = true;
        String email = "";
        do {
        System.out.println("Please enter a valid email for the account");
        email = key.nextLine();
        int sub = email.length() - "sc.edu".length();
        if (!email.substring(sub).equalsIgnoreCase("sc.edu")) {
            System.out.println("Invalid email, please re-enter.");
            validEmail = false;
        }
        } while (!validEmail);
        System.out.println("Please enter a password for the account");
        String password = key.nextLine();
		UUID id = UUID.randomUUID();
        return new Account(id, password, email, accountType);
    }
    public Job createJob() {
        Scanner key = new Scanner(System.in);
        System.out.println("Please enter a job title for this listing.");
        String jobTitle = key.nextLine();
        System.out.println("Please enter a job description for this listing.");
        String jobDescription = key.nextLine();
        System.out.println("Would you like this listing to be available for application?. \nEnter the appropriate number for your selection. \n1. Yes \n2. No");
        boolean isAvailable = false;
        if (key.nextInt() == 1) {
            key.nextLine();
            isAvailable = true;
        }
        System.out.println("Would you like this listing to be available for viewing?. \nEnter the appropriate number for your selection. \n1. Yes \n2. No");
        boolean isVisible= false;
        if (key.nextInt() == 1) {
            key.nextLine();
            isVisible = true;
        }
		UUID tempid = UUID.randomUUID();
        return new Job(tempid, jobTitle, jobDescription, currentUser, new ArrayList<Account>(), isAvailable, isVisible);
    }
    public void viewJobs() {

    }
    public void viewApplicants( Job job) {
        System.out.println("Applicants:");
        for (Account applicant : job.getApplicants()) {
            System.out.println(applicant.toString());
        }
    }
    public void viewResume(Student applicant) {
        System.out.println(applicant.getResume().toString());
    }
    public void sortJobs(Job job) {

    }
    public void sortApplicants( Job job) {

    }
 }
