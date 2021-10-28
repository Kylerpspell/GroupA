package src;

import java.util.UUID;

public class Admin implements Account{
	private String email;
	private String password;
	private UUID id;

	Admin(UUID id, String email, String password) {
		this.email = email;
		this.password = password;
		this.id = id;
	}


	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		if(DatabaseManager.validPassword(password)) {
			this.password = password;
		}
		System.out.println("Invalid password");
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		if(DatabaseManager.validEmail(email)) {
			this.email = email;
		}
		System.out.println("Invalid email");
	}

	public AccountType getAccountType(){
		return AccountType.ACCOUNT_TYPE_ADMIN;
	}

	public UUID getId(){
		return id;
	}

	@Override
	public String toString(){
		return "Admin: " + email;
	}
}
