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
        passengerBogies.add(new Bogie("Sleeper", 80)); // duplicate type
        passengerBogies.add(new Bogie("AC Chair", 60));

        // ================= UC9 =================
        System.out.println("\n=== UC9: Group Bogies by Type ===");

        Map<String, List<Bogie>> groupedBogies = passengerBogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // Display grouped result
        groupedBogies.forEach((type, bogies) -> {
            System.out.println("\nType: " + type);
            bogies.forEach(System.out::println);
        });

        // Verify original list unchanged
        System.out.println("\nOriginal List:");
        passengerBogies.forEach(System.out::println);

        System.out.println("\nProgram execution completed.");
    }
}