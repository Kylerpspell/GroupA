package src;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
public class InterfaceManager {
    
    public static InterfaceManager interfaceManager;
    private DatabaseManager database;
    private Account currentUser;
	private Scanner keyboard;

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
        boolean login = true;
        while(!login) {
            System.out.println("Please enter the email for the account.");
            if (email.equalsIgnoreCase(keyboard.nextLine())) {
                System.out.println("Please enter the Password for the account.");
                if (email.equalsIgnoreCase(keyboard.nextLine())) {
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
        System.out.println("What type of account would you like to create?  \nEnter the appropriate number for your selection. \n1. Student \n2. Employer \n3. Application Administrator");
        Account account = null;
		switch (keyboard.nextInt()) {
            case 1: 
				account = createStudent();
                break;
            case 2:
				account = createEmployer();
                break;
            case 3:
				account = createAdmin();
                break;
		}
		return account;
    }

	public Student createStudent() {
		System.out.println("Please enter your name.");
		String name = keyboard.nextLine();
		System.out.println("Please enter your email.");
		String email;
		while(true) {
			email = keyboard.nextLine();
			if(DatabaseManager.validEmail(email)) {
				break;
			}
			else {
				System.out.println("Please enter a valid email.");
			}
		}

		System.out.println("Please enter your password.");
		String password;
		while(true) {
			password = keyboard.nextLine();
			if(DatabaseManager.validPassword(password)) {
				break;
			}
			else {
				System.out.println("Please enter a valid password.");
			}
		}

		Resume newResume = createResume();
		ArrayList<String> documents = new ArrayList<String>();
		ArrayList<Double> ratings = new ArrayList<Double>();
		
		return new Student(UUID.randomUUID(), name, password, email, newResume, documents, ratings);
	}

	public Employer createEmployer() {
		System.out.println("Please enter your company name.");
		String name = keyboard.nextLine();
		System.out.println("Please enter your email.");
		
		String email;
		while(true) {
			email = keyboard.nextLine();
			if(DatabaseManager.validEmail(email)) {
				break;
			}
			else {
				System.out.println("Please enter a valid email.");
			}
		}

		System.out.println("Please enter your password.");
		String password;
		while(true) {
			password = keyboard.nextLine();
			if(DatabaseManager.validPassword(password)) {
				break;
			}
			else {
				System.out.println("Please enter a valid password.");
			}
		}
		
		System.out.println("Please enter your company website.");
		String website;
		while(true) {
			website = keyboard.nextLine();
			if(!website.contains(".")) {
				System.out.println("Please enter a valid website.");
			}
			else {
				break;
			}
		}
		
		System.out.println("Please enter your company description.");
		String description = keyboard.nextLine();
		ArrayList<Double> ratings = new ArrayList<Double>();
		return new Employer(email, password, UUID.randomUUID(), name, website, description,ratings);
	}

	public Admin createAdmin() {
		System.out.println("Please enter your email.");
		String email;
		while(true) {
			email = keyboard.nextLine();
			if(DatabaseManager.validEmail(email)) {
				break;
			}
			else {
				System.out.println("Please enter a valid email.");
			}
		}

		System.out.println("Please enter your password.");
		String password;
		while(true) {
			password = keyboard.nextLine();
			if(DatabaseManager.validPassword(password)) {
				break;
			}
			else {
				System.out.println("Please enter a valid password.");
			}
		}


		return new Admin(UUID.randomUUID(), email, password);
	}

    public Job createJob() {
        System.out.println("Please enter a job title for this listing.");
        String jobTitle = keyboard.nextLine();
        System.out.println("Please enter a job description for this listing.");
        String jobDescription = keyboard.nextLine();
        System.out.println("Would you like this listing to be available for application?. \nEnter the appropriate number for your selection. \n1. Yes \n2. No");
        boolean isAvailable = false;
        if (keyboard.nextInt() == 1) {
            keyboard.nextLine();
            isAvailable = true;
        }
        System.out.println("Would you like this listing to be available for viewing?. \nEnter the appropriate number for your selection. \n1. Yes \n2. No");
        boolean isVisible= false;
        if (keyboard.nextInt() == 1) {
            keyboard.nextLine();
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
		System.out.println("Please enter your name.");
		String name = keyboard.nextLine();
		System.out.println("Please enter your graduation date (MM/YYYY)");
		String graduationDate = keyboard.nextLine();
		
		Majors studentMajor = null;
		while(true){
			ArrayList<Majors> majors = new ArrayList<Majors>();
			System.out.println("Please Search for your major.");
			String major = keyboard.nextLine();
			for(Majors m : Majors.values()) {
				if(m.toString().contains(major)){
					majors.add(m);
				}
			}
			for(int i = 0; i<majors.size(); i++) {
				System.out.println(i+1 + ": " + majors.get(i).toString());
			}
			System.out.println("Please enter the number of your selection. Or press zero to search again");
			int selection = keyboard.nextInt();
			if(selection > 0 && selection <= majors.size()) {
				studentMajor = majors.get(selection-1);
				break;
			} else if(selection == 0) {
				continue;
			} else {
				System.out.println("Please enter a valid selection.");
			}
		}
		
		System.out.println("Please enter your GPA. x/4.0");
		double GPA = keyboard.nextDouble();
		keyboard.nextLine();
		
		int i = 0;
		ArrayList<String> skills = new ArrayList<String>();
		while(true){
			System.out.println("Now we will enter your skills");
			System.out.println("Please enter your skill " + i + ".");
			String skill = keyboard.nextLine();
			skills.add(skill);
			i++;
			System.out.println("Would you like to enter another skill?. \nEnter the appropriate number for your selection. \n1. Yes \n2. No");
			if (keyboard.nextInt() == 2) {
				keyboard.nextLine();
				break;
			}
		}
		
		ArrayList<String> experience = new ArrayList<String>();
		int j = 0;
		while(true){
			System.out.println("Now we will enter your experience");
			System.out.println("Please enter your experience " + j + ".");
			String exp = keyboard.nextLine();
			experience.add(exp);
			j++;
			System.out.println("Would you like to enter another experience?. \nEnter the appropriate number for your selection. \n1. Yes \n2. No");
			if (keyboard.nextInt() == 2) {
				keyboard.nextLine();
				break;
			}
		}
		return new Resume(tempid, name, graduationDate, studentMajor, GPA, skills, experience);
	}

 }
