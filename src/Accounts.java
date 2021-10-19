package src;
import java.util.ArrayList;
import java.util.UUID;

public class Accounts {
	static final Account WRITER_ACCOUNT = new Account(UUID.randomUUID(),"password","admin@email.sc.edu",AccountType.ACCOUNT_TYPE_ADMIN);
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
			if(account.getEmail(WRITER_ACCOUNT).equals(email)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Account getAccount(String email) {
		for(Account account : accountList) {
			if(account.getEmail(WRITER_ACCOUNT).equals(email)) {
				return account;
			}
		}
		
		return null;
	}
	
	public ArrayList<Account> getAccounts() {
		return accountList;
	}
	
	public boolean addUser(UUID id, String email, String password, AccountType accountType) {
		if(haveAccount(email))return false;
		
		accountList.add(new Account(id, email, password, accountType));
		return true;
	}
	
	public void saveAccounts() {
		DataWriter.saveAccounts();
	}
}