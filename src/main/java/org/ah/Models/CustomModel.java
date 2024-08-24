package org.ah.Models;

import java.util.HashMap;
import java.util.Map;

public class CustomModel implements Model{
    private double monetaryValueOfOneHour;
    private Map<String, String> configs = new HashMap<>();

    public CustomModel(int monetaryValueOfOneHour, Map<String, String> configs) {
        this.monetaryValueOfOneHour = monetaryValueOfOneHour;
        this.configs = configs;
    }
    public CustomModel() {
    }

    @Override
    public double getMonetaryValueOfOneHour() {
        return monetaryValueOfOneHour;
    }
    @Override
    public void setMonetaryValueOfOneHour(double monetaryValueOfOneHour){
        this.monetaryValueOfOneHour = monetaryValueOfOneHour;
    }

    @Override
    public Map<String, String> getConfigs() {
        return configs;
    }
    @Override
    public void setConfigs(Map<String, String> configs) {
        this.configs = configs;
    }
    @Override
    public void addConfigs(String key, String value) {
        configs.put(key, value);
    }
}
