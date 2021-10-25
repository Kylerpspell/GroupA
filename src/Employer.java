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
    public String getCompanyDescription(){
        return this.companyDescription;
    }
    public String getCompanyWebsite(){
        return this.companyWebsite;
    }
    /*public void setName(Account currentUser, String newName){
        this.companyName = newName;
    }*/
    public void setCompanyName(String newCompanyName){
        this.companyName = newCompanyName;
    }
    public void setCompanyWebsite(String newCompanyWebsite){
        this.companyWebsite = newCompanyWebsite;
    }
    public void setCompanyDescription(String newCompanyDescription){
        this.companyDescription = newCompanyDescription;
    }
    public void giveStudentRating(Employer employerAccount, Student studentAccount, double Rating){
        if( Rating >= 1 || Rating <= 5){
			studentAccount.addRating(Rating);
        }
    }
}

