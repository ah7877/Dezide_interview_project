package org.ah;
import org.ah.Models.Model;
import java.util.Map;

public class CostConverter {
    private  Map<String, Double> discreteValues = Map.of("low",1.1, "medium", 1.3,"high", 2.0, "none", 1.0);

    public long complexConvert(double minutes, double money, Model model, Map<String, String> customConfigs){

        double initialCostConversion = initialConversionFormula(minutes, money, model);

        Map<String, String> configs = model.getConfigs();
        configs.putAll(customConfigs);

        double res = initialCostConversion;
        for (Map.Entry<String, String> entry : configs.entrySet()) {
            res *= discreteValues.get(entry.getValue());
        }

        return Math.round(res);
    }

    public long simpleConvert(double minutes, double money, Model model){
        return Math.round(initialConversionFormula(minutes, money, model));
    }

    private double initialConversionFormula(double minutes, double money, Model model){
        return timeConverter.minutesToHours(minutes) * model.getMonetaryValueOfOneHour() + money;
    }

}
