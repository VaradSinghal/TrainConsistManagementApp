import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Bogie class defined in the same file
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
        System.out.println("\n=== UC7: Sorting Passenger Bogies by Capacity ===");

        // Create list to store bogie objects
        List<Bogie> passengerBogies = new ArrayList<>();

        // Add passenger bogies
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        // Display before sorting
        System.out.println("\nBefore Sorting:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // Sort bogies using Comparator based on capacity
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Display after sorting
        System.out.println("\nAfter Sorting by Capacity (Ascending):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        System.out.println("\nProgram execution completed.");
    }
}