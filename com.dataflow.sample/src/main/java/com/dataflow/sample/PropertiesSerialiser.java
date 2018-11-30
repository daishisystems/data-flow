package com.dataflow.sample;

import java.io.IOException;
import java.util.Map.Entry;

import com.deviceatlas.cloud.deviceidentification.client.IncorrectPropertyTypeException;
import com.deviceatlas.cloud.deviceidentification.client.Properties;
import com.deviceatlas.cloud.deviceidentification.client.Property;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesSerialiser extends StdSerializer<Properties> {

    private static final long serialVersionUID = -8166113490400612671L;
    private static final Logger LOG = LoggerFactory.getLogger(App.class); 
    //FIXME: Throw the error, or pass a logger (ideally throw)

    public PropertiesSerialiser() {
        this(null);
    }

    public PropertiesSerialiser(Class<Properties> properties) {
        super(properties);
    }

    @Override
    public void serialize(Properties value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeStartObject();
        for (Entry<String, Property> entry : value.entrySet()) {
            if (entry.getValue().getDataTypeId() == 0) {
                try {
                    gen.writeBooleanField(entry.getKey(), entry.getValue().asBoolean());
                } catch (IncorrectPropertyTypeException e) {
                    String errorMessage = String.format("Unable to cast {0} as Boolean", value);
                    LOG.error(errorMessage, e.getStackTrace(), value);
                }
            } else if (entry.getValue().getDataTypeId() == 3) {
                try {
                    gen.writeNumberField(entry.getKey(), entry.getValue().asInteger());
                } catch (IncorrectPropertyTypeException e) {
                    String errorMessage = String.format("Unable to cast {0} as Integer", value);
                    LOG.error(errorMessage, e.getStackTrace(), value);
                }
            } else if (entry.getValue().getDataTypeId() == 7) {
                gen.writeStringField(entry.getKey(), entry.getValue().asString());
            }
        }
        gen.writeEndObject();
    }
}