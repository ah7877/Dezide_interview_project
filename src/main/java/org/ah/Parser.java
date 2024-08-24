package org.ah;
import org.ah.Models.Model;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    private final Reader Reader = new Reader();


    public ProgramArgs mainArgs(String[] args){
        // initializing variables to store values from args
        double minutes = 0;
        double money = 0;
        String modelID = args[2];
        Map<String, String> customConfigs = new HashMap<>();

        //finding model from ID
        Model model = Reader.getModelFromID(modelID);

        try {
            // trying to parse input to double
            minutes = Double.parseDouble(args[0]);
            money = Double.parseDouble(args[1]);

            // trying to add key value pairs to the customConfig hashmap
            for(int i = 3; i < args.length; i++){
                String[] config = args[i].split(":");
                customConfigs.put(config[0].toLowerCase(), config[1].toLowerCase());
            }
        } catch (NumberFormatException e) {
            System.out.println("The first and second argument must be a double, representing minutes and money respectively.");
        } catch (Exception e) {
            System.out.println("Something wrong with the input arguments, they should be written as: <time> <money> <model> [<name1>:<value1>,...,namen:valuen]");
        }

        return new ProgramArgs(minutes, money, model, customConfigs);
    }
}

