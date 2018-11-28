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

import org.junit.Test;

public class DeviceAtlasTest {

    @Test
    public void devicePropertiesAreDeterminedFromUserAgent() throws CacheException, ClientException {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");

        Client client = Client.getInstance(new EhCacheCacheProvider());
        client.setLicenceKey("940587294e780cf8ccf52f1162ac2db7");

        try {
            Result result = client.getResult(headers);
            Properties properties = result.getProperties();

            assertTrue(properties.containsKey("vendor"));
            assertEquals("Google", properties.get("vendor").value());
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }
    }
}