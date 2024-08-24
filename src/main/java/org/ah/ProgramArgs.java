package org.ah;
import org.ah.Models.Model;

import java.util.Map;

public class ProgramArgs{
    double minutes;
    double money;
    Model model;
    Map<String, String> configs;

    public ProgramArgs(double minutes, double money, Model model, Map<String, String> configs){
        this.minutes = minutes;
        this.money = money;
        this.model = model;
        this.configs = configs;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getMoney() {
        return money;
    }

    public Model getModel() {
        return model;
    }

    public Map<String, String> getConfigs() {
        return configs;
    }
}
