package src;
public class tester {
	public static void main(String[] args) {
		DatabaseManager db = DatabaseManager.getInstance();
		InterfaceManager im = InterfaceManager.getInstance(db);
<<<<<<< HEAD
		// db.addAccount(im.createAccount());
=======
>>>>>>> 8ff877bc6c41629ab073f5816f1f247f15d9fe8f
		im.mainInterface();
	} 
}