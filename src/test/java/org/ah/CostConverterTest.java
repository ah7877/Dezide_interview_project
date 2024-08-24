package org.ah;
import org.ah.Models.CustomModel;
import org.ah.Models.Model;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class CostConverterTest {

    @Test
    void complexConvert() {
        // Arrange
        double minutes = 0.5;
        double money = 275.5;

        Map<String, String> modelConfigs = new HashMap<>();
        modelConfigs.put("risk", "high");
        modelConfigs.put("inconvenience", "medium");
        Model model = new CustomModel(500, modelConfigs);

        Map<String, String> customConfigs = new HashMap<>();
        customConfigs.put("inconvenience", "none");
        CostConverter costConverter = new CostConverter();


        // Act
        long test1 = costConverter.complexConvert(minutes, money, model, customConfigs);


        // Assert
        assertEquals(test1, 559);
    }
}