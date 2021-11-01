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
	/**
	 * Main interface method to interact with user
	 */
	public void mainInterface() {
		Scanner key = new Scanner(System.in);
		System.out.println("Hello, welcome to the Internship Finder");
		System.out.println("Would you like to: \n1. Login \n2.Create Account \nPlease enter the appropriate number of your selection.");
		int response = key.nextInt();
		key.nextLine();
		if (response == 1) {
			promptLogin();
		}
		else if(response == 2) {
			currentUser = createAccount();
		}
		else {
			System.out.println("Invalid entry. Please enter \"1\" or \"2\".");
			mainInterface();
		}

		while(currentUser != null) {
			switch (currentUser.getAccountType()) {
				case ACCOUNT_TYPE_STUDENT:
					System.out.println("Would you like to: \n1. Create resume. \n2. View Jobs. \n3. Search Jobs. \n4. View your Resume. \n5. Logout. \nPlease enter the appropriate number of your selection.");
					response = key.nextInt();
					key.nextLine();
					switch (response) {
						case 1:
							viewJobs();
							break;
						case 2:
							createResume();
							break;
						case 3:
							System.out.println("Please enter a key-word for search.");
							String word = key.nextLine();
							sortJobs(word);
							break;
						case 4:
							viewResume(currentUser);
							break;
						case 5:
							logout();
							break;
					}
					break;
				case ACCOUNT_TYPE_ADMIN:
					System.out.println("");
					break;
				case ACCOUNT_TYPE_EMPLOYER:
				System.out.println("Would you like to: \n1. Create job. \n2. View applicants to a job posting. \n3. View a student's resume. \n4. Sort applicants by GPA or Rating. \n5. Logout. \nPlease enter the appropriate number of your selection.");
				response = key.nextInt();
				key.nextLine();
				switch (response) {
					case 1:
						createJob();
						break;
					case 2:
						createResume();
						break;
					case 3:
						System.out.println("Please enter a key-word for search.");
						String word = key.nextLine();
						sortJobs(word);
						break;
					case 4:
						int searchNum;
						System.out.println("Please select the number of the job for which you'd like to search its applicants.");
						for (Job job : currentUser.getPostedJobs()) {
							int i = 1;
							System.out.println(i+".");
							System.out.println(job.toString()); 
						}
						Job job = currentUser.getPostedJobs.get(key.nextInt() -1);
						key.nextLine();
						System.out.println("Would you like to sory by 1. GPA \n2. Rating \nPlease enter the appropriate number of your selection.");
						if (key.nextInt() == 1) {
							key.nextLine();
							System.out.println("Please enter the minimum GPA for applicants you'd like to review.");
							searchNum = key.nextInt();
						}
						else {
							key.nextLine();
							System.out.println("Please enter the minimum Rating for applicants you'd like to review.");
							searchNum = key.nextInt();
						}
						sortApplicants(job, searchNum);
						break;
					case 5:
						logout();
						break;
				}
				break;
				case account_type_invalid:
					System.out.println("Trouble with system. Please try again.");
					mainInterface();
					break;
			}
		}


	}
	/**
	 * prompts user for login info, password/email and passes it through login method
	 */
    public void promptLogin() {
        Scanner key = new Scanner(System.in);
        System.out.println("Please enter the email for the account.");
        String email = key.nextLine();
        System.out.println("Please enter the Password for the account.");
        String password = key.nextLine();

        login(email, password);
    }
	/**
	 * compares user inputs against accouunts information. Assigns current user if login information is correct
	 * @param email user's email to be compared
	 * @param password user's password to be compared
	 */
    public void login(String email, String password) {
        Scanner key = new Scanner(System.in);
        boolean foundAccount = false;
        for (Account account : DataLoader.getAccounts()) {
            if(email.equalsIgnoreCase(account.getEmail())) {
                if(password.equalsIgnoreCase(account.getPassword())) {
                    this.currentUser = account;
                    foundAccount = true;
                }
            }
        }
        if (foundAccount == false) {
            System.out.println("Email or Password incorrect.\nEnter the appropriate number for your selection.\n1.Re-enter login information.\n2.Exit to main Screen.");
            if(key.nextInt() == 1) {
                promptLogin();
            }
            else {
                mainInterface();
            }
        }
    }
	/**
	 * logout method saves the changes the user has made and sets the current user to null
	 */
    public void logout() {
        //TODO call save method from dataWriter
		DataWriter.saveAccounts();
		DataWriter.saveJobs();
		DataWriter.saveResumes();
        this.currentUser = null;
    }
	
	/**
	 * Creates a new account for the user
	 * @return the account that was created
	 */
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

	/**
	 * Creates a new student account by gathering all the information from user
	 * @return Student created
	 */
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


	/**
	 * Creates a new employer account by gathering all the information from user
	 * @return employer created
	 */
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

	/**
	 * Creates a new admin account by gathering all the information from user
	 * @return Admin created
	 */
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

	/**
	 * Creates a new job posting by gathering all the information from user
	 * @return the Job created 
	 */
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
		ArrayList<Double> ratings = new ArrayList<Double>();
        return new Job(tempid, jobTitle, jobDescription, currentUser, new ArrayList<Student>(), isAvailable, isVisible);
    }
	/**
	 * Prints all visible jobs to the console
	 */
    public void viewJobs() {
        for (Job job : DataLoader.getJobs()) {
            if (job.checkVisibility() == true) {
                job.toString();
            }
        }
    }
	/**
	 * Prints all applicants of a specific job to the console
	 * @param job job to see applicants of 
	 */
    public void viewApplicants(Job job) {
        System.out.println("Applicants:");
        for (Account applicant : job.getApplicants()) {
            System.out.println(applicant.toString());
        }
    }
	/**
	 * Shows the resume of a given applicant
	 * @param applicant student for who's resume is viewed 
	 */
    public void viewResume(Student applicant) {
        System.out.println(applicant.getResume().toString());
    }
	/**
	 * Shows jobs that contain a given word in their job title or description
	 * @param word word that is searched for 
	 */
    public void sortJobs(String word) {
        for (Job job : DataLoader.getJobs()) {
            if (job.containsWord(word) && job.checkVisibility() == true) {
                job.toString();
            }
        }
    }
	/**
	 * Shows applicants to a specific job that have a GPA or rating greater than or equal to a user input
	 * @param job Job to view applicants for 
	 * @param searchNum minimum GPA or rating to be shown
	 */
    public void sortApplicants(Job job, int searchNum) {
        for (Student applicant : job.getApplicants()) {
            if (applicant.getAvgRating() >= searchNum) {
                applicant.toString();
            }
        }

    }

	/**
	 * Creates a new resume for a Student by gathering the appropriate information from the user
	 * @return Resume that is created
	 */
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
