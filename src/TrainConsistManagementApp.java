import java.util.*;
import java.util.stream.*;

// Goods Bogie class
class GoodsBogie {
    private String type;   // Cylindrical, Open, Box
    private String cargo;  // Petroleum, Coal, Grain

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " (Cargo: " + cargo + ")";
    }
}

// Main class
public class TrainConsistManagementApp {

    // Safety validation method
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n=== UC12: Safety Compliance Check ===");

        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = isTrainSafe(goodsBogies);

        System.out.println("Train Safety Status: " + (isSafe ? "SAFE" : "UNSAFE"));

        System.out.println("\nBogies:");
        goodsBogies.forEach(System.out::println);

        System.out.println("\nProgram execution completed.");
    }
}