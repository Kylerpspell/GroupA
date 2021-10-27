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
		//TODO check if password is valid
		this.password = password;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		//TODO check if email is valid
		this.email = email;
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
