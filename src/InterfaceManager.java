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
		keyboard = new Scanner(System.in);
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
		System.out.println("Hello, welcome to the Internship Finder");
		System.out.println("Would you like to: \n1. Login \n2.Create Account \nPlease enter the appropriate number of your selection.");
		boolean validResponse = false;
		while (!validResponse) {
			int response = keyboard.nextInt();
			keyboard.nextLine();
			if (response == 1) {
				validResponse = true;
				promptLogin();
			}
			else if(response == 2) {
				validResponse = true;
				currentUser = createAccount();
			}
			else {
				System.out.println("Invalid entry. Please enter \"1\" or \"2\".");
			}
		}	

		while(currentUser != null) {
			switch (currentUser.getAccountType()) {
				case ACCOUNT_TYPE_STUDENT:
					System.out.println("Would you like to: \n1. Create resume. \n2. View Jobs. \n3. Search Jobs. \n4. View your Resume. \n5. Logout. \nPlease enter the appropriate number of your selection.");
					int response = keyboard.nextInt();
					keyboard.nextLine();
					switch (response) {
						case 1:
							createResume();
							break;
						case 2:
							viewJobs();
							break;
						case 3:
							System.out.println("Please enter a key-word for search.");
							String word = keyboard.nextLine();
							sortJobs(word);
							break;
						case 4:
							viewResume(currentUser.getStudent());
							break;
						case 5:
							logout();
							break;
					}
					break;
				case ACCOUNT_TYPE_ADMIN:
					System.out.println("Would you like to: \n1. Edit job Visibility. \n2. View applicants to a job posting. \n3. Logout.");
					break;
				case ACCOUNT_TYPE_EMPLOYER:
				System.out.println("Would you like to: \n1. Create job. \n2. View applicants to a job posting. \n3. View a student's resume. \n4. Sort applicants by GPA or Rating. \n5. Edit Job Visibility. \n6. Edit job Availability. \n7.Logout. \nPlease enter the appropriate number of your selection.");
				response = keyboard.nextInt();
				keyboard.nextLine();
				switch (response) {
					case 1:
						database.addJob(createJob());
						break;
					case 2:
					if (currentUser.getEmployer().getPostedJobs() != null) {
						System.out.println("Please select the number of the job for which you'd like to search its applicants.");
						for (Job job : currentUser.getEmployer().getPostedJobs()) {
							int i = 1;
							System.out.println(i+".   ");
							System.out.println(job.toString()); 
						}
						int jobPick = (keyboard.nextInt());
						keyboard.nextLine();
						if (currentUser.getEmployer().getPostedJobs().size() >= jobPick) {
							Job job = currentUser.getEmployer().getPostedJobs().get(jobPick - 1);
							viewApplicants(job);
						}
						else {
							System.out.println("Invalid input or no posted jobs available for this account.");
						}
					}
					else {
						System.out.println("Invalid input or no posted jobs available for this account.");	
					}
						break;
					case 3:
						if (currentUser.getEmployer().getPostedJobs() != null) {
							System.out.println("Please select the number of the job for which you'd like to search its applicants.");
							for (Job job : currentUser.getEmployer().getPostedJobs()) {
								int i = 1;
								System.out.println(i+".   ");
								System.out.println(job.toString()); 
							}
							int jobPick = (keyboard.nextInt());
							keyboard.nextLine();
							if (currentUser.getEmployer().getPostedJobs().size() >= jobPick) {
								Job job = currentUser.getEmployer().getPostedJobs().get(jobPick - 1);
								viewApplicants(job);
								System.out.println("Please select the number of the Student who's resume you'd like to view.");
								for (Student student : job.getApplicants()) {
									int i = 1;
									System.out.println(i+".   ");
									System.out.println(student.toString()); 
								}
								int studentPick = (keyboard.nextInt());
								keyboard.nextLine();
								if (job.getApplicants().size() >= studentPick) {
									Student student = job.getApplicants().get(studentPick - 1);
									viewResume(student);;
								}
								else {
									System.out.println("Invalid input or no applicants available for this job.");
								}
							}
							else {
								System.out.println("Invalid input or no posted jobs available for this account.");
							}
						}
						else {
							System.out.println("Invalid input or no posted jobs available for this account.");	
						}
						break;
					case 4:
						double searchNum;
						System.out.println("Would you like to sort by \n1. GPA \n2. Rating \nPlease enter the appropriate number of your selection.");
						if (keyboard.nextInt() == 1) {
							keyboard.nextLine();
							System.out.println("Please enter the minimum GPA for applicants you'd like to review.");
							searchNum = keyboard.nextDouble();
						}
						else {
							keyboard.nextLine();
							System.out.println("Please enter the minimum Rating for applicants you'd like to review.");
							searchNum = keyboard.nextDouble();
						}
						if (currentUser.getEmployer().getPostedJobs() != null) {
							System.out.println("Please select the number of the job for which you'd like to search its applicants.");
							for (Job job : currentUser.getEmployer().getPostedJobs()) {
								int i = 1;
								System.out.println(i+".");
								System.out.println(job.toString()); 
							}
							int jobPick1 = (keyboard.nextInt());
							keyboard.nextLine();
							if (currentUser.getEmployer().getPostedJobs().size() >= jobPick1) {
								Job job = currentUser.getEmployer().getPostedJobs().get(jobPick1 - 1);
								sortApplicants(job, searchNum);
							}
							else {
								System.out.println("Invalid input or no posted jobs available for this account.");
							}
						}
						else {
							System.out.println("Invalid input or no posted jobs available for this account.");	
						}
						break;
					case 5:
						if (currentUser.getEmployer().getPostedJobs() != null) {
							System.out.println("Please select the number of the job for which you'd like to change its visibility");
							for (Job job : currentUser.getEmployer().getPostedJobs()) {
								int i = 1;
								System.out.println(i+".   ");
								System.out.println(job.toString()); 
							}
							int jobPick = (keyboard.nextInt());
							keyboard.nextLine();
							if (currentUser.getEmployer().getPostedJobs().size() >= jobPick) {
								Job job = currentUser.getEmployer().getPostedJobs().get(jobPick - 1);
								if (job.checkVisibility() == true) {
									job.setVisibility(false);
									System.out.println("Job has been changed from visible to invisible.");
								}
								else {
									job.setVisibility(true);
									System.out.println("Job has been changed from invisible to visible.");
								}
							}
							else {
								System.out.println("Invalid input or no posted jobs available for this account.");
							}
						}
						else {
							System.out.println("Invalid input or no posted jobs available for this account.");	
						}
						break;
					case 6:
						if (currentUser.getEmployer().getPostedJobs() != null) {
							System.out.println("Please select the number of the job for which you'd like to change its availability");
							for (Job job : currentUser.getEmployer().getPostedJobs()) {
								int i = 1;
								System.out.println(i+".   ");
								System.out.println(job.toString()); 
							}
							int jobPick = (keyboard.nextInt());
							keyboard.nextLine();
							if (currentUser.getEmployer().getPostedJobs().size() >= jobPick) {
								Job job = currentUser.getEmployer().getPostedJobs().get(jobPick - 1);
								if (job.checkAvailability() == true) {
									job.setAvailability(false);
									System.out.println("Job has been changed from available to unavailable");
								}
								else {
									job.setAvailability(true);
									System.out.println("Job has been changed from unavailable to available");
								}
							}
							else {
								System.out.println("Invalid input or no posted jobs available for this account.");
							}
						}
						else {
							System.out.println("Invalid input or no posted jobs available for this account.");	
						}
					break;
					case 7:
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
        System.out.println("Please enter the email for the account.");
        String email = keyboard.nextLine();
        System.out.println("Please enter the Password for the account.");
        String password = keyboard.nextLine();

        login(email, password);
    }

	/**
	 * compares user inputs against accouunts information. Assigns current user if login information is correct
	 * @param email user's email to be compared
	 * @param password user's password to be compared
	 */
    public void login(String email, String password) {
        boolean foundAccount = false;
        for (Account account : database.getAccounts().getAccountList()) {
            if(email.equalsIgnoreCase(account.getEmail())) {
                if(password.equalsIgnoreCase(account.getPassword())) {
                    this.currentUser = account;
                    foundAccount = true;
                }
            }
        }
		//TODO refactor for recursive call
        if (foundAccount == false) {
            System.out.println("Email or Password incorrect.\nEnter the appropriate number for your selection.\n1.Re-enter login information.\n2.Exit to main Screen.");
            if(keyboard.nextInt() == 1) {
				keyboard.nextLine();
                promptLogin();
            }
            else {
				keyboard.nextLine();
                mainInterface();
            }
        }
    }
	/**
	 * logout method saves the changes the user has made and sets the current user to null
	 */
    public void logout() {
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
		int switchCase = keyboard.nextInt();
		keyboard.nextLine();
		switch (switchCase) {
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
		database.getResumes().addResume(newResume);
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
		Employer newEmployer = new Employer(email, password, UUID.randomUUID(), name, website, description,ratings);
		return newEmployer;
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
        for (Job job : database.getJobs().getJobList()) {
            if (job.checkVisibility() == true) {
                System.out.println(job.toString());
            }
        }
    }
	/**
	 * Prints all applicants of a specific job to the console
	 * @param job job to see applicants of 
	 */
    public void viewApplicants(Job job) {
        System.out.println("Applicants:");
        for (Student applicant : job.getApplicants()) {
            System.out.println(applicant.toString());
        }
    }

	/**
	 * Shows the resume of a given applicant
	 * @param applicant student for who's resume is viewed 
	 */
    public void viewResume(Student applicant) {
    	System.out.println(applicant.getResume().formatString());
	}
           
	public void sortJobs(String word) {
		for (Job job : database.getJobs().getJobList()) {
			if (job.containsWord(word) && job.checkVisibility() == true) {
				System.out.println(job.toString());
			}
		}
    }
	/**
	 * Shows applicants to a specific job that have a GPA or rating greater than or equal to a user input
	 * @param job Job to view applicants for 
	 * @param searchNum minimum GPA or rating to be shown
	 */
    public void sortApplicants(Job job, double searchNum) {
        for (Student applicant : job.getApplicants()) {
            if (applicant.getAvgRating() >= searchNum) {
                System.out.println(applicant.toString());
            }
        }

    }

	/**
	 * Creates a new resume for a Student by gathering the appropriate information from the user
	 * @return Resume that is created
	 */
	public Resume createResume() {
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
			keyboard.nextLine();
		
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
			keyboard.nextLine();
		}
		return new Resume(tempid, name, graduationDate, studentMajor, GPA, skills, experience);
	}

 }