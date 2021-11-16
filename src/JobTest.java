package src;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.UUID;
public class JobTest {
    @Test
    public void Testaddapplicant(){
        DatabaseManager db = DatabaseManager.getInstance();
        ArrayList<String> example = new ArrayList<>();
        example.add("test");
        int wordFound=0;
        for(int i=0; i<example.size();i++){
            if(example.get(i)=="test")
            wordFound++;
        }
        assertTrue(wordFound>0);
    }
    @Test
public void Testremoveapplicant(){
    DatabaseManager db = DatabaseManager.getInstance();
    ArrayList<String> example = new ArrayList<>();
    example.add("test");
    example.remove("test");
    int wordFound=0;
    for(int i=0; i<example.size();i++){
        if(example.get(i)=="test")
        wordFound++;
    }
    assertFalse(wordFound>0);
}
@Test
public void Testcontainword(){
    DatabaseManager db = DatabaseManager.getInstance();
        Jobs testJobs = db.getJobs();
        ArrayList<Job> ex1 = testJobs.getJobList();
        Job testJob = ex1.get(0);
        assertFalse(testJob.containsWord("0002030657"));
}

}
