package src;

import java.util.UUID;

public class Admin implements Account{
	private String email;
	private String password;
	private UUID id;

	/**
	 * Parameterized constructor for Admin 
	 * @param id UUID  id of the admin
	 * @param email  String email of the admin
	 * @param password String password of the admin
	 */
	public Admin(UUID id, String email, String password) {
		this.email = email;
		this.password = password;
		this.id = id;
	}


	/**
	 * Accessor method for password
	 * @return String Admin password 
	 */
	public String getPassword(){
		return password;
	}
	
	/**
	 * Mutator method for password
	 * @param password  String password to set the admin's password to
	 */
	public void setPassword(String password){
		if(DatabaseManager.validPassword(password)) {
			this.password = password;
		}
		System.out.println("Invalid password");
	}

	/**
	 * Accessor method for email
	 * @return String admin email
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * Mutator method for email
	 * @param email  String email to set the admin's email to
	 */
	public void setEmail(String email){
		if(DatabaseManager.validEmail(email)) {
			this.email = email;
		}
		System.out.println("Invalid email");
	}

	/**
	 * Accessor method for account type 
	 * @return always returns Admin account type
	 */
	public AccountType getAccountType(){
		return AccountType.ACCOUNT_TYPE_ADMIN;
	}

	/**
	 * Accessor method for id 
	 * @return UUID id linked to admin
	 */
	public UUID getId(){
		return id;
	}

	/**
	 * toString account that prints admins email
	 * @return String containing admin information
	 */
	@Override
	public String toString(){
		return "Admin: " + email;
	}
}
