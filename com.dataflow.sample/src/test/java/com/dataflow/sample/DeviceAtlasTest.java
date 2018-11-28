package com.dataflow.sample;

import java.util.HashMap;
import java.util.Map;

import com.deviceatlas.cloud.deviceidentification.cacheprovider.CacheException;
import com.deviceatlas.cloud.deviceidentification.cacheprovider.EhCacheCacheProvider;
import com.deviceatlas.cloud.deviceidentification.client.Client;
import com.deviceatlas.cloud.deviceidentification.client.ClientException;
import com.deviceatlas.cloud.deviceidentification.client.IncorrectPropertyTypeException;
import com.deviceatlas.cloud.deviceidentification.client.Properties;
import com.deviceatlas.cloud.deviceidentification.client.Result;

import org.junit.Test;

public class DeviceAtlasTest {

    @Test
    public void devicePropertiesAreDeterminedFromUserAgent() {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko");

        try {
            Client client = Client.getInstance(new EhCacheCacheProvider());
            client.setLicenceKey("940587294e780cf8ccf52f1162ac2db7");

            // Result result = client.getResultByHeaders(headers);
            Result result = client
                    .getResultByUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");

            Properties properties = result.getProperties();

            if (properties.containsKey("mobileDevice") && properties.get("mobileDevice").asBoolean()) {
                /* example 1: Get the screen width for image optimization */
                int displayWidth = properties.containsKey("displayWidth") ? properties.get("displayWidth").asInteger()
                        : 100;

                /* example 2: Get the device vendor name */
                String vendor = properties.containsKey("vendor") ? properties.get("vendor").asString() : "";

                /* example 3: Touch screen optimization */
                boolean useBiggerIcons = properties.containsKey("touchScreen")
                        ? properties.get("touchScreen").asBoolean()
                        : false;

                /* example 4: Send Geo Location JS to client? */
                boolean supportsGeoLocation = properties.containsKey("js.geoLocation")
                        ? properties.get("js.geoLocation").asBoolean()
                        : false;
            }

        } catch (CacheException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (IncorrectPropertyTypeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}