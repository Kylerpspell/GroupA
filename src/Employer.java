package src;
import java.util.UUID;
import java.util.ArrayList;

public class Employer implements Account {
    String companyName;
    String companyWebsite;
    String companyDescription;
	String password;
	String email;
	UUID id;
	ArrayList<Double> ratings;
	ArrayList<Job> postedJobs;

	//TODO we need to change this to match other constructors or vis versa
    public Employer(String Email, String password, UUID id, String companyName, String companyWebsite, String companyDescription,ArrayList<Double> ratings) {
		this.ratings = ratings;
		this.setEmail(Email);
		this.setPassword(password);
		this.id = id;
		this.setCompanyName(companyName);
        this.setCompanyWebsite(companyWebsite);
        this.setCompanyDescription(companyDescription);
		this.postedJobs = getPostedJobs();
    }

	/**
	 *constructs employer and initializes instance variables to defualt values
	 */

	public Employer(){
		this.setEmail("");
		this.setPassword("");
		this.id = UUID.randomUUID();
		this.setCompanyName("");
		this.setCompanyWebsite("");
		this.setCompanyDescription("");
		this.postedJobs = updatePostedJobs();
	}

	/**
	 *
	 * @return returns name of company
	 */

    public String getCompanyName(){
        return this.companyName;
    }

	/**
	 *
	 * @return returns description of company
	 */

	public String getCompanyDescription(){
        return this.companyDescription;
    }

	/**
	 *
	 * @return returns website of company
	 */

    public String getCompanyWebsite(){
        return this.companyWebsite;
    }

	/**
	 *
	 * @param newCompanyName takes in company name in parameter and sets it to current variable of company name
	 */

	public void setCompanyName(String newCompanyName){
        this.companyName = newCompanyName;
    }

	/**
	 *
	 * @param newCompanyWebsite takes in company website in parameter and sets it to current variable of company website
	 */

    public void setCompanyWebsite(String newCompanyWebsite){
        this.companyWebsite = newCompanyWebsite;

    }

	/**
	 *
	 * @param newCompanyDescription takes in company description in parameter and sets it to current variable of company description
	 */

	public void setCompanyDescription(String newCompanyDescription){
        this.companyDescription = newCompanyDescription;
    }

	/**
	 * @param studentAccount takes student account in parameter to locate the student
	 * @param Rating adds specified rating to student account
	 */

	public void giveStudentRating(Student studentAccount, double Rating){
        if( Rating >= 1 || Rating <= 5){
			studentAccount.addRating(Rating);
        }
    }


	/**
	 *	if rating is valid, which means between 0 and 5, then rating will be added to the list of ratings
	 * @param rating the rating (number value) to be added to list
	 */

	public void addRating(double rating) {
		if(rating > 0 && rating <=5) {
			this.ratings.add(rating);
		}
	}

	/**
	 * retrieves password
	 * @return returns the password string
	 */

	public String getPassword() {
		return this.password;
	}

	/**
	 * sets value of password to parameter if it is deemed valid
	 * @param password the specified password
	 */

	public void setPassword(String password){
		if(DatabaseManager.validPassword(password)){
			this.password = password;
		} else {
			System.out.println("Invalid Password");
		}
		
		
	}

	/**
	 * retrieves email string
	 * @return email string
	 */

	public String getEmail(){
		return this.email;
	}

	/**
	 * sets value of email to parameter if deemed valid
	 * @param email email string
	 */

	public void setEmail(String email){
		if(DatabaseManager.validEmail(email)){
			this.email = email;
		} else {
			System.out.println("Invalid Email");
		}
		
	}

	/**
	 * shows the account type
	 * @return returns employer account type
	 */

	public AccountType getAccountType(){
		return AccountType.ACCOUNT_TYPE_EMPLOYER;
	}

	/**
	 *retrieves id number
	 * @return the id number
	 */

	public UUID getId(){
		return this.id;
	}

	/**
	 * Appends company variables to create string representation
	 * @return returns ret variable which is string representation of company
	 */

	@Override
	public String toString(){
		String ret = "Company Name: " + this.companyName + "\n";
		ret += "Company Website: " + this.companyWebsite + "\n";
		ret += "Company Description: " + this.companyDescription + "\n";
		return ret;
	}

	/**
	 * looks through list of all jobs to check which one has been posted and adds it to list of posted jobs to return
	 * @return list of posted jobs
	 */

	public ArrayList<Job> updatePostedJobs(){
		ArrayList<Job> allJobs = DataLoader.getJobs();
		for(Job j : allJobs){
			if(j.getPostingEmployer().getId().equals(this.id)){
				this.postedJobs.add(j);
			}
		}
		return postedJobs;
	}

	@Override
	public Employer getEmployer() {
		return this;
	}

	@Override
	public Student getStudent() {
		return null;
	}

	@Override
	public Admin getAdmin() {
		return null;
	}

	public ArrayList<Job> getPostedJobs(){
		return this.postedJobs;
	}
}

