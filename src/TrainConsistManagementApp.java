import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // ============================================================
        // UC5: Preserve insertion order and uniqueness using LinkedHashSet
        // ============================================================

        System.out.println("\n=== UC5: Train Formation with LinkedHashSet ===");

        // Create LinkedHashSet to store train bogies
        Set<String> trainFormation = new LinkedHashSet<>();

        // ---------------------------
        // Attach bogies to train
        // ---------------------------
        System.out.println("\nAttaching bogies to train...");

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to add duplicate bogie
        System.out.println("Attempting to attach duplicate bogie: Sleeper");
        trainFormation.add("Sleeper");  // duplicate, ignored automatically

        // ---------------------------
        // Display final formation
        // ---------------------------
        System.out.println("\nFinal Train Formation (Insertion Order Preserved):");
        for (String bogie : trainFormation) {
            System.out.println(bogie);
        }

        System.out.println("\nTotal bogies in formation: " + trainFormation.size());
    }
}