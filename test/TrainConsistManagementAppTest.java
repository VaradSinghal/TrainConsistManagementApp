import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private List<Bogie> createBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("Sleeper", 80));
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = TrainConsistManagementApp.filterUsingLoop(createBogies());

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = TrainConsistManagementApp.filterUsingStream(createBogies());

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createBogies();

        List<Bogie> loopResult = TrainConsistManagementApp.filterUsingLoop(bogies);
        List<Bogie> streamResult = TrainConsistManagementApp.filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createBogies();

        long start = System.nanoTime();
        TrainConsistManagementApp.filterUsingLoop(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Test", i % 100));
        }

        List<Bogie> loopResult = TrainConsistManagementApp.filterUsingLoop(bogies);
        List<Bogie> streamResult = TrainConsistManagementApp.filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }
}