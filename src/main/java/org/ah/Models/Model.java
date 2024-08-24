package org.ah.Models;

import java.util.Map;

public interface Model {
    double getMonetaryValueOfOneHour();
    void setMonetaryValueOfOneHour(double monetaryValueOfOneHour);
    Map<String, String> getConfigs();
    public void addConfigs(String key, String value);
    public void setConfigs(Map<String, String> configs);
}
