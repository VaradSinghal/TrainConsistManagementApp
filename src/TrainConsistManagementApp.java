import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Bogie class
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

// Main application class
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create list
        List<Bogie> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        // ================= UC7 =================
        System.out.println("\n=== UC7: Sorting Passenger Bogies by Capacity ===");

        System.out.println("\nBefore Sorting:");
        passengerBogies.forEach(System.out::println);

        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nAfter Sorting:");
        passengerBogies.forEach(System.out::println);

        // ================= UC8 =================
        System.out.println("\n=== UC8: Filter Passenger Bogies (Capacity > 60) ===");

        // Stream filtering
        List<Bogie> filteredBogies = passengerBogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        // Display filtered result
        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the filter condition.");
        } else {
            filteredBogies.forEach(System.out::println);
        }

        // Verify original list unchanged
        System.out.println("\nOriginal List (Unchanged):");
        passengerBogies.forEach(System.out::println);

        System.out.println("\nProgram execution completed.");
    }
}