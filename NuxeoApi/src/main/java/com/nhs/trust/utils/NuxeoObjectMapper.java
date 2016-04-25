
package com.nhs.trust.utils;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * 
 * @author arif.mohammed
 *
 */

@Component
public class NuxeoObjectMapper extends ObjectMapper {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NuxeoObjectMapper() {
        //registerModule(new NuxeoModule()).disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
		registerModule(new NuxeoModule()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

class NuxeoModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public NuxeoModule() {
        addDeserializer(String.class, new StdScalarDeserializer<String>  (String.class) {
			private static final long serialVersionUID = 1L;

			@Override
            public String deserialize(JsonParser jp, DeserializationContext  ctxt) throws IOException,
                JsonProcessingException {
                return StringUtils.trim(jp.getValueAsString());
            }
        });
    }
}
}
