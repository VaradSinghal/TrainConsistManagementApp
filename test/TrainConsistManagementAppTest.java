import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(Validator.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(Validator.isValidTrainId("TRAIN12"));
        assertFalse(Validator.isValidTrainId("TRN12A"));
        assertFalse(Validator.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(Validator.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Validator.isValidCargoCode("PET-ab"));  // lowercase
        assertFalse(Validator.isValidCargoCode("PET123"));
        assertFalse(Validator.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Validator.isValidTrainId("TRN-123"));   // 3 digits
        assertFalse(Validator.isValidTrainId("TRN-12345")); // 5 digits
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Validator.isValidCargoCode("PET-Ab"));
        assertFalse(Validator.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(Validator.isValidTrainId(""));
        assertFalse(Validator.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(Validator.isValidTrainId("TRN-1234XYZ"));
        assertFalse(Validator.isValidCargoCode("PET-AB123"));
    }
}