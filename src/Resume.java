package src;
import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Resume {
	private UUID id;
    private String name;
    private Date graduationDate;
    private Majors major;
    private double GPA;
    private ArrayList<String> experiences;
    private ArrayList<String> skills;

	public Resume(UUID id, String name, Date graduationDate, Majors major, double GPA, ArrayList<String> experiences, ArrayList<String> skills) {
		this.name = name;
		this.graduationDate = graduationDate;
		this.major = major;
		this.GPA = GPA;
		this.experiences = experiences;
		this.skills = skills;
	}
    
    public void setName(Account currentUser, String name) {
        this.name = name;
    }

    public String getName(Account currentUser) {
        return this.name;
    }

    public Date getGraduationDate(Account currentUser) {
        return this.graduationDate;
    }

    public double getGPA(Account currentUser) {
        return this.GPA;
    }

    public void setGPA(Account currentUser, double GPA) {
        this.GPA = GPA;
    }

    public ArrayList<String> getExperiences(Account currentUser) {
        return this.experiences;
    }

    public ArrayList<String> getSkills(Account currentUser) {
        return skills;
    }
    public void AddExperience(Account currentUser, String Experience) {
        this.experiences.add(Experience);
    }
    public void removeExperience(Account currentUser, String Experience) {
        this.experiences.remove(Experience);
    }
    public void AddSkill(Account currentUser, String Skill) {
        this.skills.add(Skill);
    }
    public void removeSkill(Account currentUser, String Skill) {
        this.skills.remove(Skill);
    }
	public Majors getMajor(Account currentUser) {
		return this.major;
	}
	public void setMajor(Account currentUser, Majors major) {
		if(currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_ADMIN || currentUser.getAccountType() == AccountType.ACCOUNT_TYPE_STUDENT) {
			this.major = major;
		}
	}

	public UUID getId() {
		return id;
	}
}