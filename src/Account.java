package src;
import java.util.UUID;
public class Account {
	UUID id;
	String password;
	String email;
	AccountType UserAccountType;

	Account() {
		this.id = UUID.randomUUID();
		this.password = null;
		this.email = null;
		this.UserAccountType = null;
	}
	Account(UUID id, String password, String email, AccountType AccountType) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.UserAccountType = AccountType;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
			this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
			this.email = email;
	}

	public AccountType getAccountType() {
		return UserAccountType;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", password=" + password + ", email=" + email + ", UserAccountType="
				+ UserAccountType + "]";
	}
}
