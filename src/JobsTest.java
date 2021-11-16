package src;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class JobsTest {


@Test
public void Testhavejob(){
    DatabaseManager db = DatabaseManager.getInstance();
    Jobs testJobs = db.getJobs();

    String title = "Apple";

    assertTrue(testJobs.haveJob(title));
}

@Test
public void Testsavejobs(){
    //calls datawriter save 

}

@Test
public void Testaddjob(){
    DatabaseManager db = DatabaseManager.getInstance();
        Jobs testJobs = db.getJobs();
        ArrayList<Job> ex1 = testJobs.getJobList();
        Job testJob = ex1.get(0);
        testJobs.addJob(testJob);
        Arraylist<Job> testJobs2 = testJobs.getJobList();
        assertEquals(testJobs2.size(), testJobs.size()+1)



@Test
public void Testremovejob(){
    DatabaseManager db = DatabaseManager.getInstance();
        Jobs testJobs = db.getJobs();
        ArrayList<Job> ex1 = testJobs.getJobList();
        Job testJob = ex1.get(0);
        testJobs.removeJob(testJob.getID());
        Arraylist<Job> testJobs2 = testJobs.getJobList();
        assertEquals(testJobs2.size(), testJobs.size()-1)
          
}
}
