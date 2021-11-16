package src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;

public class ResumeTest {

    @Test
    public void addExperienceTest(){
        ArrayList<Resume> list = DataLoader.getResumes();
        Resume r = list.get(0);
        ArrayList<String> ex1 = r.getExperiences();
        String doc = "testy";

        r.AddExperience(doc);

        ArrayList<String> ex2 = r.getExperiences();

        assertEquals(ex2.size(), ex1.size()+1);
    }

    @Test
    public void removeExperienceTest(){
        ArrayList<Resume> list = DataLoader.getResumes();
        Resume r = list.get(0);
        String doc = "testy";
        ArrayList<String> ex1 = r.getExperiences();

        r.removeExperience(doc);

        ArrayList<String> ex2 = r.getExperiences();

        assertEquals(ex2.size(), ex1.size()-1);
    }

    @Test
    public void addSkillTest(){
        ArrayList<Resume> list = DataLoader.getResumes();
        Resume r = list.get(0);
        ArrayList<String> sk1 = r.getSkills();
        String skil = "testy";

        r.AddSkill(skil);

        ArrayList<String> sk2 = r.getSkills();

        assertEquals(sk2.size(), sk1.size()+1);
    }

    @Test
    public void removeSkillTest(){
        ArrayList<Resume> list = DataLoader.getResumes();
        Resume r = list.get(0);
        String skil = "testy";
        ArrayList<String> sk1 = r.getSkills();

        r.removeSkill(skil);

        ArrayList<String> sk2 = r.getSkills();

        assertEquals(sk2.size(), sk1.size()-1);
    }
}