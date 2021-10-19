package src;

public class Employer {
    String companyName;
    String companyWebsite;
    String companyDescription;
    public Employer(String companyName, String companyWebsite, String companyDescription){
        /*
        LINK METHODS TO CURRENT USER
         */
    }
    public String getName(Account currentUser){

    }
    public String getCompanyName(Account currentUser){
        return this.companyName;
    }
    public String getCompanyDescription(Account currentUser){
        return this.companyDescription;
    }
    public String getCompanyWebsite(Account currentUser){
        return this.companyWebsite;
    }
    public void setName(Account currentUser, String newName){
        this.companyName = newName;
    }
    public void setCompanyName(Account currentUser, String newCompanyName){
        this.companyName = newCompanyName;
    }
    public void setCompanyWebsite(Account currentUser, String newCompanyWebsite){
        this.companyWebsite = newCompanyWebsite;
    }
    public void setCompanyDescription(Account currentUser, String newCompanyDescription){
        this.companyDescription = newCompanyDescription;
    }

}
