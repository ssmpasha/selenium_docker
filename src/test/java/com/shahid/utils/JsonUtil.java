package com.shahid.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shahid.tests.vendorportal.model.VendorPortalTestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class JsonUtil {
    public static final Logger log= LoggerFactory.getLogger(JsonUtil.class);
    public static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T getTestData(String path, Class<T> type)  {
        try(InputStream stream=ResourceLoader.getResource(path)){
            return mapper.readValue(stream, type);
        }catch (Exception e){
            log.error("Unable to read the test data {}", path, e);
            return null;
        }

    }
}
