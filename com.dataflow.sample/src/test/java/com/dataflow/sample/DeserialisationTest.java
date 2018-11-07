package com.dataflow.sample;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import org.junit.Test;

public class DeserialisationTest {

    @Test
    public void masterOrderIsDeserialised() throws JsonParseException, JsonMappingException, IOException {
        String json = getFile("order3.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        MasterOrder masterOrder = mapper.readValue(json, MasterOrder.class);
        double expected = 0.0;
        assertEquals(Double.valueOf(expected), masterOrder.getOrderItems().get(0).getDutyRate());
    }

    private String getFile(String fileName) {

        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}