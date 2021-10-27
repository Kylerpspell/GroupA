package src;
import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Resume {
	private UUID id;
    private String name;
    private String graduationDate;
    private Majors major;
    private double GPA;
    private ArrayList<String> experiences;
    private ArrayList<String> skills;

	public Resume(UUID id, String name, String graduationDate, Majors major, double GPA, ArrayList<String> experiences, ArrayList<String> skills) {
		this.id = id;
        this.name = name;
		this.graduationDate = graduationDate;
		this.major = major;
		this.GPA = GPA;
		this.experiences = experiences;
		this.skills = skills;
	}
    
    public void setName( String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getGraduationDate() {
        return this.graduationDate;
    }

    public double getGPA() {
        return this.GPA;
    }

    public void setGPA( double GPA) {
        this.GPA = GPA;
    }

    public ArrayList<String> getExperiences() {
        return this.experiences;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }
    public void AddExperience( String Experience) {
        this.experiences.add(Experience);
    }
    public void removeExperience( String Experience) {
        this.experiences.remove(Experience);
    }
    public void AddSkill( String Skill) {
        this.skills.add(Skill);
    }
    public void removeSkill( String Skill) {
        this.skills.remove(Skill);
    }
	public Majors getMajor() {
		return this.major;
	}
	public void setMajor( Majors major) {
			this.major = major;
	}

	public UUID getId() {
		return id;
	}
}