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
        int ex1 = r.getExperiences().size();
        String doc = "testy";

        r.AddExperience(doc);

        int ex2 = r.getExperiences().size();

        assertEquals(ex2, ex1+1);
    }

    @Test
    public void removeExperienceTest(){
        ArrayList<Resume> list = DataLoader.getResumes();
        Resume r = list.get(0);
        String doc = "testy";
        int ex1 = r.getExperiences().size();

        r.removeExperience(doc);

        int ex2 = r.getExperiences().size();

        assertEquals(ex2, ex1-1);
    }

    @Test
    public void addSkillTest(){
        ArrayList<Resume> list = DataLoader.getResumes();
        Resume r = list.get(0);
        int sk1 = r.getSkills().size();
        String skil = "testy";

        r.AddSkill(skil);

        int sk2 = r.getSkills().size();

        assertEquals(sk2, sk1+1);
    }

    @Test
    public void removeSkillTest(){
        ArrayList<Resume> list = DataLoader.getResumes();
        Resume r = list.get(0);
        String skil = "testy";
        int sk1 = r.getSkills().size();

        r.removeSkill(skil);

        int sk2 = r.getSkills().size();

        assertEquals(sk2, sk1-1);
    }
}