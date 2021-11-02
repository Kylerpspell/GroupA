package src;
public class tester {
	public static void main(String[] args) {
		DatabaseManager db = DatabaseManager.getInstance();
		InterfaceManager im = InterfaceManager.getInstance(db);
		for(Job j : db.getJobs().getJobList()) {
			System.out.println(j.toString());
			im.sortApplicants(j, 1);
		}
	} 
}