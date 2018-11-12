package com.dataflow.sample;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void StringIsMasked() {
        final String input = "INPUT";
        String masked = Utils.mask(input, '#');
        assertEquals("#####", masked);
    }

    @Test
    public void ObjectIsMasked() {
        final Object input = "INPUT";
        String masked = Utils.mask(input.toString(), '#');
        assertEquals("#####", masked);
    }

    @Test
    public void orderIsPartiallyMasked() throws JsonParseException, JsonMappingException, IOException {
        String json = getFile("order.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        MasterOrder masterOrder = mapper.readValue(json, MasterOrder.class);

        List<DeliveryDetail> deliveryDetails = masterOrder.getDeliveryDetails();
        for (DeliveryDetail deliveryDetail : deliveryDetails) {
            Object contactDetailsNickname = deliveryDetail.getContactDetailsNickName();
            if (contactDetailsNickname != null && !contactDetailsNickname.toString().isEmpty()) {
                deliveryDetail.setContactDetailsNickName(Utils.mask(contactDetailsNickname.toString(), '#'));
            }
        }
        masterOrder.setDeliveryDetails(deliveryDetails);
        assertEquals("######################", masterOrder.getDeliveryDetails().get(0).getContactDetailsNickName());
    }

    @Test
    public void valuesAreRounded() {
        double value = 1.5499999999999999999999999;
        double expected = 1.55;
        double actual = Utils.round(value);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void nullValuesAreIgnored() {
        Double value = null;
        double expected = 0;
        double actual = Utils.round(value);
        assertEquals(expected, actual, 0);
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