import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // ---------------------------
        // UC2: Passenger Bogies using ArrayList
        // ---------------------------
        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train consist initialized.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        System.out.println("\nAdding passenger bogies...");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("Current Train Consist: " + trainConsist);

        System.out.println("\nRemoving 'AC Chair' bogie...");
        trainConsist.remove("AC Chair");

        System.out.println("Train Consist after removal: " + trainConsist);

        System.out.println("\nChecking if 'Sleeper' bogie exists...");

        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie is present in the train.");
        } else {
            System.out.println("Sleeper bogie is NOT present in the train.");
        }

        System.out.println("\nFinal Train Consist: " + trainConsist);
        System.out.println("Total number of bogies: " + trainConsist.size());

        // ============================================================
        // UC3: Track Unique Bogie IDs using HashSet
        // ============================================================

        System.out.println("\n=== UC3: Tracking Unique Bogie IDs ===");

        // Create HashSet to store unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        System.out.println("\nAdding bogie IDs (including duplicates)...");

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display unique bogie IDs
        System.out.println("\nUnique Bogie IDs in Train:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println("\nTotal unique bogies: " + bogieIds.size());

        System.out.println("\nProgram execution completed.");
    }
}