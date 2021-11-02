package src;
public class tester {
	public static void main(String[] args) {
		DatabaseManager db = DatabaseManager.getInstance();
		InterfaceManager im = InterfaceManager.getInstance(db);
		im.mainInterface();
	} 
}