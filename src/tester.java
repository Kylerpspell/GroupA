package src;
import java.util.ArrayList;
import java.util.UUID;
public class tester {
	public static void main(String[] args) {
		Resumes.getInstance();

		ArrayList<String> skills = new ArrayList<String>();
		skills.add("java");
		skills.add("c++");
		skills.add("c#");
		ArrayList<String> experiences = new ArrayList<String>();
		experiences.add("Played minecraft");
		experiences.add("Played CSGO");
		experiences.add("Played Rocket League");

		UUID x = UUID.randomUUID();
		System.out.println(x);
		Resume newResume = new Resume(x, "Kyler", "May 2023", Majors.COMPUTER_SCIENCE_COMPUTER_ENGINEERING, 3.1, skills, experiences);
		if(Resumes.getInstance().addResume(newResume)) {
			System.out.println("Resume added");
		}
		else {
			System.out.println("Resume not added");
		}
		Resumes.getInstance().saveResumes();
	} 
}
