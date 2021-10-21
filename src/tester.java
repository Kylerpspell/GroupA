package src;
import java.util.ArrayList;
public class tester {
	public static void main(String[] args) {
		DataLoader dl = new DataLoader();
		ArrayList<Account> f = dl.getAccounts();
		for(Account a : f) {
			System.out.println(a);
		}
	}
}
