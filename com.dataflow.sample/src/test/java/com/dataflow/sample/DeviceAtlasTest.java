package com.dataflow.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.deviceatlas.cloud.deviceidentification.cacheprovider.CacheException;
import com.deviceatlas.cloud.deviceidentification.cacheprovider.EhCacheCacheProvider;
import com.deviceatlas.cloud.deviceidentification.client.Client;
import com.deviceatlas.cloud.deviceidentification.client.ClientException;
import com.deviceatlas.cloud.deviceidentification.client.Properties;
import com.deviceatlas.cloud.deviceidentification.client.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class DeviceAtlasTest {

    @Test
    public void devicePropertiesAreDeterminedFromHttpHeaders() throws CacheException, ClientException, IOException {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Origin", "https://pay.intrend.it");
        headers.put("Max-Forwards", "10");
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("X-Original-URL", "/api/v2/Order/44e902e4-3a5c-4786-9221-cd1f8fba7c13/ContactDetails");
        headers.put("Connection", "Keep-Alive");
        headers.put("Referer", "https://pay.intrend.it/44e902e4-3a5c-4786-9221-cd1f8fba7c13");
        headers.put("User-Agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.0.2 Safari/605.1.15");
        headers.put("Host", "checkout-api-diftes.production.eshopworld.com");
        headers.put("Accept-Encoding", "br, gzip, deflate");
        headers.put("X-FORWARDED-PROTO", "https");
        headers.put("X-Forwarded-For", "84.237.161.33:59361");
        headers.put("FingerprintId", "2abc73d120a8c080ce4c77b6ea88222fc756df6e853ab09a039e3f10bdf4c130");
        headers.put("X-ORIGINAL-HOST", "checkout-api-diftes.production.eshopworld.com");
        headers.put("Accept-Language", "ru");
        headers.put("Content-Length", "305");
        headers.put("X-FORWARDED-PORT", "443");
        headers.put("X-ARR-SSL",
                "2048|128|C=US, S=Arizona, L=Scottsdale, O=\"GoDaddy.com, Inc.\", OU=http://certs.godaddy.com/repository/, CN=Go Daddy Secure Certificate Authority - G2|OU=Domain Control Validated, CN=*.production.eshopworld.com");
        headers.put("X-ARR-LOG-ID", "aabc2c4a-28e7-4530-a402-7d5d988f7c63");
        headers.put("$id", "1");
        headers.put("Content-Type", "application/json");

        Client client = Client.getInstance(new EhCacheCacheProvider());
        client.setLicenceKey("940587294e780cf8ccf52f1162ac2db7");

        try {
            Result result = client.getResult(headers);
            Properties properties = result.getProperties();

            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addSerializer(Properties.class, new PropertiesSerialiser());
            mapper.registerModule(module);
            mapper.registerModule(new JodaModule());

            // FIXME: Split into multiple tests.
            String serialised = mapper.writeValueAsString(properties);
            DeviceAtlasProperties deviceAtlasProperties = mapper.readValue(serialised, DeviceAtlasProperties.class);
            Long created = 1544020041615l;
            String dt = new DateTime(created).withZone(DateTimeZone.UTC).toString();
            deviceAtlasProperties.setCreated(dt);

            assertTrue(properties.containsKey("vendor"));
            assertEquals("Apple", properties.get("vendor").value());
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }
    }
}