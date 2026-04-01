import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // ============================================================
        // UC6: Mapping bogies to their seating/load capacity
        // ============================================================

        System.out.println("\n=== UC6: Bogie to Capacity Mapping ===");

        // Create HashMap to store bogie and capacity
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // ---------------------------
        // Insert bogie capacity data
        // ---------------------------
        System.out.println("\nAdding bogie capacities...");

        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 54);
        bogieCapacityMap.put("First Class", 24);

        // ---------------------------
        // Display bogie capacity data
        // ---------------------------
        System.out.println("\nBogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(
                    "Bogie: " + entry.getKey() +
                            " | Capacity: " + entry.getValue()
            );
        }

        // ---------------------------
        // Example lookup
        // ---------------------------
        System.out.println("\nCapacity lookup for Sleeper bogie:");
        System.out.println("Sleeper capacity: " + bogieCapacityMap.get("Sleeper"));

        System.out.println("\nProgram execution completed.");
    }
}