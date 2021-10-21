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

    public String getCompanyName(Account currentUser){
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_EMPLOYER)
        return this.companyName;
    }
    public String getCompanyDescription(Account currentUser){
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_EMPLOYER)
        return this.companyDescription;
    }
    public String getCompanyWebsite(Account currentUser){
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_EMPLOYER)
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
    public double giveStudentRating(Employer employerAccount, Student studentAccount, double Rating){
        if( Rating >= 1 || Rating <= 5){

        }
    }

}
