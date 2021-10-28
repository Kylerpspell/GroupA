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

	//TODO we need to change this to match other constructors or vis versa
    public Employer(String Email, String password, UUID id, String companyName, String companyWebsite, String companyDescription,ArrayList<Double> ratings) {
		this.ratings = ratings;
		this.setEmail(Email);
		this.setPassword(password);
		this.id = id;
		this.setCompanyName(companyName);
        this.setCompanyWebsite(companyWebsite);
        this.setCompanyDescription(companyDescription);
    }

	public Employer(){
		this.setEmail("");
		this.setPassword("");
		this.id = UUID.randomUUID();
		this.setCompanyName("");
		this.setCompanyWebsite("");
		this.setCompanyDescription("");
	}

    public String getCompanyName(){
        return this.companyName;
    }
    /*
    returns name of company
     */
    public String getCompanyDescription(){
        return this.companyDescription;
        /*
    returns description of company
     */
    }
    public String getCompanyWebsite(){
        return this.companyWebsite;
        /*
    returns website of company
     */
    }
    /*public void setName(Account currentUser, String newName){
        this.companyName = newName;
    }*/
    public void setCompanyName(String newCompanyName){
        this.companyName = newCompanyName;
    }
    /*
    takes in company name in parameter and sets it to current variable of company name
     */
    public void setCompanyWebsite(String newCompanyWebsite){
        this.companyWebsite = newCompanyWebsite;
         /*
    takes in company website in parameter and sets it to current variable of company website
     */
    }
    public void setCompanyDescription(String newCompanyDescription){
        this.companyDescription = newCompanyDescription;
         /*
    takes in company description in parameter and sets it to current variable of company description
     */
    }
    public void giveStudentRating(Student studentAccount, double Rating){
        if( Rating >= 1 || Rating <= 5){
			studentAccount.addRating(Rating);
        }
    }
	/*
    takes student account in parameter to locate the student and adds specified rating to student account
     */

	public void addRating(double rating) {
		if(rating > 0 && rating <=5) {
			this.ratings.add(rating);
		}
	}

	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password){
		if(DatabaseManager.validPassword(password)){
			this.password = password;
		}
		System.out.println("Invalid Password");
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		if(DatabaseManager.validEmail(email)){
			this.email = email;
		}
		System.out.println("Invalid Email");
	}

	public AccountType getAccountType(){
		return AccountType.ACCOUNT_TYPE_EMPLOYER;
	}

	public UUID getId(){
		return this.id;
	}

	@Override
	public String toString(){
		String ret = "Company Name: " + this.companyName + "\n";
		ret += "Company Website: " + this.companyWebsite + "\n";
		ret += "Company Description: " + this.companyDescription + "\n";
		return ret;
	}

}

