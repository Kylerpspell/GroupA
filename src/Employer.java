package src;

public class Employer {
    String companyName;
    String companyWebsite;
    String companyDescription;
    public Employer(String companyName, String companyWebsite, String companyDescription){

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
    public void setCompanyName(Account currentUser, String newCompanyName){
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_EMPLOYER)
        this.companyName = newCompanyName;
    }
    public void setCompanyWebsite(Account currentUser, String newCompanyWebsite){
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_EMPLOYER)
        this.companyWebsite = newCompanyWebsite;
    }
    public void setCompanyDescription(Account currentUser, String newCompanyDescription){
        if (currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_EMPLOYER)
        this.companyDescription = newCompanyDescription;
    }

}
