import java.util.*;
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

// Main class
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("Sleeper", 80));

        // ================= UC10 =================
        System.out.println("\n=== UC10: Total Seating Capacity ===");

        int totalCapacity = passengerBogies.stream()
                .map(Bogie::getCapacity)   // extract capacity
                .reduce(0, Integer::sum); // sum all values

        System.out.println("Total Seating Capacity: " + totalCapacity);

        // Verify original list unchanged
        System.out.println("\nOriginal List:");
        passengerBogies.forEach(System.out::println);

        System.out.println("\nProgram execution completed.");
    }
}