package src;
import java.util.ArrayList;
import java.util.UUID;

public class Accounts {
	private static Accounts accounts;
	private ArrayList<Account> accountList;
	
	private Accounts() {
		accountList = DataLoader.getAccounts();
	}
	
	public static Accounts getInstance() {
		if(accounts == null) {
			accounts = new Accounts();
		}
		
		return accounts;
	}

	public boolean haveAccount(String email) {
		for(Account account : accountList) {
			if(account.getEmail().equals(email)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Account getAccount(String email) {
		for(Account account : accountList) {
			if(account.getEmail().equals(email)) {
				return account;
			}
		}
		
		return null;
	}
	
	public ArrayList<Account> getAccounts() {
		return accountList;
	}
	
	public boolean addAccount(Account newAccount) {
		if(haveAccount(newAccount.getEmail()))return false;
		
		accountList.add(newAccount);
		return true;
	}

	public boolean removeAccount(UUID id) {
		for(Account account : accountList) {
			if(account.getId().equals(id)) {
				accountList.remove(account);
				return true;
			}
		}
		return false;
	}
	
	public void saveAccounts() {
		DataWriter.saveAccounts();
	}
}