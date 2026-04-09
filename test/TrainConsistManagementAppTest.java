import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // Helper method to create bogie list
    private List<Bogie> createBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("General", 90));
        list.add(new Bogie("Second Sitting", 70));
        return list;
    }

    // Common filter logic
    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = createBogies();
        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
        assertTrue(result.size() > 0);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = createBogies();
        List<Bogie> result = filterBogies(bogies, 70);

        // Capacity exactly 70 should NOT be included
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = createBogies();
        List<Bogie> result = filterBogies(bogies, 70);

        // Ensure no capacity < 70 exists
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = createBogies();
        List<Bogie> result = filterBogies(bogies, 60);

        // Should return multiple bogies (72 and 90)
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = createBogies();
        List<Bogie> result = filterBogies(bogies, 100);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = createBogies();
        List<Bogie> result = filterBogies(bogies, 10);

        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        List<Bogie> result = filterBogies(bogies, 50);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = createBogies();
        int originalSize = bogies.size();

        List<Bogie> result = filterBogies(bogies, 60);

        // Original list should remain unchanged
        assertEquals(originalSize, bogies.size());
        assertNotSame(bogies, result); // new list should be created
    }
}