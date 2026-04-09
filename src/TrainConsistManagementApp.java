import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Utility class for validation
class Validator {

    // Regex patterns
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    private static final Pattern trainPattern = Pattern.compile(TRAIN_ID_REGEX);
    private static final Pattern cargoPattern = Pattern.compile(CARGO_CODE_REGEX);

    // Validate Train ID
    public static boolean isValidTrainId(String trainId) {
        if (trainId == null) return false;
        Matcher matcher = trainPattern.matcher(trainId);
        return matcher.matches();
    }

    // Validate Cargo Code
    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Matcher matcher = cargoPattern.matcher(cargoCode);
        return matcher.matches();
    }
}

// Main class
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n=== UC11: Validate Train ID & Cargo Code ===");

        // Sample inputs (you can replace with Scanner input)
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        boolean isTrainValid = Validator.isValidTrainId(trainId);
        boolean isCargoValid = Validator.isValidCargoCode(cargoCode);

        System.out.println("Train ID: " + trainId + " -> " + (isTrainValid ? "Valid" : "Invalid"));
        System.out.println("Cargo Code: " + cargoCode + " -> " + (isCargoValid ? "Valid" : "Invalid"));

        System.out.println("\nProgram execution completed.");
    }
}