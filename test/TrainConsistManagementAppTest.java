import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // Helper method
    private List<Bogie> createBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("Sleeper", 80));
        return list;
    }

    // Reduce method
    private int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = createBogies();
        int total = calculateTotalCapacity(bogies);

        int expected = 72 + 56 + 24 + 80;
        assertEquals(expected, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = createBogies();
        int total = calculateTotalCapacity(bogies);

        assertTrue(total > 0);
        assertEquals(232, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = List.of(new Bogie("Sleeper", 70));

        int total = calculateTotalCapacity(bogies);

        assertEquals(70, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = calculateTotalCapacity(bogies);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createBogies();

        List<Integer> capacities = bogies.stream()
                .map(Bogie::getCapacity)
                .collect(Collectors.toList());

        assertTrue(capacities.contains(72));
        assertTrue(capacities.contains(56));
        assertTrue(capacities.contains(24));
        assertTrue(capacities.contains(80));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createBogies();

        int total = calculateTotalCapacity(bogies);

        int manualSum = 0;
        for (Bogie b : bogies) {
            manualSum += b.getCapacity();
        }

        assertEquals(manualSum, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = createBogies();
        int originalSize = bogies.size();

        int total = calculateTotalCapacity(bogies);

        assertEquals(originalSize, bogies.size());
        assertTrue(total > 0);
    }
}