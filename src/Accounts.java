package src;
import java.util.ArrayList;
import java.util.UUID;

public class Accounts {
	private static Accounts accounts;
	private ArrayList<Account> accountList;
	
	/**
	 * Default account constructor
	 */
	private Accounts() {
		accountList = DataLoader.getAccounts();
	}
	
	/**
	 * gets an instance of the Accounts class if accounts is null, makes accounts a singleton 
	 */
	public static Accounts getInstance() {
		if(accounts == null) {
			accounts = new Accounts();
		}
		
		return accounts;
	}

	/**
	 * Checks to see if an account already exists for an email
	 * @param email email to be checked if an account exists for it 
	 * @return boolean that is true when the email does have an account and false otherwise
	 */
	public boolean haveAccount(String email) {
		for(Account account : accountList) {
			if(account.getEmail().equals(email)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * gets an account based on the email linked to it
	 * @param email email to retrieve account for
	 * @return Account that utilizes that email
	 */
	public Account getAccount(String email) {
		for(Account account : accountList) {
			if(account.getEmail().equals(email)) {
				return account;
			}
		}
		
		return null;
	}
	
	/**
	 * Accessor method for all accounts
	 * @return ArrayList of Accounts with all saved accounts
	 */
	public ArrayList<Account> getAccounts() {
		return accountList;
	}
	
	/**
	 * adds an account to the accounts array list 
	 * @param newAccount account to be added
	 * @return returns true when the new account does not already exist and the new account is added, false otherwise
	 */
	public boolean addAccount(Account newAccount) {
		if(haveAccount(newAccount.getEmail()))return false;
		
		accountList.add(newAccount);
		return true;
	}

	/**
	 * Removes an account using its UUID 
	 * @param id UUID of the account
	 * @return true when the account is found and removed, false otherwise
	 */
	public boolean removeAccount(UUID id) {
		for(Account account : accountList) {
			if(account.getId().equals(id)) {
				accountList.remove(account);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Utilizes the data writer to save accounts to a JSON file
	 */
	public void saveAccounts() {
		DataWriter.saveAccounts();
	}
}