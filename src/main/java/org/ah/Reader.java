package org.ah;
import org.ah.Models.CustomModel;
import org.ah.Models.Model;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

import java.io.File;

public class Reader {
    public Model getModelFromID(String modelId){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Load the JSON file from the classpath
            InputStream inputStream = Reader.class.getClassLoader().getResourceAsStream("models.json");
            if (inputStream == null) {
                throw new IOException("Resource not found: models.json");
            }

            // Parse the JSON file
            JsonNode rootNode = objectMapper.readTree(inputStream);

            // Select the desired model or fallback to globalModel
            JsonNode selectedNode = rootNode.path(modelId).isMissingNode() ? rootNode.path("globalModel") : rootNode.path(modelId);

            // Map the JsonNode to a Model object
            return objectMapper.treeToValue(selectedNode, CustomModel.class);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
