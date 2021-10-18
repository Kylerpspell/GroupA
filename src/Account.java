package src;
public class Account {
	String password;
	String email;
	AccountType UserAccountType;

	Account() {
		this.password = null;
		this.email = null;
		this.UserAccountType = null;
	}
	Account(String password, String email, AccountType AccountType) {
		this.password = password;
		this.email = email;
		this.UserAccountType = AccountType;
	}

	public String getPassword(Account CurrentUser) {
		return password;
	}
	public void setPassword(String password, Account currentUser) {
		if(currentUser.UserAccountType == AccountType.ACCOUNT_TYPE_ADMIN || currentUser == this) {
			this.password = password;
		}
	}

	public String getEmail(Account CurrentUser) {
		return email;
	}

	public void setEmail(String email, Account currentUser) {
		if(currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_ADMIN || currentUser == this) {
			this.email = email;
		}
	}

	public AccountType getAccountType() {
		return UserAccountType;
	}
}
