import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // ============================================================
        // UC4: Ordered Train Consist using LinkedList
        // ============================================================

        System.out.println("\n=== UC4: Maintaining Ordered Train Consist ===");

        // Create LinkedList to represent train bogie order
        LinkedList<String> train = new LinkedList<>();

        // ---------------------------
        // Add bogies to train
        // ---------------------------
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(train);

        // ---------------------------
        // Insert Pantry Car at position 2
        // ---------------------------
        System.out.println("\nInserting Pantry Car at position 2...");
        train.add(2, "Pantry");

        System.out.println("Train after Pantry insertion:");
        System.out.println(train);

        // ---------------------------
        // Remove first and last bogie
        // ---------------------------
        System.out.println("\nDetaching first and last bogies...");
        train.removeFirst();
        train.removeLast();

        // ---------------------------
        // Final Train Order
        // ---------------------------
        System.out.println("\nFinal Ordered Train Consist:");
        for (String bogie : train) {
            System.out.println(bogie);
        }

        System.out.println("\nTotal bogies remaining: " + train.size());
    }
}