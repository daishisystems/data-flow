package com.dataflow.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.deviceatlas.cloud.deviceidentification.cacheprovider.CacheException;
import com.deviceatlas.cloud.deviceidentification.cacheprovider.EhCacheCacheProvider;
import com.deviceatlas.cloud.deviceidentification.client.Client;
import com.deviceatlas.cloud.deviceidentification.client.ClientException;
import com.deviceatlas.cloud.deviceidentification.client.Properties;
import com.deviceatlas.cloud.deviceidentification.client.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import org.junit.Test;

public class DeviceAtlasTest {

    @Test
    public void devicePropertiesAreDeterminedFromUserAgent()
            throws CacheException, ClientException, JsonProcessingException {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("user-agent",
                "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.0 Mobile/15E148 Safari/604.1");

        Client client = Client.getInstance(new EhCacheCacheProvider());
        client.setLicenceKey("940587294e780cf8ccf52f1162ac2db7");

        try {
            Result result = client.getResult(headers);
            Properties properties = result.getProperties();

            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addSerializer(Properties.class, new PropertiesSerialiser());
            mapper.registerModule(module);

            assertTrue(properties.containsKey("vendor"));
            assertEquals("Apple", properties.get("vendor").value());
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }
    }
}