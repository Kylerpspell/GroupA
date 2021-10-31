package src;
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

    /**
     * Parameterized constructor for Resume 
     * @param id UUID of resume
     * @param name String name of the studetns
     * @param graduationDate String expected graduation date of students
     * @param major Student's Major from major.enum 
     * @param GPA Double GPA of the student
     * @param experiences Array list of String experiences for the students
     * @param skills Array list of String skills for the students
     */
	public Resume(UUID id, String name, String graduationDate, Majors major, double GPA, ArrayList<String> experiences, ArrayList<String> skills) {
		this.id = id;
        this.name = name;
		this.graduationDate = graduationDate;
		this.major = major;
		this.GPA = GPA;
		this.experiences = experiences;
		this.skills = skills;
	}
    
    /**
     * Mutator method for name on resume
     * @param name String Name to set as name on resume
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Accessor method for name on resume
     * @return name on resume
     */
    public String getName() {
        return this.name;
    }
    /**
     * Mutator method for graduation date on resume
     * @param name String graduation date to set as expected graduation on resume
     */
    public String getGraduationDate() {
        return this.graduationDate;
    }

    /**
     * Accessor method for GPA on resume
     * @return Double GPA shown on resume
     */
    public double getGPA() {
        return this.GPA;
    }

    /**
     * Mutator method for GPA on resume
     * @param GPA double GPA to set the GPA on resume to
     */
    public void setGPA( double GPA) {
        this.GPA = GPA;
    }

    /**
     * Accessor method for experiences 
     * @return Array list of strings listing experiences on the resume 
     */
    public ArrayList<String> getExperiences() {
        return this.experiences;
    }
    /**
     * Accessor method for skills 
     * @return Array list of strings listing skills on the resume 
     */
    public ArrayList<String> getSkills() {
        return skills;
    }
    /**
     * Adds an experience to experiences arrayList
     * @param Experience String expereince to be addedd to the array list 
     */
    public void AddExperience(String Experience) {
        this.experiences.add(Experience);
    }
    /**
     * Removes an experience from experiences arrayList
     * @param Experience String expereince to be removed from the array list 
     */
    public void removeExperience(String Experience) {
        this.experiences.remove(Experience);
    }
     /**
     * Adds a skill to skills arrayList
     * @param Experience String skill to be addedd to the array list 
     */
    public void AddSkill(String Skill) {
        this.skills.add(Skill);
    }
    /**
     * Removes a skill from skills arrayList
     * @param Experience String skill to be removed from the array list 
     */
    public void removeSkill(String Skill) {
        this.skills.remove(Skill);
    }
    /**
     * Accessor method for the major on the resume 
     * @return Major from major.enum that shows on the resume
     */
	public Majors getMajor() {
		return this.major;
	}
    /**
     * Mutator method for the major on the resume 
     * @param major Major from major.enum to set the resume's major to 
     */
	public void setMajor(Majors major) {
			this.major = major;
	}

    /**
     * Accessor method for resume's UUID
     * @return UUID id that is linked to the resume 
     */
	public UUID getId() {
		return id;
	}

    /**
     * ToString method that formats the String as a resume would be laid out
     * @return String with all relevant resume information formatted
     */
    public String formatString() {
        String ret = "Name: " + this.name + "\n";
        ret += "Graduation Date: " + this.graduationDate + "\n";
        ret += "Major: " + this.major + "\n";
        ret += "GPA: " + this.GPA + "\n";
        ret += "Experiences: \n";
        for (String experience : this.experiences) {
            ret  += "\t -" + experience + "\n";
        }
        ret += "Skills: \n";
        for (String skill : this.skills) {
            ret += "\t -" + skill + "\n";
        }
        return ret;
    }
}