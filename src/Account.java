package src;
import java.util.UUID;
public interface Account {

	public String getPassword();
	
	public void setPassword(String password);

	public String getEmail();

	public void setEmail(String email);

	public AccountType getAccountType();

	public UUID getId();

	@Override
	public String toString();
}
