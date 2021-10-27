package src;


public class Employer extends Account {
    String companyName;
    String companyWebsite;
    String companyDescription;
    public Employer(String companyName, String companyWebsite, String companyDescription){
        this.setCompanyName(companyName);
        this.setCompanyWebsite(companyWebsite);
        this.setCompanyDescription(companyDescription);
    }
    /*public String getName(Account currentUser){

    }*/

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
}

