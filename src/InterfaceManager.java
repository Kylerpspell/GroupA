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
        System.out.println("What type of account would you like to create?  \nEnter the appropriate number for your selection. \n1. Student \n2. Employer \n3. Application Administrator");
        Account account = null;
		switch (key.nextInt()) {
            case 1: 
				account = createStudent(key);
                break;
            case 2:
				account = createEmployer(key);
                break;
            case 3:
				account = createAdmin(key);
                break;
		}
		return account;
    }

	public Student createStudent(Scanner key) {
		System.out.println("Please enter your name.");
		String name = key.nextLine();
		System.out.println("Please enter your email.");
		//TODO Email checks
		String email = key.nextLine();
		//TODO Password checks
		System.out.println("Please enter your password.");
		String password = key.nextLine();
		Resume newResume = createResume();
		ArrayList<String> documents = new ArrayList<String>();
		ArrayList<Double> ratings = new ArrayList<Double>();
		
		return new Student(UUID.randomUUID(), name, password, email, newResume, documents, ratings);
	}

	public Employer createEmployer(Scanner key) {
		System.out.println("Please enter your company name.");
		String name = key.nextLine();
		System.out.println("Please enter your email.");
		//TODO Email checks
		String email = key.nextLine();
		//TODO Password checks
		System.out.println("Please enter your password.");
		String password = key.nextLine();
		System.out.println("Please enter your company website.");
		//TODO Website checks
		String website = key.nextLine();
		System.out.println("Please enter your company description.");
		String description = key.nextLine();

		return new Employer(email, password, UUID.randomUUID(), name, website, description);
	}

	public Admin createAdmin(Scanner key) {
		System.out.println("Please enter your email.");
		//TODO Email checks
		String email = key.nextLine();
		//TODO Password checks
		System.out.println("Please enter your password.");
		String password = key.nextLine();

		return new Admin(UUID.randomUUID(), email, password);
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

	public Resume createResume() {
		//TODO create user interface for this
		UUID tempid = UUID.randomUUID();
		String name = "";
		String graduationDate = "";
		Majors major = null;
		double GPA = 0;
		ArrayList<String> skills = new ArrayList<String>();
		ArrayList<String> experience = new ArrayList<String>();

		return new Resume(tempid, name, graduationDate, major, GPA, skills, experience);
	}
 }
