package src;
import java.util.ArrayList;
public class tester {
	public static void main(String[] args) {
		ArrayList<Resume> temp = Resumes.getInstance().getResumes();
		for(Resume res : temp) {
			System.out.println(res.formatString());
			System.out.println("\n");
		}
	} 
}
