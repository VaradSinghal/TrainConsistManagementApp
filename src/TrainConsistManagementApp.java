import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList to store passenger bogies
        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train consist initialized.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // ---------------------------
        // ADD Passenger Bogies
        // ---------------------------
        System.out.println("\nAdding passenger bogies...");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        // Display bogies after insertion
        System.out.println("Current Train Consist: " + trainConsist);

        // ---------------------------
        // REMOVE a bogie
        // ---------------------------
        System.out.println("\nRemoving 'AC Chair' bogie...");
        trainConsist.remove("AC Chair");

        // Display after removal
        System.out.println("Train Consist after removal: " + trainConsist);

        // ---------------------------
        // CHECK existence of bogie
        // ---------------------------
        System.out.println("\nChecking if 'Sleeper' bogie exists...");

        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie is present in the train.");
        } else {
            System.out.println("Sleeper bogie is NOT present in the train.");
        }

        // ---------------------------
        // FINAL STATE
        // ---------------------------
        System.out.println("\nFinal Train Consist: " + trainConsist);
        System.out.println("Total number of bogies: " + trainConsist.size());

        System.out.println("\nProgram execution completed.");
    }
}